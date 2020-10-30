package Examination.Services;

import Examination.Entities.Question;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionServiceImpl implements QuestionService {


    public QuestionServiceImpl()  throws Exception {
    }

    public static String getInput(String message, Scanner scanner)
    {
        System.out.println(message);
        return scanner.nextLine();
    }

    public static int extractParameter(String command, int startlength)
    {
        StringBuilder parameter= new StringBuilder();

        for (int i = startlength; i < command.length(); i++)
        {
            parameter.append(command.charAt(i));
        }
        return Integer.parseInt(parameter.toString());
    }



    @Override
    public void addQuestion() {

    }

    @Override
    public void viewQuestion(List<Question> questionList) {

    }

    @Override
    public void viewOneQuestion() {

    }

    @Override
    public void removeQuestion() {

    }

    @Override
    public void redactionQuestion() {

    }
}
