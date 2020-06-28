package ru.sbrf.jschool.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.sbrf.jschool.springmvc.model.User;
import ru.sbrf.jschool.springmvc.model.UserStorage;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserStorage storage;

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String getAllUsers(){
        return storage.getAll().toString();
    }

    @GetMapping("/{login}")
    @ResponseBody
    public String getUserById(@PathVariable() String login){
        System.out.println("find user:"+login);
        return String.valueOf(storage.getByLogin(login));
    }

    @GetMapping(path = "{login}", params = "mock=true")
    @ResponseBody
    public String getUserFoo(@PathVariable() String login){
        System.out.println("find user:"+login);
        return String.valueOf(new User(login));
    }

    @GetMapping("/search")
    @ResponseBody
    public List<User> search(@RequestParam("group") String group){
        return storage
                .getAll()
                .stream()
                .filter(u->group.equalsIgnoreCase(u.getGroup()))
                .collect(Collectors.toList());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String addUser(@RequestBody User user){
        if(user.getLogin()==null){
            throw new ValidationException();
        }
        storage.save(user);
        return "ok";
    }
}
