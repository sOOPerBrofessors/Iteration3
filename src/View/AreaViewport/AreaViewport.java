package View.AreaViewport;

import Model.Entity.Character.Avatar;
import Model.Items.Item;
import Model.Map.Location;
import Model.Map.Map;
import Model.State.GameState.GameState;
import Utilities.ItemStuff.ItemManager;
import Utilities.Observers.Observer;
import View.AreaViewport.FogOfWar.FogOfWar;
import View.AreaViewport.HUDView.HUD;
import View.MapView.TileColumnView;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


/**
 * Created by dyeung on 4/5/16.
 */
public class AreaViewport extends JPanel{

    //TODO: Change this to map
    //View objects
    private MapView mapView;
    private Map map;
    private HashMap<Location, Item> items;

    //private CharacterView avatarView;
    private CameraView cameraView;
    private FogOfWar fogOfWar;
    private HUD hud;
    public AreaViewport(GameState gameState){
        //This needs to be initialized later on or grabbed from the inventory
        this.setBackground(Color.GRAY);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));

        Avatar avatar = gameState.getAvatar();
        cameraView = new CameraView(avatar);
        fogOfWar = new FogOfWar(avatar);
        hud = new HUD(avatar);
        map = gameState.getMap();
        MapViewFactory mapViewFactory = new MapViewFactory();
        mapView = mapViewFactory.createMapViewObjects(map);
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

    private void renderItems(Graphics g){
        ItemManager.renderItems(g, cameraView.computeOffset());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //TODO:These things only need to be called when an update happens from map
        offsetTiles();
        updateFogOfWar();
        //This is always called
        renderTiles(g);
<<<<<<< HEAD

        hud.updateHUD(g);
=======
        renderItems(g);
>>>>>>> 0a99fe5f291bbd1056eed9491699d263ce2cb45d
    }
}