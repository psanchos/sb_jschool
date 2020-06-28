package ru.sbrf.jschool.springmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.sbrf.jschool.springmvc.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerExample {
    public static final Logger LOG = LoggerFactory.getLogger(ControllerExample.class);

    public ControllerExample() {
        LOG.info("Controller initialized");
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getMethodExample(){
        return "get_ok";
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User("testUser1"));
        users.add(new User("testUser3"));
        users.add(new User("testUser2","admin"));
        return users;
    }

    @RequestMapping(path = "/jsp", method = RequestMethod.GET)
    public String jsp(Model model){
        model.addAttribute("message","string from model");
        return "view";
    }

}
