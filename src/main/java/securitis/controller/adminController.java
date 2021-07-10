package securitis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import securitis.model.User;
import securitis.service.RoleServiceDao;
import securitis.service.UserServiceDao;
import securitis.service.UserServiceDaoImpl;

import java.util.List;

@Controller
@RequestMapping("")
public class adminController {
    @Autowired
    private UserServiceDao userServiceDao;
    @Autowired
    private RoleServiceDao roleServiceDao;

//    @Autowired
//    public adminController(UserServiceDao userServiceDao) {
//        this.userServiceDao = userServiceDao;
//    }

//    @GetMapping("/admin")
//    public String showAllUser(Model model) {
//
//        List<User> allUser = userServiceDao.getAllUser();
//        model.addAttribute("allUser", allUser);
//
//        return "userList";
//    }

//    @GetMapping(value = "/admin")
//    public String getAllUsers(ModelMap model) {
//        model.addAttribute("listUsers", userServiceDao.getAllUser());
//        model.addAttribute("allRoles", roleServiceDao.getRole());
//        model.addAttribute("newUser", new User());
//        return "admin";
//    }
    @GetMapping(value = "/admin")
    public String getAllUsers(ModelMap model) {
        return "hell";
    }
}
