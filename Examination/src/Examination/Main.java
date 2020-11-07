package Examination;

import Examination.Entities.Question;
import Examination.Services.QuestInitialization;
import Examination.Services.QuestionServiceImpl;
import Examination.Services.UserServiceImpl;
import com.thoughtworks.qdox.model.expression.Equals;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import java.util.Scanner;

@SpringBootApplication
@ServletComponentScan
public class Main {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Войдите или зарегиструруйтесь.\n Регистрация-1 Вход-2");
//        int reg = scanner.nextInt();
//        if (reg == 1) {
//            new UserServiceImpl().registration();
//        } else if (reg == 2) {
//            new UserServiceImpl().authorization();
//        }
//        new RealizeFunctionalle().Initial();
    }
}
