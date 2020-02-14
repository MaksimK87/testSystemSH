package by.htp.spring.dao;

import by.htp.spring.bean.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.Iterator;
import java.util.List;


@Repository
public class SQLUserDAO implements UserDAO {

    private static final Logger logger = Logger.getLogger(SQLUserDAO.class);


    @Autowired
    private SessionFactory sessionFactory;

    public boolean registration(User user) {

        Session session = sessionFactory.getCurrentSession();
        String hql = "from User U where U.login=:loginParam";
        Query query = session.createQuery(hql);
        query.setParameter("loginParam", user.getLogin());
        List users = query.list();
        logger.debug("List of users from db: "+users.toString());
        if (!users.isEmpty()) {
            logger.debug("User: "+(User)users.get(0));
            logger.debug("Such user in DB exists, is required another login!");
            return false;
        } else {
            session.clear();
            session.saveOrUpdate(user);
            logger.debug("!!!!!! Registering new user in DB was completed" +user);
            return true;
        }
    }

    public User signIn(String login, String password) {
        Iterator iterator;
        User user = null;
        String hql = "from User U where U.login=:loginParam and U.password=:passwordParam";

        Session session = sessionFactory.getCurrentSession();

        logger.debug("preparing hql query for sign in user");

        Query query = session.createQuery(hql);
        query.setParameter("loginParam", login);
        query.setParameter("passwordParam", password);
        List users = query.list();

        iterator = users.iterator();

        while (iterator.hasNext()) {
            user = (User) iterator.next();
            logger.debug("Getting user from DB: " + user);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+user);
            logger.debug(user);
        }
        return user;
    }

    @Override
    public void deleteUser(int id) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("delete from User where id:=userId");
        query.setParameter("userId",id);
        query.executeUpdate();
    }

    @Override
    public void updateUser(User user) {
        Session session=sessionFactory.getCurrentSession();
       // session.saveOrUpdate(user);
        Query query=session.createQuery("update from User where id:=userId");
        query.setParameter("userId",user.getId());
        query.executeUpdate();
    }

    @Override
    public List<User> getAllUsers() {
        Session session=sessionFactory.getCurrentSession();
        Query<User> usersQuery=session.createQuery("from User order by login");
        List<User> users=usersQuery.list();
        return users;
    }

    @Override
    public User getUser(int id) {
        Session session=sessionFactory.getCurrentSession();
        User user=session.get(User.class,id);
        return user;
    }


}
