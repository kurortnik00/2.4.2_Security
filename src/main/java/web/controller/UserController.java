package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.Service.UserService;
import web.model.User;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/edit")
    public String editUserForm(ModelMap model, @RequestParam long id) {
        model.addAttribute("user", userService.get(id));
        return "editUser";
    }

    @GetMapping("/delete")
    public String deleteUserForm(@RequestParam long id) {
        userService.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String saveEditUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }
}
