package web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping()
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String printAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String editeOldUser(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user";
    }

    @GetMapping("/newUser")
    public String openPageNewUser(Model model, @ModelAttribute("user") User user) {
        model.addAttribute("user", user);
        return "newUser";
    }

    @PostMapping("/users")
    public String createNewUser(@ModelAttribute("user") User user){
        userService.setUser(user);
        return "redirect:/users";
    }

    @PatchMapping("/{id}")
    public String updateOldUser(@PathVariable(name = "id") int id, @ModelAttribute(name = "user") User user){
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteOldUser(@PathVariable(name = "id") int id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}