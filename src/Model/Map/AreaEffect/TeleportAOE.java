package Model.Map.AreaEffect;

import Model.Entity.Character.Character;
import Model.Map.Location;
import Model.Map.Map;
import Utilities.Visitor.AOEVisitor;

/**
 * Created by dyeung on 4/15/16.
 */
public class TeleportAOE extends AreaOfEffect {
    private Location targetLocation;
    private Map map;
    //This is kinda bad to have to know map but its the only way to move/jump
    public TeleportAOE(int value, Location targetLocation, Map map) {
        super(value);
        this.targetLocation = targetLocation;
        this.map = map;
    }

    @Override
    public void onInteract(Character character) {
        map.moveCharacter(character,targetLocation);
    }

    @Override
    public void acceptAOEVisitor(AOEVisitor aoeVisitor) {
        aoeVisitor.visitTeleportAoe();
    }
}
