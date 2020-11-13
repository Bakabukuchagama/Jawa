package Examination.Entities;

import Examination.Enumerations.QuestionDifficulty;
import Examination.Enumerations.QuestionType;

import java.util.List;

public class Question {
    private String question;
    private String author;
    private QuestionDifficulty difficulty;
    private QuestionType type;
    private Integer id;
 //   private boolean isRight;
    private List<String> answer;

    public Question() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public QuestionDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(QuestionDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

//    public void setRight(boolean right) {
//        isRight = right;
//    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }



    public Question(String question, String author, QuestionDifficulty difficulty, QuestionType type, List<String> answer) {
        this.question = question;
        this.author = author;
        this.difficulty = difficulty;
        this.type = type;
        this.answer = answer;
        this.id = id;
    }
//    public boolean isRight(){
//        return true;
//    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", author='" + author + '\'' +
                ", difficulty=" + difficulty +
                ", type=" + type +
//                ", isRight=" + isRight +
                ", answer=" + answer +
                '}';
    }
}
