package by.htp.spring.dao;


import by.htp.spring.bean.Test;

import java.util.List;

public interface TestDAO {

    List<Test>  getAllTests();

    Test getTestById(int theId);
}
