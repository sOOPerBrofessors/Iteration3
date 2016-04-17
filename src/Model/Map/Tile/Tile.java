package Model.Map.Tile;

import Model.Entity.Character.Character;
import Model.Entity.Entity;
import Model.Map.AreaEffect.AreaOfEffect;
import Model.Map.Tile.Terrain.Terrain;
import Model.Entity.Projectile.Projectile;
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

    //All movement detection is done here
    public boolean moveCharacter(Character character){
        if(character.checkStrategy(terrain) && checkMovement()){
            addCharacter(character);
            return true;
        }else{
            return false;
        }
    }

    //Might be increased later for items
    private boolean checkMovement(){
        if (hasCharacter()) {
            return false;
        }else{
            return true;
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

    public boolean moveProjectile(Projectile projectile){
        if(projectile.checkStrategy(terrain)){
            addProjectile(projectile);
            return true;
        }else{
            return false;
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

    // projectiles.. So cool bro
    public void addProjectile(Projectile projectile) {
        this.projectile = projectile;
        if(hasCharacter()){
            projectile.execute(character, projectile.getEffect());
            System.out.println("applying damage");
            this.projectile = null;
        }
        notifyObservers();
    }

    public void removeProjectile() {
        this.projectile = null;
        notifyObservers();
    }

    public void addAOE(AreaOfEffect areaOfEffect){
        this.areaOfEffect = areaOfEffect;
        notifyObservers();
    }

    /*The character being passed in the function is the character doing the interacting
    Tile contains the character being interacted on
    */
    public void doInteractionsNPC(Character initCharacter){
        if (hasCharacter()) {
            this.character.onInteract();
        }
    }

    public void doTileEffects(Character character) {
        doEffectAOE(character);
        //Effect item
        //Effect
    }

    public void applyProjectileEffects(Projectile projectile){

    }

    private void doEffectAOE(Character character){
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
        tv.visitTileHasProjectile(projectile);
    }

    @Override
    public void acceptTerrainVisitor(TerrainVisitor tv) {
        terrain.acceptTerrainVisitor(tv);
    }

    public Terrain getTerrain(){
        return terrain;
    }

    public Character getCharacter() {return character;}
}