package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleRepository;
import web.dao.UserRepository;
import web.model.Role;
import web.model.User;

import javax.management.Query;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService{


    @Autowired
    UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Override
    public void save(User user) {

        Set<Role> roles = new HashSet<>();
        //make new user with USER role
        roles.add(roleRepo.findById(1L));
        user.setRoles(roles);
        userRepo.save(user);
    }

    @Override
    public List<User> listAll() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public User get(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void update(User user) {userRepo.update(user);}

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }


}

