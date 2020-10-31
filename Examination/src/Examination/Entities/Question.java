package Examination.Entities;

import Examination.Enumerations.DifficultyQuestion;
import Examination.Enumerations.TypeQuestion;

public class Question {
    private String question;
    private String author;
    private DifficultyQuestion difficulty;
    private TypeQuestion type;
    private Integer id;
 //   private boolean isRight;
    private String answer;

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

    public DifficultyQuestion getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyQuestion difficulty) {
        this.difficulty = difficulty;
    }

    public TypeQuestion getType() {
        return type;
    }

    public void setType(TypeQuestion type) {
        this.type = type;
    }

//    public void setRight(boolean right) {
//        isRight = right;
//    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }



    public Question(String question, String author, DifficultyQuestion difficulty, TypeQuestion type, String answer) {
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
