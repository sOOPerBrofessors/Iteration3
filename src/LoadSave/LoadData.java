package LoadSave;

import Utilities.IOUtilities;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;
import Utilities.PersonFilter;
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

            MessageHandler.println("LoadData: Failed loading data: " + path + ". Invalid visitor.", ErrorLevel.ERROR, PersonFilter.AUSTIN);
            return;

        }

        path = IOUtilities.getFileSystemDependentPath(path);
        MessageHandler.println("LoadData: Loading Data: " + path, ErrorLevel.NOTICE, PersonFilter.AUSTIN);

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
            MessageHandler.println("LoadData: SAXParseException", ErrorLevel.ERROR, PersonFilter.AUSTIN);
        } catch (ParserConfigurationException e) {
            MessageHandler.println("LoadData: ParserConfigurationException", ErrorLevel.ERROR, PersonFilter.AUSTIN);
        } catch (SAXException e) {
            MessageHandler.println("LoadData: SAXException", ErrorLevel.ERROR, PersonFilter.AUSTIN);
        } catch (IOException e) {
            MessageHandler.println("LoadData: IOException", ErrorLevel.ERROR, PersonFilter.AUSTIN);
        }

    }

}
