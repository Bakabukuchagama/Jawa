package Examination;

import Examination.Entities.Question;
import Examination.Services.QuestionServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String command;
        Question question=null;
        List<Question> questionList = new ArrayList<Question>();
        questionList = new QuestInitialization().QuestInit(questionList);
	do{
        System.out.println("Введите команду (view, add, exit)");
        command = scanner.nextLine();
        if(command.contains("view")){
            new QuestionServiceImpl().viewQuestion(questionList);
        }

        if(command.contains("add")){

        }

    }
	while (command != "exit");
    }
}
