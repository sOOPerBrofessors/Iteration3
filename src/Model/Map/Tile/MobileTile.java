package Model.Map.Tile;

import Model.Entity.Entity;
import Model.Map.AreaEffect.AreaOfEffect;
import Model.Map.Tile.Terrain.Terrain;

/**
 * Created by sgl on 4/5/16.
 */

//MobileTile can hold a single entity
abstract class MobileTile extends Tile {
    protected Entity entity;
    protected AreaOfEffect areaOfEffect;

    public MobileTile(Terrain terrain){
        super(terrain);
    }


//    //All MobileTiles will be able to be affected and traversed by projectiles
//    @Override
//    public void moveProjectile(Entity entity){
//        //if Tile isn't null apply projectile effect on entity currently occupying the Tile
//        if (hasEntity()){
//            //entity.applyEffect(super.entity);
//        }
//        else this.entity = entity;
//        //return true;
//    }
//
//    public Entity getEntity(){
//        return entity;
//    }
//
//    @Override
//    public boolean hasEntity(){
//        if (entity != null) {
//            return true;
//        }else {
//            return false;
//        }
//    }
//    private boolean hasAOE(){
//        if (areaOfEffect != null) {
//            return true;
//        }else {
//            return false;
//        }
//    }
//    @Override
//    public void addEntity(Entity entity) {
//        this.entity = entity;
//    }
//
//    @Override
//    public void removeEntity() {
//        this.entity = null;
//        notifyObservers();
//    }
//    @Override
//    public void addAOE(AreaOfEffect areaOfEffect){
//        this.areaOfEffect = areaOfEffect;
//    }
//
//    //ADD ALL INTERACTIONS TO ENTITY ON THAT TILE
//    @Override
//    protected void doInteractions(Character character) {
//
//        effectArea(character);
//        //Effect item
//        //Effect
//    }
//
//    private void effectArea(Character character){
//        if (hasAOE()){
//            areaOfEffect.onInteract(character);
//        }
//    }
}


