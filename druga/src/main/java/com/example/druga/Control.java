package com.example.druga;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.time.Year;

@Controller
@RequestMapping("/")
public class Control {

    @GetMapping
    public String greetingForm(Model model) {
        model.addAttribute("user", new User());
        return "greeting";
    }

    @PostMapping
    public String greetingSubmit(@ModelAttribute User user, Model model) {
        int currentYear = Year.now().getValue();
        int age = currentYear - user.getRokUrodzenia();
        model.addAttribute("age", age);
        model.addAttribute("user", user);
        return "result";
    }
}
