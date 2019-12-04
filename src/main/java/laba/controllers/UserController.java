package laba.controllers;

import laba.objects.User;
import laba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "UserForms/login";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUserList(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("new_user", new User());
        return "UserForms/user_list";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("newUser") User user) {
        userService.addNewUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/delete/{name}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("name")String name) {
        userService.deleteUser(name);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/update/{name}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("name")String name, Model model) {
        model.addAttribute("user", userService.getByName(name));
        model.addAttribute("update_user", new User());
        return "UserForms/update_form";
    }

    @RequestMapping(value = "/users/updated", method = RequestMethod.POST)
    public String updatedProcessUser(@ModelAttribute("update_user")User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
}
