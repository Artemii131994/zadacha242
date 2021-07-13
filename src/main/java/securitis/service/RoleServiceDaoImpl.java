//package securitis.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import securitis.dao.RoleDAO;
//import securitis.model.Role;
//import securitis.model.User;
//
//import java.util.List;
//
//@Service
//public class RoleServiceDaoImpl implements RoleServiceDao{
//
//    private RoleDAO roleDAO;
//
//    @Autowired
//    public RoleServiceDaoImpl(RoleDAO roleDAO) {
//        this.roleDAO = roleDAO;
//    }
//
//    @Override
//    @Transactional
//    public List<User> getAllRoles() {
//        return roleDAO.getAllRoles();
//    }
//
//    @Override
//    @Transactional
//    public void add(Role role) {
//        roleDAO.add(role);
//    }
//
//    @Override
//    @Transactional
//    public void edit(Role role) {
//        roleDAO.edit(role);
//    }
//
//    @Override
//    @Transactional
//    public Role getById(long id) {
//        return roleDAO.getById(id);
//    }
//
//    @Override
//    @Transactional
//    public Role getByName(String name) {
//        return roleDAO.getByName(name);
//    }
//}
