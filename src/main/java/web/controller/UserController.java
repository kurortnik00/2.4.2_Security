package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.dao.RoleRepository;
import web.model.User;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepo;

    @GetMapping("/edit")
    @Transactional
    public String editUserForm(ModelMap model, @RequestParam long id) {
        model.addAttribute("user", userService.get(id));
        return "editUser";
    }

    @GetMapping("/delete")
    public String deleteUserForm(@RequestParam long id) {
        userService.delete(id);
        return "redirect:/userManager";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.save(user);
        return "redirect:/userManager";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String saveEditUser(@ModelAttribute("user") User user , @RequestParam(value = "checkboxName", required = false) String checkboxValue) {

        user.setRoles(userService.get(user.getId()).getRoles());
        System.out.println(user);
        if( checkboxValue!= null && checkboxValue.equals("on")) {
            user.addRole(roleRepo.findById(2L));
        }
        else {
            user.deleteRole(roleRepo.findById(2L).getName());
            System.out.println(user);
        }
        userService.update(user);
        return "redirect:/userManager";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }


}
