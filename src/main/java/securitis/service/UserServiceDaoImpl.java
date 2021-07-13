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
    public void saveUser(User user) {
        userDAO.saveUser(user);
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
    public User ByUserName(String s) {
        return userDAO.ByUserName(s);
    }
        @Override
    @Transactional
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    @Transactional
    public void add(Role role) {
        roleDAO.add(role);
    }

    @Override
    @Transactional
    public void edit(Role role) {
        roleDAO.edit(role);
    }

    @Override
    @Transactional
    public Role getById(long id) {
        return roleDAO.getById(id);
    }

    @Override
    @Transactional
    public Role getByName(String name) {
        return roleDAO.getByName(name);
    }

    @Override
    @Transactional
    public Set<Role> findRoleSetById(Integer[] id_roles) {
        return roleDAO.findRoleSetById(id_roles);
    }

    @Override
    @Transactional
    public Set<Role> getRole() {
        return roleDAO.getRole();
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
