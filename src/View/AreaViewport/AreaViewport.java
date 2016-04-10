package View.AreaViewport;

import Model.Entity.Character.Avatar;
import Model.Map.Location;
import Model.Map.Map;
import Model.State.GameState.GameState;
import View.MapView.TileColumnView;

import javax.swing.*;
import java.awt.*;



/**
 * Created by dyeung on 4/5/16.
 */
public class AreaViewport extends JPanel {

    //TODO: Change this to map
    //View objects
    private TileColumnView[][] tileColumnView;
    private Map map;

    //private CharacterView avatarView;
    private CameraView cameraView;
    public AreaViewport(GameState gameState){
        //This needs to be initialized later on or grabbed from the inventory
        this.setBackground(Color.GRAY);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));

        Avatar avatar = gameState.getAvatar();
        cameraView = new CameraView(avatar);

        map = gameState.getMap();
        MapViewFactory mapViewFactory = new MapViewFactory();
        tileColumnView = mapViewFactory.createMapViewObjects(map);


    }
    private void offsetTiles(){
        Location offset = cameraView.computeOffset();
        for (int i = 0; i < tileColumnView.length; i++) {
            for (int j = 0; j < tileColumnView[0].length; j++){
                tileColumnView[i][j].offsetCamera(offset);
            }
        }

    }
    public void renderTiles(Graphics g){
        for (int i = 0; i < tileColumnView.length; i++) {
            for (int j = 0; j < tileColumnView[0].length; j++){
                tileColumnView[j][i].paintComponent(g);
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        offsetTiles();
        renderTiles(g);
    }
}
