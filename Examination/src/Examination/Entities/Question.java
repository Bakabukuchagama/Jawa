package Examination.Entities;

import Examination.Type.DifficultyQuestion;
import Examination.Type.TypeQuestion;

public class Question {
    private String question;
    private String author;
    private DifficultyQuestion difficulty;
    private TypeQuestion type;
    private boolean isRight;
    private String[] answer;


    public Question(String question, String author, DifficultyQuestion difficulty, TypeQuestion type, String[] answer) {
        this.question = question;
        this.author = author;
        this.difficulty = difficulty;
        this.type = type;
        this.answer = answer;
    }
    public boolean isRight(){
        return true;
    }
}
