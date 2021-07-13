package securitis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import securitis.model.User;
import securitis.service.UserServiceDao;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("")
public class userController {

    @Autowired
    private UserServiceDao userServiceDao;

    @GetMapping("/user")
    public String showAllUser(Model model){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("user_user", userServiceDao.ByUserName(auth.getName()));
//        User user = userServiceDao.ByUserName(principal.getName());
//        model.addAttribute(user);
        List<User> user = userServiceDao.getAllUser();
        model.addAttribute("user_user", user);


//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("user_user", user);
//        //return "users";

//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("user_user", userDetails);

        return "user";


    }
}
