package View.AreaViewport;

import Model.Entity.Character.Avatar;
import Model.Map.Location;
import Model.Map.Map;
import Model.State.GameState.GameState;
import View.AreaViewport.FogOfWar.FogOfWar;
import View.AreaViewport.HUDView.HUD;

import javax.swing.*;
import java.awt.*;


/**
 * Created by dyeung on 4/5/16.
 */
public class AreaViewport extends JPanel{

    //TODO: Change this to map
    //View objects
    private MapView mapView;
    private Map map;

    //private CharacterView avatarView;
    private CameraView cameraView;
    private FogOfWar fogOfWar;
    private HUD hud;

    public AreaViewport(GameState gameState){
        //This needs to be initialized later on or grabbed from the inventory
        this.setBackground(Color.BLACK);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));

        Avatar avatar = gameState.getAvatar();
        cameraView = new CameraView(avatar);
        fogOfWar = new FogOfWar(avatar);
        hud = new HUD(avatar);
        map = gameState.getMap();
        MapViewFactory mapViewFactory = new MapViewFactory();
        mapView = mapViewFactory.createMapViewObjects(map);
        mapView.setItemManager(gameState.getItemManager());
    }

    private void offsetTiles(){
        //Might be useful to have a check to see if offset is 0 before doing anything
        Location offset = cameraView.computeOffset();
        for (int i = 0; i < mapView.getXBound(); i++) {
            for (int j = 0; j < mapView.getYBound(); j++){
                mapView.offsetCamera(offset, i, j);
            }
        }
    }

    private void updateFogOfWar(){
        fogOfWar.setFogOfWar(mapView);
    }

    public void renderTiles(Graphics g){
        Location offset = cameraView.computeOffset();
        for (int i = 0; i < mapView.getXBound(); i++) {
            for (int j = 0; j < mapView.getYBound(); j++){
                mapView.render(g, j, i);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //TODO:These things only need to be called when an update happens from map
        offsetTiles();
        updateFogOfWar();
        //This is always called
        renderTiles(g);
        hud.updateHUD(g);
    }
}