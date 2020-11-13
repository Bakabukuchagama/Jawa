package Examination.Services;

import Examination.Entities.Question;
import Examination.Enumerations.QuestionDifficulty;
import Examination.Enumerations.QuestionType;
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

public class QuestInitialization {
    DocumentBuilder documentBuilder= DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document Document=documentBuilder.parse("Examination/src/Examination/Test.xml");
     Node Root = Document.getDocumentElement();

    public QuestInitialization() throws IOException, SAXException, ParserConfigurationException {
    }

    public List<Question> QuestInit (List<Question> questionList){
        NodeList Questions = Root.getChildNodes();
        Question quest = null;
        for (int i = 0; i <Questions.getLength() ; i++)
        {
            Node Question = Questions.item(i);
            if (Question.getNodeName().equals("Quest"))
            {
                quest = new Question();
                String test= Question.getAttributes().getNamedItem("id").getTextContent();
                quest.setId(Integer.parseInt(Question.getAttributes().getNamedItem("id").getTextContent()));
            }

            if (Question.getNodeType() != Node.TEXT_NODE)
            {
                NodeList QuestProps = Question.getChildNodes();
                for (int j = 0; j <QuestProps.getLength() ; j++)
                {
                    Node QuestProp= QuestProps.item(j);
                    if (QuestProp.getNodeType() != Node.TEXT_NODE)
                    {
                        if (QuestProp.getNodeName().equals("question"))
                        {
                            quest.setQuestion(QuestProp.getChildNodes().item(0).getTextContent());
                        }
                        if (QuestProp.getNodeName().equals("author"))
                        {
                            quest.setAuthor(QuestProp.getChildNodes().item(0).getTextContent());
                        }
                        if (QuestProp.getNodeName().equals("difficulty"))
                        {
                            quest.setDifficulty(QuestionDifficulty.valueOf(QuestProp.getChildNodes().item(0).getTextContent()));
                        }
                        if (QuestProp.getNodeName().equals("type"))
                        {
                            quest.setType(QuestionType.valueOf(QuestProp.getChildNodes().item(0).getTextContent()));
                        }
                        if (QuestProp.getNodeName().equals("answer"))
                        {
                            List<String> answ = new ArrayList<>();
                            answ.add(QuestProp.getChildNodes().item(0).getTextContent());
                            quest.setAnswer(answ);
                        }

                    }
                }
                questionList.add(quest);
            }
        }
        return questionList;
    }

}
