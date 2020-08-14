package web.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;


public interface UserRepository {

    List<User> findAll();
    void save(User user);
    User findById(Long id);
    void deleteById(Long id);
    void update(User user);
}
