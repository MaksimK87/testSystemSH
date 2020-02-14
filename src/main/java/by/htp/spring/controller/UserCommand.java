package by.htp.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserCommand {


    @Transactional
    @RequestMapping("/startTest")
    public String startTest(){

        return "testPage";
    }



}
