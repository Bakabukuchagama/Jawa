package Examination.repositories;
import Examination.entities.Question;
import Examination.enumerations.QuestionDifficulty;
import Examination.enumerations.QuestionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class QuestionRepositoryImpl {
    @Autowired
    DatabaseWorker database;

    public List<String> ViewQuestions() {
        List<String> questions = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet result = null;
        Connection connection = null;
        try {
            connection = database.getConnection();
            statement = connection.prepareStatement("select QUESTION from QUESTIONS");
            result = statement.executeQuery();

            while (result.next()) {
                String quest = result.getString("question");
                questions.add(quest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.close(result, statement, connection);
        }
        return questions;
    }

    public void AddQuestion(Question question){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = database.getConnection();
            statement = connection.prepareStatement("insert into question(QUESTION, AUTHOR, DIFFICULTY, TYPE, ANSWER) values(?, ?, ?, ?, ?)");
            statement.setString(1, question.getQuestion());
            statement.setString(2, question.getAuthor());
            statement.setString(3, question.getDifficulty().getValue());
            statement.setString(4, question.getType().getValue());
            List<String> answer = question.getAnswer();
            String listString = "";
            for (String s : answer)
            {
                listString += s + "; ";
            }
            statement.setString(5, listString);

            int result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.close(statement, connection);
            }
        }

    public void delQuest(String command) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = database.getConnection();
            statement = connection.prepareStatement("delete from QUESTIONS where ID = ?");
            statement.setString(1, command);
            int result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           database.close(connection, statement);
        }
    }

    public Question getQuestion(String id) {
        Question quest= new Question();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            connection = database.getConnection();
            String typeQuestion, author, difficulty, question;
            List<String> answer = new ArrayList<>();
            QuestionType questionType1;
            QuestionDifficulty questionDifficulty1;
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            statement = connection.prepareStatement("select * from QUESTIONS where ID = ?");
            statement.setString(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                question = result.getString("QUESTION");
                typeQuestion = result.getString("TYPE_QUESTION");
                questionType1 = QuestionType.getByName(typeQuestion);
                author = result.getString("AUTHOR");
                difficulty = result.getString("DIFFICULTY");
                questionDifficulty1 = QuestionDifficulty.getByName(difficulty);
                if (result.getString("TYPE_QUESTION").equals("MANY_QUESTION"))
                {
                    String strAnswer = result.getString("ANSWER");
                    String str[] = strAnswer.split("; ");
                    answer = Arrays.asList(str);
                }
                else {
                    answer.add(result.getString("ANSWER"));
                }
                quest = new Question(question, author, questionDifficulty1, questionType1, answer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.close(connection, result, statement);
        }
        return quest;
    }

    public void updateQuest(String id, String param, String newValue) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection= database.getConnection();
            statement = connection.prepareStatement("update QUESTIONS set ? = ? where ID = ?");
            statement.setString(1, param);
            statement.setString(2, newValue);
            statement.setString(3, id);
            int result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.close(connection, statement);
        }
    }
}
