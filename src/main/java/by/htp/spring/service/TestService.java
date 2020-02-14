package by.htp.spring.service;

import by.htp.spring.bean.Test;

import java.util.List;

public interface TestService {
   List<Test> getAllTests();
   Test getTestById(int theId);
}
