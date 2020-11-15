package Examination.repositories;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.*;

@Component
public class DatabaseWorker {
    private static final String URL = "jdbc:h2:~/test";
    private static final String LOGIN = "sa";
    private static final String PASSWORD = "";


    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void close(AutoCloseable... close){
        try {
            for (AutoCloseable c: close) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
