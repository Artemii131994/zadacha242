//package securitis.service;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import securitis.dao.UserDAOImpl;
//import securitis.model.User;
//
//
//@Service
//@Transactional
//public class UserService implements UserDetailsService {
//
//
//    private UserDAOImpl userDao;
//    @Autowired
//    public UserService(UserDAOImpl userDao){
//        this.userDao = userDao;
//    }
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User user = userDao.loadUserByUserName(s);
//        if (user == null){
//            throw new UsernameNotFoundException("Unknown user: " + s);
//        }
//        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
//                .username(user.getUsername())
//                .password(user.getPassword())
//                .authorities(user.getAuthorities())
//                .build();
//        return userDetails;
//    }
//}
//
