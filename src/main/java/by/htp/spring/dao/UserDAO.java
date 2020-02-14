package by.htp.spring.dao;

import by.htp.spring.bean.User;

import java.util.List;


public interface UserDAO {

    boolean registration(User user);
    User signIn(String login, String password);
    void deleteUser(int id);
    void updateUser(User user);
    List<User> getAllUsers();

    User getUser(int id);
}
