package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.Service.UserService;
import web.model.User;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String home(ModelMap model) {
        List<User> listUsers = userService.listAll();
        model.addAttribute("users", listUsers);
        return "index";
    }



}
