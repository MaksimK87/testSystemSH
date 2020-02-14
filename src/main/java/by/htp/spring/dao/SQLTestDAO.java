package by.htp.spring.dao;

import by.htp.spring.bean.Test;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SQLTestDAO implements TestDAO {

    private static final Logger logger = Logger.getLogger(SQLTestDAO.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Test> getAllTests() {

        Session session= sessionFactory.getCurrentSession();

        Query<Test> query=session.createQuery("from Test",Test.class);
        List<Test> tests=query.getResultList();

        logger.debug("Got result list of tests: "+tests);
        return tests;
    }

    @Override
    public Test getTestById(int theId) {
        Session session= sessionFactory.getCurrentSession();

        Test test=session.get(Test.class,theId);
        return test;
    }
}
