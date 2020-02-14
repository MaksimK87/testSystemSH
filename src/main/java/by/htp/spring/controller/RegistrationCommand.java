package by.htp.spring.controller;

import by.htp.spring.bean.Role;
import by.htp.spring.bean.Test;
import by.htp.spring.bean.User;
import by.htp.spring.bean.UserDetails;
import by.htp.spring.service.TestService;
import by.htp.spring.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/registration")
public class RegistrationCommand {

    @Autowired
    private UserService userService;

    @Autowired
    private TestService testService;

    private static final Logger logger = Logger.getLogger(RegistrationCommand.class);

    @RequestMapping("/regForm")
    public String showRegForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "show-registration-form";
    }

    @RequestMapping("/processRegistration")
    public String processReg(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "show-registration-form";
        } else {
            user.getUserDetails().setRole(Role.STUDENT);
            if (userService.registration(user)) {
                logger.debug("Registration new user: " + user);
                model.addAttribute("userFromDB", user);
                List<Test> tests = testService.getAllTests();
                model.addAttribute("tests", tests);
                return "main-page";
            } else {
                String message = "This login is already used, try other variant!";
                model.addAttribute("message", message);
                return "show-registration-form";
            }


        }
    }

}
