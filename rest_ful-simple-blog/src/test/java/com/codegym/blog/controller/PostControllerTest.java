package com.codegym.blog.controller;


import com.codegym.blog.service.CategoryService;
import com.codegym.blog.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitJupiterConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;
import java.util.Optional;


import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

;
@WebAppConfiguration
@SpringJUnitJupiterConfig(CustomerControllerTestConfig.class)
public class CustomerControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private PostController postController;



    @Autowired
    private PostService postService;


    @Autowired
    private CategoryService categoryService;

    @Test
    void postsListPageIsExists() throws Exception {
        mockMvc
                .perform((RequestBuilder) get("/post/"))
                .andExpect(status().is(200));
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(postController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build();
    }

    @Test
    void postBrowseControlling() throws Exception {
        mockMvc
                .perform((RequestBuilder) get("/posts/"))
                .andExpect(status().isOk())
                .andExpect(view().name("posts/browse"));
    }

    @GetMapping
    public ModelAndView showList(Optional<String> s, Pageable pageInfo) {
        ModelAndView modelAndView = new ModelAndView("posts/browse");
        return modelAndView;
    }

    @Test
    void postUpdateSuccessControlling() throws Exception {
        Post foo = new Post(1L, "Foo Bar", "a@dummy.im", "Nowhere");
        when(customerService.save(isA(Customer.class))).thenReturn(foo);

        mockMvc
                .perform(post("/customers")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("id", foo.getId().toString())
                        .param("name", foo.getName())
                        .param("email", foo.getEmail())
                        .param("address", foo.getAddress()))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/customers"));
    }
}