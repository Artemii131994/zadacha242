package securitis.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import securitis.model.Role;
import securitis.model.User;

import java.util.List;
import java.util.Set;

public interface UserServiceDao extends UserDetailsService {

    public List<User> getAllUser();

    public void saveUser(User user);

    public User getUser(Long id);

    public void update(User user);

    public void deleteUser(Long id);


    User ByUserName(String s);

    List<Role> getAllRoles();

    void add(Role role);

    void edit(Role role);

    Role getById(long id);

    Role getByName(String name);
    Set<Role> findRoleSetById(Integer[] id_roles);

    public Set<Role> getRole();

}
