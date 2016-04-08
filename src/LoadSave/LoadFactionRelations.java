package LoadSave;

import Model.Faction.Faction;
import Model.Faction.FactionFactory;
import Utilities.Relationship;
import Visitors.LoadVisitor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Created by aseber on 4/7/16.
 */
public class LoadFactionRelations implements LoadVisitor {

    public void visit(LoadDocument document) {

        // Reduce the document down to the original
        Document reducedDocument = document.document;

        // Get the root element, then find all the factions inside it
        Element root = (Element) reducedDocument.getElementsByTagName("faction_relationships").item(0);
        NodeList factionList = root.getElementsByTagName("relationship");

        // Iterate through all the factions, and add them to the factory
        for (int i = 0; i < factionList.getLength(); ++i) {

            Element currentElement = (Element) factionList.item(i);
            String factionFromString = currentElement.getAttribute("factionFrom");
            String factionToString = currentElement.getAttribute("factionTo");
            double relation = Double.parseDouble(currentElement.getAttribute("relation"));

            Faction factionFrom = FactionFactory.getFaction(factionFromString);
            Faction factionTo = FactionFactory.getFaction(factionToString);

            factionFrom.addFactionRelationship(factionTo, new Relationship(relation));
            FactionFactory.addFaction(factionFromString, factionFrom);

        }

    }

}
