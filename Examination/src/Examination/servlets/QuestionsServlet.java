package Examination.servlets;

import Examination.repositories.QuestionRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/questions")
public class QuestionsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        try {
            List<String> quest = new QuestionRepositoryImpl().ViewQuestions();
            for (String question : quest) {
                writer.println("<p>Вопрос: " + question + "</p>");
            }
        }finally {
            writer.close();
        }
    }

}
