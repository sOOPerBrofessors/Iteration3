package Controller.AI_Controller.VisualCortex.VisualInformation;

import Model.Entity.Entity;
import Utilities.AIStuff.Relationship;
import Utilities.AIStuff.RelationshipList;
import Visitors.VisualInformationVisitor;

/**
 * Created by aseber on 4/7/16.
 */
public class EntityRelationshipVisitor implements VisualInformationVisitor {

    private RelationshipList<Entity> relationshipList;

    public EntityRelationshipVisitor(RelationshipList<Entity> relationshipList) {

        this.relationshipList = relationshipList;

    }

    public void visit(VisualInformation target) {

        for (Entity entity : target.getEntityInformation().keySet()) {

            if (!relationshipList.relationshipExists(entity)) {

                Relationship relationship = new Relationship(0.0);
                relationshipList.addRelationship(entity, relationship);

            }

        }

    }

    public RelationshipList<Entity> getRelationshipList() {

        return relationshipList;

    }

}
