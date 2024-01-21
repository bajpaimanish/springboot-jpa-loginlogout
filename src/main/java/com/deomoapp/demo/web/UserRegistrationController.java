package com.deomoapp.demo.web;

import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deomoapp.demo.service.UserService;
import com.deomoapp.demo.web.dto.UserRegistrationDto;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationController.class);

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    // If you are not setting the above model attribut you need to pass in the
    // GetMapping
    // @GetMapping
    // public String showRegistrationForm(Model model) {
    // model.addAttribute("user", new UserRegistrationDto());
    // return "registration";
    // }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
        try {
            userService.save(userRegistrationDto);
        } catch (Exception e) {
            LOGGER.error("An error occurred while doing something", e);
        }
        return "redirect:/registration?success";
    }

}
