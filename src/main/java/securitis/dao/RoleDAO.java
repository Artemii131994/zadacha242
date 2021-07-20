package securitis.dao;

import securitis.model.Role;

public interface RoleDAO {

  public Role getByName(String name);

  public Role getRole(Long id);
}

