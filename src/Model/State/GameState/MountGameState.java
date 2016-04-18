package Model.State.GameState;

import Controller.Controllers.MountController;
import Model.Entity.Character.Avatar;
import Model.Entity.Character.Mount.Mount;
import Model.Entity.Character.NPC.NPC;
import Model.Entity.Projectile.Projectile;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Orientation;
import Utilities.GameMessageQueue;
import Utilities.ItemStuff.ItemManager;
import Utilities.Settings;

import java.util.ArrayList;

/**
 * Created by Wimberley on 4/18/16.
 */
public class MountGameState extends GameState {

    private Mount activeMount;
    private MountController controller;

    public MountGameState(Map map, Avatar avatar, ArrayList<NPC> entities, ArrayList<Mount> mounts, ItemManager itemManager) {
        super(map, avatar, entities, mounts, itemManager);
    }

    @Override
    public void tick() {
        for(int i = 0; i < npcs.size(); i++){
            if(avatar.isDead()) {                    // indicates dead avatar
                if(avatar.getLives() == 0) {
                    // TODO: death state
                } else {
                    avatar.dropItems(itemManager);
                    map.moveCharacter(avatar, new Location(Settings.SPAWN_X, Settings.SPAWN_Y, Settings.SPAWN_Z));
                    avatar.setDead(false);
                }
            } else if(npcs.get(i).getLives() == 0) {           // indicated dead entity
                npcs.get(i).dropItems(itemManager);
                map.removeCharacter(npcs.get(i));
                npcs.remove(i);
                continue;
            }
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
        map.removeMount(activeMount);
        Location temp = activeMount.getLocation().getAdjacent(activeMount.getOrientation());
        activeMount.levitate(map.getTopTilePosition(temp.getX(), temp.getY()));
        map.addMount(activeMount);
    }

    public void dismount(){
        if(canDismount()) {
            activeMount.removePassenger();
            map.addCharacter(avatar);
            controller.activeGame();
        }
        else{
            GameMessageQueue.push("You can't dismount here :(");
        }
    }

    public void playerAttack(){
        Location tempLoc = new Location(avatar.getX(), avatar.getY(), avatar.getZ());
        Projectile temp = Projectile.makeFireBall(tempLoc, activeMount.getOrientation());
        projectiles.add(temp);
    }

    public void startCombatTimer() { avatar.startCombatTimer(); }

    public void setActiveMount(Mount mount){
        activeMount = mount;
    }

    private boolean canDismount(){
        Location temp = activeMount.getLocation().getAdjacent(activeMount.getOrientation());
        if (temp.getX() < 0 || temp.getY() < 0 || temp.getX() >= 14 || temp.getY() >= 14) {
            return false;
        }else return Math.abs(map.getTopTilePosition(temp.getX(), temp.getY()) - activeMount.getZ()) <= 1;
    }

    public void setController(MountController controller) {
        this.controller = controller;
    }
}