package Model.Map.Tile;

import Model.Entity.Character.Character;
import Model.Entity.Entity;
import Model.Items.Item;
import Model.Map.AreaEffect.AreaOfEffect;
import Utilities.Observers.TileObservable;
import Utilities.Observers.TileObserver;
import Utilities.Visitor.TileVisitor;

import java.util.ArrayList;

/**
 * Created by sgl on 4/5/16.
 */

//MobileTile can hold a single entity
public abstract class MobileTile extends Tile {
    protected Entity entity;
    protected AreaOfEffect areaOfEffect;
    public MobileTile(){
        entity = null;
    }

    //All MobileTiles will be able to be affected and traversed by projectiles
    @Override
    public boolean moveProjectile(Entity entity){
        //if Tile isn't null apply projectile effect on entity currently occupying the Tile
        if (hasEntity()){
            //entity.applyEffect(super.entity);
        }
        else this.entity = entity;
        return true;
    }

    public Entity getEntity(){
        return entity;
    }

    @Override
    public boolean hasEntity(){
        if (entity != null) {
            return true;
        }else {
            return false;
        }
    }
    private boolean hasAOE(){
        if (areaOfEffect != null) {
            return true;
        }else {
            return false;
        }
    }
    @Override
    public void addEntity(Entity entity) {
        this.entity = entity;
    }

    @Override
    public void removeEntity() {
        this.entity = null;
        notifyObservers();
    }
    public void addAOE(AreaOfEffect areaOfEffect){
        this.areaOfEffect = areaOfEffect;
    }
    public void removeAOE(){
        areaOfEffect = null;
    }

    @Override
    public void interactAOE(Character character) {
        if (hasAOE()) {
            //Or effects of AOE effecting character
            //character.affectStats(areaOfEffect);
            areaOfEffect.onInteract(character);
        }
    }

    @Override
    public void addItem(Item item) {
        //Do nothing
    }

    @Override
    public void removeItem() {
        //Do nothing
    }

}


