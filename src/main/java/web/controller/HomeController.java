package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Service.UserService;
import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/userManager", "/admin"})
    public String home(ModelMap model) {
        List<User> listUsers = userService.listAll();
        model.addAttribute("users", listUsers);
        return "index";
    }

    @GetMapping(value = {"/", "/hello"})
    public String hello(ModelMap modelMap, @RequestParam long id) {
        modelMap.addAttribute("user", userService.get(id));
        modelMap.addAttribute("message", "Hello friend");
        return "hello";
    }





}
