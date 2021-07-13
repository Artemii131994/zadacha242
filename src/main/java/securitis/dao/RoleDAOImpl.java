package securitis.dao;

import org.springframework.stereotype.Repository;
import securitis.model.Role;
import securitis.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDAOImpl implements RoleDAO{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("from Role").getResultList();
    }

    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void edit(Role role) {
        entityManager.merge(role);
    }

    @Override
    public Role getById(long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role getByName(String name) {
        TypedQuery<Role> query = entityManager.createQuery(
                "SELECT role FROM Role role WHERE role.name = :role", Role.class);
        return query
                .setParameter("role", name)
                .getSingleResult();
    }

    @Override
    public Set<Role> findRoleSetById(Integer[] id_roles) {
        Set<Role> roleSet = new HashSet<>();
        for (Integer id : id_roles) {
            roleSet.add(getById(id));
        }
        return roleSet;

    }


    @Override
    public Set<Role> getRole() {
        Set<Role> setrole = new HashSet<>();
        List<Role> listrole = entityManager.createQuery("select role from Role role").getResultList();
        setrole.addAll(listrole);
        return setrole;
    }

}
