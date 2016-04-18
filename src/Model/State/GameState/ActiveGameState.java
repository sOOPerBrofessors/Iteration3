package Model.State.GameState;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.NPC.NPC;
import Model.Entity.Projectile.Projectile;
import Model.Map.Location;
import Model.Map.Map;

import Model.Map.Orientation;
import Model.Skills.RangedSkills.Observation;
import Model.Skills.RangedSkills.ObservationInfo;
import Model.State.StateManager;
import Utilities.GameMessageQueue;
import Utilities.ItemStuff.ItemManager;
import Utilities.Settings;

import java.util.ArrayList;

/**
 * Created by Wimberley on 4/6/16.
 */
public class ActiveGameState extends GameState {
    StateManager stateManager;

    public ActiveGameState(Map map, Avatar avatar, ArrayList<NPC> entities, ItemManager itemManager) {
        super(map, avatar, entities, itemManager);
        map.addItemManager(itemManager);
    }

    @Override
    public void tick(){
        for(int i = 0; i < entities.size(); i++){
            if(avatar.isDead()) {                    // indicates dead avatar
                if(avatar.getLives() == 0) {
                    // TODO: death state
                } else {
                    map.moveCharacter(avatar, new Location(Settings.SPAWN_X, Settings.SPAWN_Y, Settings.SPAWN_Z));
                    avatar.setDead(false);
                }
            } else if(entities.get(i).getLives() == 0) {           // indicated dead entity
                map.removeCharacter(entities.get(i));
                entities.remove(i);
                continue;
            }
            entities.get(i).tick();
        }
        if(projectiles != null){
            for(int i = 0; i < projectiles.size(); i++){
                projectiles.get(i).tick(map);
            }
        }
    }

    // player commands from controller
    public void movePlayerN(){
        avatar.move(map, Orientation.NORTH);
        itemManager.contact(avatar);
    }

    public void movePlayerNE(){
        avatar.move(map, Orientation.NORTHEAST);
        itemManager.contact(avatar);
    }

    public void movePlayerSE(){
        avatar.move(map, Orientation.SOUTHEAST);
        itemManager.contact(avatar);
    }

    public void movePlayerS(){
        avatar.move(map, Orientation.SOUTH);
        itemManager.contact(avatar);
    }

    public void movePlayerSW(){
        avatar.move(map, Orientation.SOUTHWEST);
        itemManager.contact(avatar);
    }

    public void movePlayerNW(){
        avatar.move(map, Orientation.NORTHWEST);
        itemManager.contact(avatar);
    }

    public void playerAttack(){
        Location tempLoc = new Location(avatar.getX(), avatar.getY(), avatar.getZ());
        Projectile temp = Projectile.makeFireBall(tempLoc, avatar.getOrientation());
        projectiles.add(temp);
    }

    public void playerExecuteSkill(int index) {
        if (avatar.getSKillList().size() > index) {
            avatar.getSkill(index).execute(this);
        }
        else {
            GameMessageQueue.push("You don't have skill at this position");
        }
    }

    public void startCombatTimer() { avatar.startCombatTimer(); }

    public ObservationInfo playerObservationSkill(){
        Observation skill = (Observation) avatar.getSkill(1);
        return skill.execute(map, avatar.getOrientation());
    }

    public void playerInteract(){
        avatar.checkInteract(map);
        itemManager.interact(avatar);
    }

    public void setPlayer(Avatar player) {
        this.player = player;
    }

    public int getAvatarMovement() {
        return player.getMovement();
    }

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    public void setStateManager(StateManager stateManager) { this.stateManager = stateManager; }
}