package Examination;

import Examination.Entities.Question;
import Examination.Services.QuestInitialization;
import Examination.Services.QuestionServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String VIEW_ALL ="view";
    private static final String EXIT="exit";
    private static final String ADD="add";
    private static final String LOOK="look";
    private static final String REMOVE="remove";
    private static final String EDIT="edit";
    public static String Filexml="";

    public static String getFile(){
    return Filexml;
}
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
      //  Question question=null;
        List<Question> questionList = new ArrayList<>();
        questionList = new QuestInitialization().QuestInit(questionList);
        System.out.println("Введите путь к файлу вопросов (Пример: Examination/src/Examination/Test.xml)");
        Filexml = scanner.nextLine();
	do{
        System.out.println("Введите команду (view, add, exit, look (номер вопроса), remove (номер вопроса))");
        command = scanner.nextLine();


        if(command.contains(VIEW_ALL)){
            new QuestionServiceImpl().viewQuestion(questionList);
        }
        if(command.contains(ADD)){
            new QuestionServiceImpl().addQuestion(questionList);
        }
        if(command.contains(LOOK)){
            new QuestionServiceImpl().viewOneQuestion(questionList, command);
        }
        if(command.contains(REMOVE)){
            new QuestionServiceImpl().removeQuestion(questionList, command);
        }
        if(command.contains(EDIT)){
            new QuestionServiceImpl().redactionQuestion(questionList, command);
        }

    }
	while (!command.equals(EXIT));
    }
}
