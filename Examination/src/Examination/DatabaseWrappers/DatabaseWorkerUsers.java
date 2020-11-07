package Examination.DatabaseWrappers;

import Examination.People.User;
import org.apache.commons.lang3.ObjectUtils;

import java.sql.*;
import java.util.Scanner;

public class DatabaseWorkerUsers {
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet result = null;
    Scanner scanner = new Scanner(System.in);

    private String getInput(String text, Scanner scanner){
        System.out.println(text);
        String scan = scanner.nextLine();
        return scan;
    }

    public DatabaseWorkerUsers(){
        try {
            DriverManager.registerDriver(new org.h2.Driver());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void Registration(User user){
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            statement = connection.prepareStatement("insert into USERS (LOGIN,PASSWORD,NAME) values(?, ?, ?)");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            int result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (Exception e) {
            }
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
            }
        }

    }

    public String authorization(){
        String role = "";
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
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
            try {
                if (statement != null) statement.close();
            } catch (Exception e) {
            }
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
            }
            try {
                if (result != null) result.close();
            } catch (Exception e) {
            };
        }

        return role;
    }
}
