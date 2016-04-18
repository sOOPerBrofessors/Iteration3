package Model.State.GameState;

import Controller.Controllers.GamePlayController;
import Model.Entity.Character.Avatar;
import Model.Entity.Character.Mount.Mount;
import Model.Entity.Character.NPC.NPC;

import java.util.ArrayList;

import Model.Entity.Projectile.Projectile;
import Model.Map.Map;
import Model.State.State;
import Utilities.ItemStuff.ItemManager;

/**
 * Created by Wimberley on 4/6/16.
 */
public abstract class GameState extends State {

    protected ArrayList<NPC> npcs;
    protected Map map;
    protected Avatar avatar;
    protected ItemManager itemManager;
    protected ArrayList<Projectile> projectiles;
    protected ArrayList<Mount> mounts;

    GameState(Map map, Avatar avatar, ArrayList<NPC> entities, ArrayList<Mount> mounts, ItemManager itemManager){
        //This will be done in the gameLoader
        this.map = map;
        this.avatar = avatar;
        this.npcs = entities;
        this.itemManager = itemManager;
        this.mounts = mounts;
        projectiles = new ArrayList<>();
    }

    //TEMP
    public Avatar getAvatar(){
        return avatar;
    }
    public Map getMap(){
        return map;
    }

    public void setAvatar(Avatar player){
        this.avatar = player;
    }

    public void setMap(Map map){
        this.map = map;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }
}