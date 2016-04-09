package LoadSave;

import Controller.AI_Controller.Interest.Interest;
import Controller.AI_Controller.Interest.InterestFactory;
import Controller.AI_Controller.Personality.Personality;
import Controller.AI_Controller.Personality.PersonalityFactory;
import Visitors.LoadVisitor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.HashMap;

/**
 * Created by aseber on 4/8/16.
 */
public class LoadPersonalitiesVisitor implements LoadVisitor {

    public void visit(LoadDocument document) {

        // Reduce the document down to the original
        Document reducedDocument = document.document;

        // Get the root element, then find all the factions inside it
        Element root = (Element) reducedDocument.getElementsByTagName("personalities").item(0);
        NodeList personalityList = root.getElementsByTagName("personality");

        // Iterate through all the factions, and add them to the factory
        for (int i = 0; i < personalityList.getLength(); ++i) {

            Element currentElement = (Element) personalityList.item(i);
            String personalityName = currentElement.getAttribute("name");
            double scatter_brainedness = Double.parseDouble(currentElement.getAttribute("scatter_brainedness"));
            double aggressiveness = Double.parseDouble(currentElement.getAttribute("aggressiveness"));
            double laziness = Double.parseDouble(currentElement.getAttribute("laziness"));
            HashMap<Interest, Double> interests = new HashMap<>();

            NodeList interestList = currentElement.getElementsByTagName("interest");

            for (int i2 = 0; i2 < interestList.getLength(); ++i2) {

                Element currentElement2 = (Element) interestList.item(i2);
                String interestName = currentElement2.getAttribute("name");
                double interestValue = Double.parseDouble(currentElement2.getAttribute("value"));
                interests.put(InterestFactory.getInterest(interestName), interestValue);

            }

            Personality personality = new Personality(personalityName, scatter_brainedness, aggressiveness, laziness, interests);
            PersonalityFactory.addPersonality(personalityName, personality);

        }

    }

}
