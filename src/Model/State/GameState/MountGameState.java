package Model.State.GameState;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.Mount.Mount;
import Model.Entity.Character.NPC.NPC;
import Model.Entity.Projectile.Projectile;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Orientation;
import Utilities.ItemStuff.ItemManager;

import java.util.ArrayList;

/**
 * Created by Wimberley on 4/18/16.
 */
public class MountGameState extends GameState {

    private Mount activeMount;

    public MountGameState(Map map, Avatar avatar, ArrayList<NPC> entities, ArrayList<Mount> mounts, ItemManager itemManager) {
        super(map, avatar, entities, mounts, itemManager);
    }

    @Override
    public void tick() {
        for(int i = 0; i < npcs.size(); i++){
            npcs.get(i).tick();
        }
        if(projectiles != null){
            for(int i = 0; i < projectiles.size(); i++){
                projectiles.get(i).tick(map);
            }
        }
    }

    // player commands from controller
    public void moveMountN(){
        activeMount.move(map, Orientation.NORTH);
        itemManager.contact(avatar);
    }

    public void moveMountNE(){
        activeMount.move(map, Orientation.NORTHEAST);
        itemManager.contact(avatar);
    }

    public void moveMountSE(){
        activeMount.move(map, Orientation.SOUTHEAST);
        itemManager.contact(avatar);
    }

    public void moveMountS(){
        activeMount.move(map, Orientation.SOUTH);
        itemManager.contact(avatar);
    }

    public void moveMountSW(){
        activeMount.move(map, Orientation.SOUTHWEST);
        itemManager.contact(avatar);
    }

    public void moveMountNW(){
        activeMount.move(map, Orientation.NORTHWEST);
        itemManager.contact(avatar);
    }

    public void levitate(){
        activeMount.levitate();
    }

    public void dismount(){
        activeMount.removePassenger();
        map.addCharacter(avatar);
    }

    public void playerAttack(){
        Location tempLoc = new Location(avatar.getX(), avatar.getY(), avatar.getZ());
        Projectile temp = Projectile.makeFireBall(tempLoc, avatar.getOrientation());
        projectiles.add(temp);
    }

    public void playerInteract(){
        map.checkTileInteraction(avatar,avatar.getLocation(), avatar.getLocation().getAdjacent(avatar.getOrientation()));
        itemManager.interact(avatar);
    }

    public void startCombatTimer() { avatar.startCombatTimer(); }

    public void setActiveMount(Mount mount){
        activeMount = mount;
    }
}