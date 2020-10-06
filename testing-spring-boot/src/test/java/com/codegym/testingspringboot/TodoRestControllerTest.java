package com.codegym.testingspringboot;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
// Bạn cần cung cấp lớp Controller cho @WebMvcTest
@WebMvcTest(TodoRestController.class)
public class TodoRestControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    TodoService todoService;

    @Test
    public void testFindAll() throws Exception {

        List<Todo> allTodos = IntStream.range(0, 10)
                                       .mapToObj(i -> new Todo(i, "title-" + i, "detail-" + i))
                                       .collect(Collectors.toList());


        given(todoService.getAll()).willReturn(allTodos);

        mvc.perform(get("/api/v1/todo").contentType(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$", hasSize(10)))
           .andExpect(jsonPath("$[0].id", is(0)))
           .andExpect(jsonPath("$[0].title", is("title-0")))
           .andExpect(jsonPath("$[0].detail", is("detail-0")));
    }
}