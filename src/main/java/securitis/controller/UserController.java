package securitis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import securitis.model.User;
import securitis.service.UserServiceDao;

import java.util.List;

@Controller
@RequestMapping("")
public class UserController {

    private UserServiceDao userServiceDao;

    @Autowired
    public UserController(UserServiceDao userServiceDao) {
        this.userServiceDao = userServiceDao;
    }

    @GetMapping("/user")
    public String showAllUser(Model model) {
        List<User> user = userServiceDao.getAllUser();
        model.addAttribute("user_user", user);
        return "user";
    }
}
