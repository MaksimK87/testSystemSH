package by.htp.spring.service;

import by.htp.spring.bean.User;
import by.htp.spring.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    boolean registration(User user);

    User signIn(String login, String password);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(int id);

    User getUser(int id);


}
