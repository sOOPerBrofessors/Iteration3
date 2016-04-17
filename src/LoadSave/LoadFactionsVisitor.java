package LoadSave;

import Model.Faction.Faction;
import Model.Faction.FactionFactory;
import Visitors.LoadVisitor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Created by aseber on 4/7/16.
 */
public class LoadFactionsVisitor implements LoadVisitor {

    public void visit(LoadDocument document) {

        // Reduce the document down to the original
        Document reducedDocument = document.document;

        // Get the root element, then find all the factions inside it
        Element root = (Element) reducedDocument.getElementsByTagName("factions").item(0);
        NodeList factionList = root.getElementsByTagName("faction");

        // Iterate through all the factions, and add them to the factory
        for (int i = 0; i < factionList.getLength(); ++i) {

            Element currentElement = (Element) factionList.item(i);
            String name = currentElement.getAttribute("name");
            FactionFactory.addFaction(name, new Faction(name));

        }

    }

    public void loadFromDirectory(String directory) {

//        directory = IOUtilities.getFileSystemDependentPath(directory);
//        loadFactions(directory += "factions.xml");
//        loadFactionRelations(directory += "faction_relationships.xml");

    }

}
