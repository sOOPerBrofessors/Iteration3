package View.AreaViewport;

import Model.Entity.Character.Avatar;
import Model.Map.Location;
import Model.Map.Map;
import Model.State.GameState;
import View.EntityView.AvatarView;
import View.MapView.TileColumnView;
import View.TerrainView.TileView;

import javax.swing.*;
import java.awt.*;



/**
 * Created by dyeung on 4/5/16.
 */
public class AreaViewport extends JPanel {

    //used for testing purposes
    public static final int MAXSIZE = 10;

    //TODO: Change this to map
    //View objects
    private TileColumnView[][] tileColumnView;
    private Map map;
    //TODO: Add avatar views and stuff
    private AvatarView avatarView;
    private CameraView cameraView;
    public AreaViewport(GameState gameState){
        //This needs to be initialized later on or grabbed from the inventory
        this.setBackground(Color.GRAY);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));


        //THIS IS HELLA TEMPORARY
        Avatar avatar = gameState.getAvatar();

        //Might be a variable in AreaViewport
        avatarView = new AvatarView(avatar);
        cameraView = new CameraView(avatarView);
        avatar.addObserver(avatarView);
        //Initializing the map
    
        map = gameState.getMap();
        MapViewFactory mapViewFactory = new MapViewFactory();
        tileColumnView = mapViewFactory.createMapViewObjects(map);




    }
    private void offsetTiles(){
        Location offset = cameraView.computeOffset();
        System.out.println("AreaViewPort: Offset:" + offset.getX() + "," + offset.getY() + "," + offset.getZ());
        for (int i = 0; i < tileColumnView.length; i++) {
            for (int j = 0; j < tileColumnView[0].length; j++){
                tileColumnView[i][j].offsetCamera(offset);
            }
        }

    }
    public void renderTiles(Graphics g){
        for (int i = 0; i < MAXSIZE; i++) {
            for (int j = 0; j < MAXSIZE; j++){
                tileColumnView[i][j].paintComponent(g);
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //System.out.println("Area viewport is painting");

        //offsetTiles()
        renderTiles(g);
        //avatarView.paintComponent(g); //NEEDS TO PAINT THIS FOR THE SOLE PURPOSE OF FOG OF WAR
    }
}
