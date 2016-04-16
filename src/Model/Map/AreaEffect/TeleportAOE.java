package Model.Map.AreaEffect;

import Model.Entity.Character.Character;
import Model.Map.Location;

/**
 * Created by dyeung on 4/15/16.
 */
public class TeleportAOE extends AreaOfEffect {
    private Location targetLocation;
    public TeleportAOE(int value, Location targetLocation) {
        super(value);
        this.targetLocation = targetLocation;
    }

    @Override
    public void onInteract(Character character) {
        //TODO add teleport functionality
    }
}
