package Examination.DatabaseWrappers;
import Examination.Entities.Question;
import Examination.Enumerations.DifficultyQuestion;
import Examination.Enumerations.TypeQuestion;
import Examination.People.User;
import org.apache.commons.lang3.ObjectUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class DatabaseWorkerQuestions {
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet result = null;
    Scanner scanner = new Scanner(System.in);

    public DatabaseWorkerQuestions() {
        try {
            DriverManager.registerDriver(new org.h2.Driver());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<String> ViewQuestions() {
        List<String> questions = new ArrayList<String>();
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            statement = connection.prepareStatement("select QUESTION from QUESTIONS");
            result = statement.executeQuery();

            while (result.next()) {
                String quest = result.getString("question");
                questions.add(quest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
            } catch (Exception e) {
            }
            try {
                if (statement != null) statement.close();
            } catch (Exception e) {
            }
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
            }
        }
        return questions;
    }

    public void AddQuestion(Question question){
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            statement = connection.prepareStatement("insert into question(QUESTION, AUTHOR, DIFFICULTY, TYPE, ANSWER) values(?, ?, ?, ?, ?)");
            statement.setString(1, question.getQuestion());
            statement.setString(2, question.getAuthor());
            statement.setString(3, question.getDifficulty().getValue());
            statement.setString(4, question.getType().getValue());
            statement.setString(5, question.getAnswer());

            int result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (Exception e) {
            }
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
            }
        }
    }

    public void delQuest(String command) {
        try {
            DriverManager.registerDriver(new org.h2.Driver());
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            statement = connection.prepareStatement("delete from QUESTIONS where ID = ?");
            statement.setString(1, command);
            int result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (Exception e) {
            }
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
            }
        }
    }

    public Question getQuestion(String id) {
        Question quest= new Question();
        try {
            String typeQuestion, author, difficulty, answer, question;
            TypeQuestion typeQuestion1;
            DifficultyQuestion difficultyQuestion1;
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            statement = connection.prepareStatement("select * from QUESTIONS where QUESTION = ?");
            statement.setString(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                question = result.getString("QUESTION");
                typeQuestion = result.getString("TYPE_QUESTION");
                typeQuestion1 = TypeQuestion.getByName(typeQuestion);
                author = result.getString("AUTHOR");
                difficulty = result.getString("DIFFICULTY");
                difficultyQuestion1 = DifficultyQuestion.getByName(difficulty);
                answer = result.getString("ANSWER");
                quest = new Question(question, author, difficultyQuestion1, typeQuestion1, answer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
            } catch (Exception e) {
            }
            try {
                if (statement != null) statement.close();
            } catch (Exception e) {
            }
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
            }
        }
        return quest;
    }

    public void updateQuest(String id, String param, String newValue) {
        try {
            DriverManager.registerDriver(new org.h2.Driver());
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            statement = connection.prepareStatement("update QUESTIONS set ? = ? where ID = ?");
            statement.setString(1, param);
            statement.setString(2, newValue);
            statement.setString(3, id);
            int result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (Exception e) {
            }
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
            }
        }
    }
}
