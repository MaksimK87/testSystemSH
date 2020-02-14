package by.htp.spring.service;

import by.htp.spring.bean.Test;
import by.htp.spring.dao.TestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDAO testDAO;

    @Transactional
    public List<Test> getAllTests() {
        return testDAO.getAllTests();
    }

    @Transactional
    public Test getTestById(int theId) {
        return testDAO.getTestById(theId);
    }
}
