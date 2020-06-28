package ru.sbrf.jschool.springmvc.model;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public final class UserStorage {
    private Map<String, User> users = new HashMap<>();

    public UserStorage() {
        save(new User("testUser1"));
        save(new User("testUser3"));
        save(new User("testUser2","admin"));
    }

    public User getByLogin(String login){
       return users.get(login);
    }

    public void save(User user){
        users.put(user.getLogin(), user);
    }

    public Collection<User> getAll(){
        return users.values();
    }
}
