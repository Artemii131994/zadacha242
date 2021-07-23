package securitis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import securitis.dao.UserDAO;
import securitis.model.User;

@Service
public class UserDetails implements UserDetailsService {

    private UserDAO userDAO;


    @Autowired
    public UserDetails(UserDAO userDAO) {
        this.userDAO = userDAO;

    }

    @Override
    @Transactional
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDAO.ByUserName(s);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
