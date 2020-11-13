package Examination.Services;

import Examination.Entities.Question;
import Examination.Enumerations.QuestionDifficulty;
import Examination.Enumerations.QuestionType;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionServiceImpl implements QuestionService {
Scanner scanner = new Scanner(System.in);
private static QuestionServiceImpl instance;

    public QuestionServiceImpl() {
    }

    public static String getInput(String message, Scanner scanner)
    {
        System.out.println(message);
        return scanner.nextLine();
    }

    public static int extractParameter(String command, int startLength)
    {
        StringBuilder parameter= new StringBuilder();

        for (int i = startLength; i < command.length(); i++)
        {
            parameter.append(command.charAt(i));
        }
        return Integer.parseInt(parameter.toString());
    }

    public static QuestionServiceImpl getInstance(){
        if (instance == null) {
            instance = new QuestionServiceImpl();
        }
        return instance;
    }


    @Override
    public void addQuestion(List<Question> questionList) throws TransformerException, ParserConfigurationException {
        Question newQuest = new Question();
        List<String> answer = new ArrayList<>();
        System.out.println("Введите вопрос: ");
        newQuest.setQuestion(scanner.nextLine());
        System.out.println("Введите автора: ");
        newQuest.setAuthor(scanner.nextLine());
        System.out.println("Введите сложность (EASY, MEDIUM, HARD): ");
        newQuest.setDifficulty(QuestionDifficulty.getByName(scanner.nextLine()));
        System.out.println("Введите тип вопроса (ONE_QUESTION, MANY_QUESTION, OPEN_QUESTION): ");
        newQuest.setType(QuestionType.getByName(scanner.nextLine()));
        if (newQuest.getType().equals("MANY_QUESTION")){
            System.out.println("Введите количество ответов и следом сами ответы: ");
            for (int i = 0; i < scanner.nextInt(); i++) {
                answer.add(scanner.nextLine());
            }

        }


        if (questionList.size()<1){
            newQuest.setId(1);
        }
        else {
            newQuest.setId(questionList.get(questionList.size() - 1).getId() + 1);
        }
        questionList.add(newQuest);
        XMLWriter.File(questionList);

    }

    @Override
    public void viewQuestion(List<Question> questionList) {
//        questionList.forEach(System.out::println);
        for (Question question : questionList) {
            System.out.println();
            System.out.println("ID: " + question.getId() + " Вопрос: " + question.getQuestion());
        }

    }

    @Override
    public void viewOneQuestion(List<Question> questionList, String command) {

        for (Question question : questionList) {
            if (extractParameter(command, 5) == question.getId()) {
                System.out.println(question);
                break;
            }
        }
    }

    @Override
    public void removeQuestion(List<Question> questionList, String command) throws TransformerException, ParserConfigurationException {
        for (int i = 0; i < questionList.size(); i++)
        {
            if (extractParameter(command, 7)==questionList.get(i).getId())
            {
                questionList.remove(i);
                break;
            }
        }
        XMLWriter.File(questionList);
    }

    @Override
    public void redactionQuestion(List<Question> questionList, String command) throws TransformerException, ParserConfigurationException {
        for (Question question : questionList) {
            if (extractParameter(command, 5) == question.getId()) {
                Question editQuest = question;
                List<String> answer = new ArrayList<>();

                String input = getInput("Введите новый вопрос: ", scanner);
                editQuest.setQuestion(input.equals("") ? editQuest.getQuestion() : input);
                if(editQuest.getType().equals("MANY_QUESTION")){
                    System.out.println("Введите новое количество ответов и следом сами ответы: ");
                        for (int i = 0; i < scanner.nextInt(); i++) {
                        answer.add(scanner.nextLine());
                        }
                    editQuest.setAnswer(answer);
                }
                else {
                    System.out.println("Введите новый ответ: ");
                    answer.add(scanner.nextLine());
                    editQuest.setAnswer(input.equals("") ? editQuest.getAnswer() : answer);
                }


                break;
            }
        }
        XMLWriter.File(questionList);
    }
}
