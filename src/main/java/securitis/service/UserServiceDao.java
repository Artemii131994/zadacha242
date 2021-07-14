package securitis.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import securitis.model.Role;
import securitis.model.User;

import java.util.List;
import java.util.Set;

public interface UserServiceDao extends UserDetailsService {

    public List<User> getAllUser();

    public User getUser(Long id);

    public void update(User user);

    public void deleteUser(Long id);

    public Role getByName(String name);


}
