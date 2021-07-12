package securitis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import securitis.model.Role;
import securitis.model.User;
import securitis.service.RoleServiceDao;
import securitis.service.UserServiceDao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("")
public class adminController {

//    @GetMapping("/")
//    public String addNewUser(){
//        return "h";
//    }
    @Autowired
    private UserServiceDao userServiceDao;
    @Autowired
    private RoleServiceDao roleServiceDao;


    @GetMapping("/admin")
    public String showAllUser(Model model) {

        List<User> allUser = userServiceDao.getAllUser();
        model.addAttribute("allUser", allUser);

        return "userList";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model){

        User user = new User();
        model.addAttribute("user",user);
        model.addAttribute("roles", roleServiceDao.getAllRoles());
        return "createUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user,
                           @RequestParam(value = "roles_s") String[] role) {
        Set<Role> rolesSet = new HashSet<>();
        for (String roles : role) {
            rolesSet.add(roleServiceDao.getByName(roles));
        }
        user.setRoles(rolesSet);
        userServiceDao.saveUser(user);
        return "redirect:/admin";
    }

//
//    @GetMapping(value = "/update/{id}")
//    public String updateUser(Model model, @PathVariable("id") Long id) {
//        User user = userServiceDao.getUser(id);
//        model.addAttribute("user", user);
//        return "updateUser";
//    }
//
//    @PutMapping("/update")
//    public String edit(@ModelAttribute("user") User user) {
//        userServiceDao.update(user);
//        return "redirect:/";
//    }
//
//    @DeleteMapping("/deleteUser/{id}")
//    public String deleteUser(@PathVariable(name = "id") Long id){
//        userServiceDao.deleteUser(id);
//        return "redirect:/";
//    }


}