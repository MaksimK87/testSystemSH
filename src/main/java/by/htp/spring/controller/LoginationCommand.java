package by.htp.spring.controller;

import by.htp.spring.bean.Role;
import by.htp.spring.bean.Test;
import by.htp.spring.bean.User;
import by.htp.spring.service.TestService;
import by.htp.spring.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.lang.annotation.ElementType;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginationCommand {

    private static final Logger logger = Logger.getLogger(LoginationCommand.class);

    @Autowired
    private UserService userService;

    @Autowired
    private TestService testService;

    // @Value("#{countryOptions}")
    // private Map<String, String> countryOptions;
    @Transactional
    @RequestMapping("/showLoginForm")
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        logger.debug("Show login form");
        return "show-login-form";
    }

     @Transactional
    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model, HttpSession httpSession) {
        User userFromDB;

        logger.debug("process form");

        if (bindingResult.hasErrors()) {
            logger.debug("binding result has errors: " + bindingResult.toString() + "-->" + bindingResult.getFieldError());
            return "show-login-form";

        } else {
            userFromDB = userService.signIn(user.getLogin(), user.getPassword());

            logger.debug("User from DB " + userFromDB);

            model.addAttribute("userFromDB", userFromDB);
            httpSession.setAttribute("userFromDB", userFromDB);

            List<Test> tests = testService.getAllTests();
            model.addAttribute("tests", tests);
            logger.debug("Adding user from db to model");
            httpSession.setAttribute("tests", tests);

            if (userFromDB.getUserDetails().getRole().equals(Role.ADMINISTRATOR)) {

                return "admin-main-page";
            }

           return "main-page";
        }
    }


    @RequestMapping("/regForm")
    public String showRegForm() {


        return "show-registration-form";
    }

    @RequestMapping("/log_out")
    public String logOut(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login/show-login-form";
    }


}
