package com.example.demo.controller;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class HomeController {

    private final MessageSource messageSource;

    public HomeController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(value = "lang", defaultValue = "en") String lang) {
        Locale locale = Locale.forLanguageTag(lang);
        model.addAttribute("welcomeMessage", messageSource.getMessage("welcome.message", null, locale));
        model.addAttribute("greetingMessage", messageSource.getMessage("greeting.message", new Object[]{"User"}, locale));
        return "index";
    }
}

