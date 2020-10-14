package com.codegym.kiemtramodule4.controller;

import com.codegym.kiemtramodule4.model.City;
import com.codegym.kiemtramodule4.model.Nation;
import com.codegym.kiemtramodule4.service.city.CityService;
import com.codegym.kiemtramodule4.service.nation.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private NationService nationService;

    @ModelAttribute(name = "nation")
    public Page<Nation> nations(Pageable pageable) {
        return nationService.findAll(pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showCity(Model model, @PageableDefault(4) Pageable pageable) {
        Page<City> cities = cityService.findAll(pageable);
        model.addAttribute("cities", cities);
        return "city";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCity(HttpServletRequest request, RedirectAttributes redirect) {
        City city = new City();
        city.setCityName(request.getParameter("name"));
        city.setArea(Long.parseLong(request.getParameter("area")));
        city.setPopulation(Double.parseDouble(request.getParameter("population")));
        city.setGdp(Double.parseDouble(request.getParameter("gdp")));
        city.setDescription(request.getParameter("description"));
        Nation nation = nationService.findById(Integer.parseInt(request.getParameter("nation"))).get();
        city.setNation(nation);
        cityService.save(city);
        redirect.addFlashAttribute("successMessage", "Saved contact successfully!");
        return "redirect:/";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String deleteCity(@RequestParam("id") Integer id, RedirectAttributes redirect) {
        cityService.delete(id);
        redirect.addFlashAttribute("successMessage", "Deleted contact successfully!");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirect) {
        cityService.delete(id);
        redirect.addFlashAttribute("successMessage", "Deleted contact successfully!");
        return "redirect:/";
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") City city, Model model) {
        model.addAttribute("city", city);
        return "view";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView showEdit(@PathVariable(value = "id") Integer id) {
        City city = cityService.findById(id).get();
        ModelAndView mav = new ModelAndView("edit");
        mav.addObject("city", city);
        return mav;
    }

    @PostMapping(value = "/edit")
    public ModelAndView edit(@Validated @ModelAttribute("city") City city, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("edit");
        }
        cityService.save(city);
        redirect.addFlashAttribute("successMessage", "Edited contact successfully!");
        return new ModelAndView("redirect:/");
    }
}
