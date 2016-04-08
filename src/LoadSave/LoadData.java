package LoadSave;

import Utilities.IOUtilities;
import Visitors.LoadVisitor;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by aseber on 4/7/16.
 */
public class LoadData {

    public static void load(String path, LoadVisitor visitor) {

        if (visitor == null) {

            System.err.println("Failed loading data: " + path + ". Invalid visitor.");
            return;

        }

        path = IOUtilities.getFileSystemDependentPath(path);
        System.out.println("Loading Data: " + path);

        try {

            // Create a document from the xml file
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(path));

            // Normalize the document
            doc.getDocumentElement().normalize();

            // Create a loadedDocument, and accept the visitor
            LoadDocument loadedDocument = new LoadDocument(doc);
            loadedDocument.accept(visitor);

        } catch (SAXParseException e) {
            System.err.println("LoadData: SAXParseException");
        } catch (ParserConfigurationException e) {
            System.err.println("LoadData: ParserConfigurationException");
        } catch (SAXException e) {
            System.err.println("LoadData: SAXException");
        } catch (IOException e) {
            System.err.println("LoadData: IOException");
        }

    }

}
