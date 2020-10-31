package Examination.Services;

import Examination.Entities.Question;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.List;

public interface QuestionService {

    void addQuestion(List<Question> questionList) throws TransformerException, ParserConfigurationException;

    void viewQuestion(List<Question> questionList);

    void viewOneQuestion(List<Question> questionList, String command);

    void removeQuestion(List<Question> questionList, String command) throws TransformerException, ParserConfigurationException;

    void redactionQuestion(List<Question> questionList, String command) throws TransformerException, ParserConfigurationException;
}
