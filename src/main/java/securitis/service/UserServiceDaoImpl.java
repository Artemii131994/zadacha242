package securitis.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import securitis.dao.RoleDAO;
import securitis.dao.UserDAO;
import securitis.model.Role;
import securitis.model.User;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceDaoImpl implements UserServiceDao {

  //  @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private UserDAO userDAO;
    private RoleDAO roleDAO;

    @Autowired
    public UserServiceDaoImpl(UserDAO userDAO, RoleDAO roleDAO, BCryptPasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }


    @Override
    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public boolean update(User user) {
//        User userFromDB = userDAO.ByUserName(user.getUsername());
//
//        if (userFromDB != null) {
//            return false;
//        }
//
//        user.setRoles(Collections.singleton(roleDAO.getRole(1L)));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.update(user);
return true;
    }


    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    @Override
    @Transactional
    public Role getByName(String name) {
        return roleDAO.getByName(name);
    }



}
