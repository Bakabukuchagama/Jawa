package Examination.Services;

import Examination.Entities.Question;

import java.util.List;

public interface QuestionService {

    void addQuestion();

    void viewQuestion(List<Question> questionList);

    void viewOneQuestion();

    void removeQuestion();

    void redactionQuestion();
}
