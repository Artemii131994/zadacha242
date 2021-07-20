package securitis.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import securitis.model.Role;
import securitis.model.User;

import java.util.List;

public interface UserServiceDao{

    public List<User> getAllUser();

    public User getUser(Long id);

    public boolean update(User user);

    public void deleteUser(Long id);

    public Role getByName(String name);


}
