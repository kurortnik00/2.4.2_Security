package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT user FROM User user").getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);

    }

    @Override
    public User findById(Long id) {
        User tmp = entityManager.find(User.class, id);
        return tmp;
    }

    @Override
    public void deleteById(Long id) {
        String query = "DELETE from User U WHERE U.id = " + id;
        entityManager.createQuery(query).executeUpdate();
    }

    @Override
    public void update(User user) {
        /*Query query = entityManager.createQuery("update User set userName = :nameParam, password = :passwordParam" +
                ", age = :ageParam"+
                " where id = :idCode");
        query.setParameter("idCode", user.getId());
        query.setParameter("nameParam", user.getUsername());
        query.setParameter("passwordParam", user.getPassword() );
        query.setParameter("ageParam", user.getAge());

        int result = query.executeUpdate();*/
        entityManager.merge(user);
    }

    @Override
    public User findByUsername(String username) {
        Query query = entityManager.createQuery("select U from User U WHERE U.userName = :userNameParam");
        query.setParameter("userNameParam", username);
        User tmmp = (User) query.getSingleResult();
        return tmmp;
    }

}
