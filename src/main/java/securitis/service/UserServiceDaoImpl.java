package securitis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import securitis.dao.RoleDAO;
import securitis.dao.UserDAO;
import securitis.model.Role;
import securitis.model.User;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceDaoImpl implements UserServiceDao{

    private UserDAO userDAO;

    private RoleDAO roleDAO;

    @Autowired
    public UserServiceDaoImpl(UserDAO userDAO, RoleDAO roleDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }


    @Override
    @Transactional
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDAO.update(user);
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


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDAO.ByUserName(s);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

}
