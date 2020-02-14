package by.htp.spring.controller;

import by.htp.spring.bean.Questions;
import by.htp.spring.bean.Test;
import by.htp.spring.bean.User;
import by.htp.spring.service.TestService;
import by.htp.spring.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminCommand {

    private static final Logger logger = Logger.getLogger(AdminCommand.class);

    @Autowired
    private UserService userService;

    @Autowired
    private TestService testService;

    @RequestMapping("/getTests")
    public String getTests() {

        return "testList";
    }

    @RequestMapping("/getUser")
    public String getUser(@RequestParam ("userId") int theId, Model model, HttpSession session){
        logger.debug("update user with id: "+theId);
        User user=userService.getUser(theId);
        model.addAttribute("user",user);
        return "updateUserForm";
    }

    @RequestMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user, Model model){
        userService.updateUser(user);
    return getUsers(model);}

    @RequestMapping("/deleteUser")
    public String deleteUser(Model model, HttpSession session){
        List<User> users= userService.getAllUsers();
        logger.debug("Get users: "+users);
        model.addAttribute("users", users);
        session.setAttribute("users",users);
        return "/getUsers";
    }

    @Transactional
    @RequestMapping("/getUsers")
    public String getUsers(Model model){
        List<User> users= userService.getAllUsers();
        model.addAttribute("users", users);
        return "usersList";
    }




    @RequestMapping("/getQuestions")
    public String getQuestions(@RequestParam("testId") int theId, HttpSession httpSession){
        logger.debug("Id of test for showing questions: "+theId);
        Test test=testService.getTestById(theId);
        logger.debug("Got test from DB: "+test);
        List<Questions> questions=test.getQuestions();
        httpSession.setAttribute("questions",questions);
        httpSession.setAttribute("currentTest",test);
        return "questionsList";
    }

}
