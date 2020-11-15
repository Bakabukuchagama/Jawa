package Examination.services;

import Examination.enumerations.UserRoleEnum;
import Examination.people.User;
import Examination.repositories.UserRepositoryImpl;

import java.util.Scanner;

public class UserServiceImpl implements UserService {
    Scanner scanner = new Scanner(System.in);



    @Override
    public void registration() {
        String login;
        String password;
        String name;
        UserRoleEnum role;
        String admin;
        System.out.println("login");
        login = scanner.nextLine();
        System.out.println("password");
        password = scanner.nextLine();
        System.out.println("name");
        name = scanner.nextLine();
        System.out.println("Вы админ?");
        admin = scanner.nextLine();
        if (admin.equals("да")){
            role=UserRoleEnum.ADMIN;
        }
        else
        {
            role = UserRoleEnum.USER;
        }
        User user = new User(login, password, name, role);
        new UserRepositoryImpl().Registration(user);
    }

    @Override
    public void authorization() {
        new UserRepositoryImpl().authorization();
    }

    @Override
    public void logout() {
System.exit(1);
    }
}
