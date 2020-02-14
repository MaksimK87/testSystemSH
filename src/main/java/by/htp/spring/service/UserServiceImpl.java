package by.htp.spring.service;

import by.htp.spring.bean.User;
import by.htp.spring.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public boolean registration(User user) {
        return userDAO.registration(user);
    }

    @Transactional
    public User signIn(String login, String password) {
        return  userDAO.signIn(login,password);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Transactional
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    @Transactional
    public User getUser(int id) {

        return userDAO.getUser(id);
    }
}
