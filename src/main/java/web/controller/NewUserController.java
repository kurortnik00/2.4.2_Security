package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.Service.UserService;
import web.model.User;

@Controller
public class NewUserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/new")
    public String newUser(ModelMap model) {
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        return "newUserForm";
    }


}
