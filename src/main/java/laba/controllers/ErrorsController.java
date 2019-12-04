package laba.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorsController {
    @RequestMapping(value = "/errors/{name_error}", method = RequestMethod.GET)
    public String showError(@PathVariable("name_error") String error, Model model) {
        model.addAttribute("name_error", error);
        return "error_page";
    }
}
