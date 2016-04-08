package Model.Map.Tile;

import Model.Entity.Entity;

/**
 * Created by sgl on 4/5/16.
 */

//MobileTile can hold a single entity
public abstract class MobileTile extends Tile{
    protected Entity entity;

    public MobileTile(){
        entity = null;
    }

    //All MobileTiles will be able to be affected and traversed by projectiles
    @Override
    public void moveProjectile(Entity entity){
        //if Tile isn't null apply projectile effect on entity currently occupying the Tile
        if (this.entity != null){
            //entity.applyEffect(super.entity);
        }
        else this.entity = entity;
    }

}


