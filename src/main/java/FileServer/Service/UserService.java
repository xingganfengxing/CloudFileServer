package FileServer.Service;

import FileServer.Model.User;

import java.util.List;

/**
 * Created by zhy on 1/16/17.
 */
public interface UserService {
    User findUserByName(String name);
    void save(User user);
    List<User> findAll();
}
