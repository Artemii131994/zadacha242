package securitis.dao;

import securitis.model.Role;
import securitis.model.User;

import java.util.Set;

public interface RoleDAO {

    public Role getByName(String name);

    public Set<Role> byRole(User user, String[] role);
}

