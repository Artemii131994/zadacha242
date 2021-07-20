package securitis.dao;


import securitis.model.User;

import java.util.List;



public interface UserDAO {
    public List<User> getAllUser();

    public User getUser(Long id);

    public void update(User user);

    public void deleteUser(Long id);

    public User ByUserName(String s);


}
