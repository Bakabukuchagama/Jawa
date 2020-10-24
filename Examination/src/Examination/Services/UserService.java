package Examination.Services;

public interface UserService {

    void registration(String name, String login, String password);

    Boolean authorization(String login, String password);

    void logout();

}
