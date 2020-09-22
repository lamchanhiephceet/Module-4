package com.codegym.cts.controller;

import com.codegym.cts.model.Category;
import com.codegym.cts.model.Contact;
import com.codegym.cts.service.CategoryService;
import com.codegym.cts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/")
    public ModelAndView listContacts(){
        Iterable<Contact> customers = contactService.findAll();
        ModelAndView modelAndView = new ModelAndView("/contact/list");
        modelAndView.addObject("contacts", customers);
        return modelAndView;
    }

    @GetMapping("/create-contact")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/contact/create");
        modelAndView.addObject("contact", new Contact());
        return modelAndView;
    }

    @PostMapping("/create-contact")
    public ModelAndView saveContact(@ModelAttribute("contact") Contact contact){
        contactService.save(contact);
        ModelAndView modelAndView = new ModelAndView("/contact/create");
        modelAndView.addObject("contact", new Contact());
        modelAndView.addObject("message", "New contact created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-contact/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Contact contact = contactService.findById(id);
        if(contact != null) {
            ModelAndView modelAndView = new ModelAndView("/contact/edit");
            modelAndView.addObject("contact", contact);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-contact")
    public ModelAndView updateContact(@ModelAttribute("contact") Contact contact){
        contactService.save(contact);
        ModelAndView modelAndView = new ModelAndView("/contact/edit");
        modelAndView.addObject("contact", contact);
        modelAndView.addObject("message", "Contact updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-contact/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Contact contact = contactService.findById(id);
        if(contact != null) {
            ModelAndView modelAndView = new ModelAndView("/contact/delete");
            modelAndView.addObject("contact", contact);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-contact")
    public String deleteCustomer(@ModelAttribute("contact") Contact contact){
        contactService.remove(contact.getId());
        return "redirect:/";
    }
}
