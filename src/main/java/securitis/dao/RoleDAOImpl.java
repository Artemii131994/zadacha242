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
    public Role getByName(String name) {
        TypedQuery<Role> query = entityManager.createQuery(
                "SELECT role FROM Role role WHERE role.name = :role", Role.class);
        return query
                .setParameter("role", name)
                .getSingleResult();
    }

}
