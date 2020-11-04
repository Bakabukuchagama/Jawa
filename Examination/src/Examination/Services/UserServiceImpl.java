package Examination.Services;

import Examination.DatabaseWorker;
import Examination.People.User;

import java.util.Scanner;

public class UserServiceImpl implements UserService {
    Scanner scanner = new Scanner(System.in);



    @Override
    public void registration() {
        String login;
        String password;
        String name;
        System.out.println("login");
        login = scanner.nextLine();
        System.out.println("password");
        password = scanner.nextLine();
        System.out.println("name");
        name = scanner.nextLine();
        User user = new User(login, password, name);
        new DatabaseWorker().Registration(user);
    }

    @Override
    public void authorization() {
        new DatabaseWorker().authorization();
    }

    @Override
    public void logout() {
System.exit(1);
    }
}
