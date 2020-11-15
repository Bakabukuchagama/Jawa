package Examination.services;

import Examination.entities.Question;
import Examination.RealizeFunctionalle;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XMLWriter {
    public static String Filexml ="";
    public static void File(List<Question> questionList) throws TransformerException, ParserConfigurationException
    {

        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        Filexml = RealizeFunctionalle.getFile();

        Element root = document.createElement("Questions");
        document.appendChild(root);
        for (Question quest : questionList) {
            //         questionList.get(i);
            Element employee = document.createElement("Quest");

            root.appendChild(employee);

            Attr attr = document.createAttribute("id");
            attr.setValue(quest.getId().toString());
            employee.setAttributeNode(attr);

            Element Question = document.createElement("question");
            Question.appendChild(document.createTextNode(quest.getQuestion()));
            employee.appendChild(Question);

            Element Author = document.createElement("author");
            Author.appendChild(document.createTextNode(quest.getAuthor()));
            employee.appendChild(Author);

            Element Difficulty = document.createElement("difficulty");
            Difficulty.appendChild(document.createTextNode(quest.getDifficulty().getValue()));
            employee.appendChild(Difficulty);

            Element Type = document.createElement("type");
            Type.appendChild(document.createTextNode(quest.getType().getValue()));
            employee.appendChild(Type);

            Element Answer = document.createElement("answer");
           // Answer.appendChild(document.createTextNode(quest.getAnswer()));
            employee.appendChild(Answer);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        String xmlFilePath="";
        StreamResult streamResult = new StreamResult(new File(Filexml));
        transformer.transform(domSource, streamResult);

        System.out.println("Done creating XML File");
    }
}
