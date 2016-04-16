package Model.Map.Tile;

import Model.Entity.Character.Character;
import Model.Entity.Entity;
import Model.Map.AreaEffect.AreaOfEffect;
import Model.Map.Location;
import Model.Map.Tile.Terrain.Terrain;
import Model.Projectile.Projectile;
import Utilities.Observers.TileObservable;
import Utilities.Observers.TileObserver;
import Utilities.Visitor.*;

import java.util.ArrayList;

/**
 * Created by sgl on 4/5/16.
 */
public class Tile implements TileVisitable, TileObservable, TerrainVisitable{
    private ArrayList<TileObserver> observers;
    private Terrain terrain;
    private Character character;
    private Projectile projectile;
    private AreaOfEffect areaOfEffect;

    public Tile(Terrain terrain){
        this.terrain = terrain;
        observers = new ArrayList<>();
    }
    public boolean moveCharacter(Character character){
        if(character.checkStrategy(terrain)){
            addCharacter(character);
            return true;
        }else{
            return false;
        }
    }


    @Override
    public void notifyObservers() {
        for(TileObserver tileObserver : observers){
            tileObserver.update();
        }
    }

    @Override
    public void acceptTileObserver(TileObserver tileObserver) {
        observers.add(tileObserver);
    }
    public void moveProjectile(Entity entity){
        //if Tile isn't null apply projectile effect on entity currently occupying the Tile
        if (hasCharacter()){
            //entity.applyEffect(super.entity);
        }
        else {
            //this.entity = entity;
            //return true;
        }
    }

    public boolean hasCharacter(){
        if (character != null) {
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
    public void addCharacter(Character character) {
        this.character = character;
        notifyObservers();
    }

    public void removeCharacter() {
        this.character = null;
        notifyObservers();
    }

    public void addAOE(AreaOfEffect areaOfEffect){
        this.areaOfEffect = areaOfEffect;
        notifyObservers();
    }

    //ADD ALL INTERACTIONS TO ENTITY ON THAT TILE
    public void doInteractions(Character character) {
        effectArea(character);
        //Effect item
        //Effect
    }

    private void effectArea(Character character){
        if (hasAOE()){
            areaOfEffect.onInteract(character);
        }
    }
    //Tiles need to do the checking for entites and stuff
    @Override
    public void acceptTileVisitor(TileVisitor tv) {
        tv.visitTileHasAOE(areaOfEffect);
        tv.visitTileHasCharacter(character);
        tv.visitTileTerrain(terrain);
    }

    @Override
    public void acceptTerrainVisitor(TerrainVisitor tv) {
        terrain.acceptTerrainVisitor(tv);
    }

    public Terrain getTerrain(){
        return terrain;
    }

}

