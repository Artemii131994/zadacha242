package securitis.service;

import securitis.model.Role;

import java.util.Set;

public interface RoleServiceDao {
    void newRole(Set<Role> roles);

    Set<Role> getRole();
}
