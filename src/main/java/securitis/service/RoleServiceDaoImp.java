package securitis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import securitis.dao.RoleDao;
import securitis.model.Role;

import java.util.Set;

@Service
@Transactional
public class RoleServiceDaoImp implements RoleServiceDao{

    private RoleDao roleDao;
    @Autowired
    public RoleServiceDaoImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public void newRole(Set<Role> roles) {
        roleDao.newRole(roles);
    }

    @Override
    @Transactional
    public Set<Role> getRole() {
        return roleDao.getRole();
    }
}
