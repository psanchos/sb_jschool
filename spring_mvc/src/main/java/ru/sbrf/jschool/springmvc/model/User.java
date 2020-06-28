package ru.sbrf.jschool.springmvc.model;

import java.io.Serializable;

public class User implements Serializable {
    private String login;
    private String group;

    public User(){

    }
    public User(String login) {
        this(login,"user");
    }

    public User(String login, String group) {
        this.login = login;
        this.group = group;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
