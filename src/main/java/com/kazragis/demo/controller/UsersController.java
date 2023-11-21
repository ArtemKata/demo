package com.kazragis.demo.controller;

import com.kazragis.demo.model.User;
import com.kazragis.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showUsers(Model model) {
        model.addAttribute("users", userService.showUsers());
        return "users";
    }
    @GetMapping("/show")
    public String show(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "show";
    }

    @GetMapping ("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user")  User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam("id") long id) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PatchMapping ("/update")
    public String update(@ModelAttribute("user") User user, @RequestParam("id") long id) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}









