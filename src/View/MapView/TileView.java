package View.MapView;

import Model.Entity.Character.Character;
import Model.Entity.Character.Mount.Mount;
import Model.Map.AreaEffect.AreaOfEffect;
import Model.Map.Location;
import Model.Map.Tile.Terrain.Terrain;
import Model.Map.Tile.Tile;
import Model.Entity.Projectile.Projectile;
import Utilities.Observers.Observer;
import Utilities.Observers.TileObserver;
import Utilities.Settings;
import Utilities.Visitor.TileVisitor;
import View.EntityView.CharacterView;
import View.EntityView.MountView;
import View.ItemView.UsableView;
import View.MapView.AOEView.AreaOfEffectView;
import View.EntityView.ProjectileView;
import View.TerrainView.*;
import View.ItemView.ItemView;
import View.ViewUtilities.Sprites.ImageAssets;


import javax.swing.*;
import java.awt.*;

/**
 * Created by dyeung on 4/7/16.
 */
public class TileView extends JComponent implements TileObserver, TileVisitor, Observer{

    protected Location location;
    protected int xPixel; // on the map
    protected int yPixel; // on the map
    protected Image image;
    private CharacterView characterView;
    private Tile tile;
    private ItemView itemView;
    private AreaOfEffectView areaOfEffectView;
    private TerrainView terrainView;
    private ProjectileView projectileView;
    private MountView mountView;

    public TileView(Tile tile, Location location){
        this.location = location;
        this.tile = tile;
        init();
        tile.acceptTileObserver(this);
        tile.acceptTileVisitor(this);
    }
    private void init(){
        //tile.getTerrain().acceptTerrainVisitor(this);
        updateTileView();
    }

    //TODO: make it so it just records the tile...this should not have to have
    private void updateTileView(){
       tile.acceptTileVisitor(this);
    }

     public void setPixels(int x, int y){
         xPixel = x;
         yPixel = y;
    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();

        renderTerrain(g2d);
        renderObjects(g2d);
        g2d.dispose();
    }
    private void renderObjects(Graphics2D g2d){
        int centeredX = xPixel + Settings.TILEWIDTH/4;
        int centeredY = yPixel + Settings.TILEHEIGHT/2;

        renderAOE(g2d, centeredX, centeredY);
        renderItem(g2d, centeredX, centeredY);
        renderEntity(g2d, centeredX, centeredY);
        renderMount(g2d, centeredX, centeredY);
        renderProjectile(g2d);
    }

    private void renderTerrain(Graphics g){
        terrainView.setXY(xPixel,yPixel);
        terrainView.paintComponent(g, location.getX(), location.getY());
    }

    private void renderAOE(Graphics g, int centerX, int centerY){
        if (hasAOE()) {
            areaOfEffectView.setPixels(centerX, centerY);
            Graphics2D g2d = (Graphics2D) g.create();
            areaOfEffectView.paintComponent(g2d);
        }
    }

    private boolean hasCharacter(){
        if (characterView == null) {
            return false;
        }else {
            return true;
        }
    }

    private boolean hasMount(){
        if (mountView == null) {
            return false;
        }else {
            return true;
        }
    }

    private boolean hasItem(){
        if (itemView == null) {
            return false;
        }else {
            return true;
        }
    }

    private boolean hasProjectile(){
        if (projectileView == null) {
            return false;
        }else {
            return true;
        }
    }
    private boolean hasAOE(){
        if (areaOfEffectView == null) {
            return false;
        }else {
            return true;
        }
    }

    //TODO: change this so it just renders map object views
    private void renderEntity(Graphics2D g2d, int centeredX, int centeredY){
        if (hasCharacter()){
            characterView.setPixels(centeredX + 3, centeredY +12);
            characterView.paintComponent(g2d);
        }
    }

    private void renderMount(Graphics2D g2d, int centeredX, int centeredY){
        if (hasMount()){
            mountView.setPixels(centeredX + 3, centeredY-25);
            mountView.paintComponent(g2d);
        }
    }

    private void renderItem(Graphics2D g2d, int centeredX, int centeredY){
        if(hasItem()) {
            itemView.setPixels(centeredX, centeredY);
            itemView.paintComponent(g2d);
        }
    }

    private void renderProjectile(Graphics2D g2d){
        if (hasProjectile() && !projectileView.ViewDone()){
            projectileView.paintComponent(g2d);
        }
    }

    @Override //This function is called when a tile is updated (for an example when a tile has a new entity)
    public void update() {
        updateTileView();
    }

    @Override
    public void remove() {

    }

    private void removeCharacterView(){
        if(characterView != null) {
            characterView.removeObservable();
            characterView = null;
        }
    }

    private void removeMountView(){
        if(mountView != null) {
            mountView = null;
        }
    }

    public void addItemView(ItemView itemView){
        if(this.itemView != null){
            this.itemView = new UsableView(ImageAssets.itemBag);
        }
        else {
            this.itemView = itemView;
        }
    }

    public void removeItemView(){
        itemView = null;
    }

    @Override
    public void visitTileHasMount(Mount mount) {
        removeMountView();
        if(mount != null){
            mountView = new MountView(mount, ImageAssets.mount);
        }
    }

    @Override
    public void visitTileTerrain(Terrain terrain) {
        terrainView = new TerrainView(terrain);
    }

    @Override
    public void visitTileHasCharacter(Character character) {
        removeCharacterView();
        if (character != null) characterView = new CharacterView(character);
    }

    @Override
    public void visitTileHasAOE(AreaOfEffect areaOfEffect) {
        if(areaOfEffect != null) {
            areaOfEffectView = new AreaOfEffectView(areaOfEffect);
        }
    }

    @Override
    public void visitTileHasProjectile(Projectile projectile) {
        if(projectile != null) {
            projectileView = new ProjectileView(projectile, ImageAssets.fireballs);
            projectileView.setPixels(xPixel + Settings.TILEWIDTH/4, yPixel + Settings.TILEHEIGHT/2);
        }
    }
}