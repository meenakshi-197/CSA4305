import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class XMLParsing {

    public static void main(String[] args) {

        try {
            // Load XML file
            File file = new File("users.xml");

            // Create XML parser
            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();

            DocumentBuilder builder =
                    factory.newDocumentBuilder();

            // Parse XML document
            Document document = builder.parse(file);

            // Normalize document
            document.getDocumentElement().normalize();

            // Access root element
            System.out.println("Root Element: "
                    + document.getDocumentElement().getNodeName());

            // Get user nodes
            NodeList userList =
                    document.getElementsByTagName("user");

            System.out.println("\nUSER DETAILS");
            System.out.println("============");

            // Traverse through users
            for (int i = 0; i < userList.getLength(); i++) {

                Node node = userList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element user = (Element) node;

                    String id = user
                            .getElementsByTagName("id")
                            .item(0)
                            .getTextContent();

                    String name = user
                            .getElementsByTagName("name")
                            .item(0)
                            .getTextContent();

                    String email = user
                            .getElementsByTagName("email")
                            .item(0)
                            .getTextContent();

                    System.out.println("ID    : " + id);
                    System.out.println("Name  : " + name);
                    System.out.println("Email : " + email);
                    System.out.println("--------------------");
                }
            }

        } catch (Exception e) {
            System.out.println("XML Parsing Error: "
                    + e.getMessage());
        }
    }
}