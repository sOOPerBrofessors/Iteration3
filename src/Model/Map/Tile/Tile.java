package Model.Map.Tile;

import Model.Entity.Character.Character;
import Model.Entity.Character.Mount.Mount;
import Model.Map.AreaEffect.AreaOfEffect;
import Model.Map.Map;
import Model.Map.Tile.Terrain.Terrain;
import Model.Entity.Projectile.Projectile;
import Utilities.Observers.TileObservable;
import Utilities.Observers.TileObserver;
import Utilities.Timer.TimedEvent;
import Utilities.Visitor.*;

import java.util.ArrayList;

/**
 * Created by sgl on 4/5/16.
 */
public class Tile implements TileVisitable, TileObservable, TerrainVisitable{
    private final ArrayList<TileObserver> observers;
    private final Terrain terrain;
    private Character character;
    private Projectile projectile;
    private AreaOfEffect areaOfEffect;
    private Mount mount;

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

    public boolean moveMount(Mount mount){
        if(mount.checkStrategy(terrain) && checkMovement()){
            addMount(mount);
            return true;
        }else{
            return false;
        }
    }

    //Might be increased later for items
    private boolean checkMovement(){
        return !(hasCharacter() || hasMount());
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
        return character != null;
    }

    private boolean hasMount(){
        return mount != null;
    }

    private boolean hasAOE(){
        return areaOfEffect != null;
    }

    public void addCharacter(Character character) {
        this.character = character;
        notifyObservers();
    }

    public void addMount(Mount mount) {
        this.mount = mount;
        notifyObservers();
    }

    public void removeCharacter() {
        character = null;
        notifyObservers();
    }

    public void removeMount() {
        this.mount = null;
        notifyObservers();
    }

    // projectiles.. So cool bro
    public void addProjectile(Projectile projectile) {
        this.projectile = projectile;
        if(hasCharacter()){
            projectile.execute(character, projectile.getEffect());
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

    public boolean hasTrap() {
        if (areaOfEffect != null) {
            return areaOfEffect.getAlpha() == 0f && areaOfEffect.getActive();
        }else {
            return false;
        }
    }

    public void detectTrap() {
        this.areaOfEffect.setAlpha(1f);
        this.areaOfEffect.setDetected();
    }

    public boolean hasDetectedTrap() {
        if (this.hasAOE()) {
            return this.areaOfEffect.getDetected();
        }
        else {
            return false;
        }
    }

    public void removeTrap() {
        this.areaOfEffect.setActive();
        this.areaOfEffect.setAlpha(0f);
    }
    /*The character being passed in the function is the character doing the interacting
    Tile contains the character being interacted on
    */
    public void doInteractionsNPC(Character initCharacter){
        if (hasCharacter()) {
            this.character.onInteract();
        }
        if(hasMount()){
            mount.addPassenger(initCharacter);
        }
    }

    public void doTileEffects(Character character) {
        doEffectAOE(character);

        //Effect item
        //Effect
    }
    private boolean canMove;
    public void doRiverEffect(Map map, Character character) {

        terrain.onInteract(map, character);
    }
    public void delayMovement() {
        int delay = 100;
        /*
        starts a timer of duration 'delay'; the beginning of which toggles the userCanMakeInput
         value to false, and after finishing execution toggles it back to true
         */
        new TimedEvent(delay, () -> canMove = false, e -> canMove = true).start();
    } // end delayMovement

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
        tv.visitTileHasMount(mount);
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