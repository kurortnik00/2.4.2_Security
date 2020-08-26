package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserRepository;
import web.dao.UserRepositoryImpl;
import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;


public interface UserService {

    public void save(User user);

    public List<User> listAll();

    public User get(Long id);

    public void delete(Long id);

    public void update(User user);

    User findByUsername(String username);


}
