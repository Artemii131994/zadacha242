package securitis.dao;

import securitis.model.Role;
import securitis.model.User;

import java.util.List;
import java.util.Set;

public interface RoleDAO {
    List<Role> getAllRoles();

    void add(Role role);

    void edit(Role role);

    Role getById(long id);

    Role getByName(String name);
    Set<Role> findRoleSetById(Integer[] id_roles);
    public Set<Role> getRole();
}
