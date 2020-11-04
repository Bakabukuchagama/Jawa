package Examination;

import Examination.Entities.Question;
import Examination.Services.QuestInitialization;
import Examination.Services.QuestionServiceImpl;
import Examination.Services.UserServiceImpl;
import com.thoughtworks.qdox.model.expression.Equals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Войдите или зарегиструруйтесь.\n Регистрация-1 Вход-2");
        int reg = scanner.nextInt();
        if (reg == 1) {
            new UserServiceImpl().registration();
        } else if (reg == 2) {
            new UserServiceImpl().authorization();
        }
        new RealizeFunctionalle().Initial();
    }
}
