package securitis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import securitis.model.User;
import securitis.service.UserServiceDao;

import java.util.List;

@Controller
@RequestMapping("")
public class adminController {
    @Autowired
    private UserServiceDao userServiceDao;


    @GetMapping("/")
    public String showAllUser(Model model) {

        List<User> allUser = userServiceDao.getAllUser();
        model.addAttribute("allUser", allUser);

        return "userList";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model){

        User user = new User();
        model.addAttribute("user",user);
        return "createUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userServiceDao.saveUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/update/{id}")
    public String updateUser(Model model, @PathVariable("id") Long id) {
        User user = userServiceDao.getUser(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @PutMapping("/update")
    public String edit(@ModelAttribute("user") User user) {
        userServiceDao.update(user);
        return "redirect:/";
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id){
        userServiceDao.deleteUser(id);
        return "redirect:/";
    }
}