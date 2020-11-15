package Examination.people;

import Examination.enumerations.UserRoleEnum;

public class User{

    private String login;
    private String password;
    private String name;
    private UserRoleEnum role;

    public User(){
    }



    public User(String login, String password, String name, UserRoleEnum role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
