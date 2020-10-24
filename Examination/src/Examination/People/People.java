package Examination.People;

public abstract class People {
    public String login;
    public String password;
    public String name;

    public People(String login, String password, String name){
        this.login = login;
        this.password = password;
        this.name = name;
    }

}
