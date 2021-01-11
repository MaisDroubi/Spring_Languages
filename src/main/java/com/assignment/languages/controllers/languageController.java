package com.assignment.languages.controllers;

import com.assignment.languages.models.language;
import com.assignment.languages.services.languageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class languageController {
    private final languageService languageService;

    public languageController(languageService languageService) {
        this.languageService=languageService;
    }


    @RequestMapping("/")
    public String Index(Model model) {
        model.addAttribute("languages", languageService.alllanguages());
        return "index.jsp";
    }
    @RequestMapping("/{id}")
    public String Show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("language", languageService.findlanguage(id));
        return "show.jsp";
    }
    @RequestMapping("/new")
    public String New(@ModelAttribute("language") language language) {
        return "new.jsp";
    }
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String Create(@Valid @ModelAttribute("language") language lang, BindingResult result, @RequestParam Map<String,String> body) {
        if(result.hasErrors())
            return "new.jsp";
        languageService.createlanguage(lang);
        return "redirect:/";
    }
    @RequestMapping("/{id}/edit")
    public String Edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("language", languageService.findlanguage(id));
        return "edit.jsp";
    }
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String Update(@Valid @ModelAttribute("language") language language, BindingResult result) {
        if(result.hasErrors())
            return "edit.jsp";
        languageService.updatelanguage(language.getId(),language.getName(),language.getCreator(),language.getCurrentVersion());
        return "redirect:/";
    }
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String Delete(@PathVariable("id") Long id) {
        languageService.deletelanguage(id);
        return "redirect:/";
    }

}