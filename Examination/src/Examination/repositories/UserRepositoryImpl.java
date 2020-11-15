package Examination.repositories;

import Examination.enumerations.UserRoleEnum;
import Examination.people.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Scanner;

@Component
public class UserRepositoryImpl {
    @Autowired
    DatabaseWorker database;
    Scanner scanner = new Scanner(System.in);
    public void Registration(User user){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = database.getConnection();
            statement = connection.prepareStatement("insert into USERS (LOGIN,PASSWORD,NAME,ADMIN) values(?, ?, ?, ?)");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            if (user.getRole().equals(UserRoleEnum.ADMIN)){
                statement.setBoolean(4, Boolean.TRUE);
            }else {
                statement.setBoolean(4, Boolean.FALSE);
            }
            int result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           database.close(connection, statement);
        }

    }

    public String authorization(){
        String role = "";
        Connection  connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            connection = database.getConnection();
            Boolean log = false;
            while (!log) {
                statement = connection.prepareStatement("SELECT LOGIN, PASSWORD, ADMIN from USERS where login=? and password=? ");
                statement.setString(1, getInput("Введите логин", scanner));
                statement.setString(2, getInput("Введите пароль", scanner));
                result = statement.executeQuery();
                if (result.next()) {
                    if (result.getBoolean("ADMIN")) {
                        System.out.println("ЗДАРОВА АДМИН");
                        role = "ADMIN";
                        log=true;
                    } else if (!result.getBoolean("ADMIN")) {
                        System.out.println("ЗДАРОВА NOT АДМИН");
                        role = "USER";
                        log=true;
                    }
                } else {
                    System.out.println("ТАКОГО Ю-ЗВЕРЯ НЕТ, ПОПРОБУЙ ЕЩЁ РАЗ");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           database.close(connection, statement, result);
        }

        return role;
    }

    private String getInput(String text, Scanner scanner){
        System.out.println(text);
        String scan = scanner.nextLine();
        return scan;
    }
}
