package View.AreaViewport;

import Model.Entity.Avatar;
import Model.Map.Location;
import Model.Map.Map;
import Model.State.GameState;
import View.EntityView.AvatarView;
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
    private TileView[][][] tileViews = new TileView[MAXSIZE][MAXSIZE][MAXSIZE];
    private Map map;
    //TODO: Add avatar views and stuff
    private AvatarView avatarView;
    private CameraView cameraView;
    public AreaViewport(GameState gameState){
        //This needs to be initialized later on or grabbed from the inventory
        this.setBackground(Color.GRAY);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));


        //THIS IS HELLA TEMPORARY
        Avatar a = gameState.getAvatar();
        Location loc = new Location(5,5,1);

        //Might be a variable in AreaViewport
        avatarView = new AvatarView(loc);
        cameraView = new CameraView(avatarView);
        a.addObserver(avatarView);
        //Initializing the map

        map = gameState.getMap();
        MapViewFactory mapViewFactory = new MapViewFactory();
        tileViews = mapViewFactory.createMapViewObjects(map);




    }
    private void offsetTiles(){
        Location offset = cameraView.computeOffset();
        System.out.println("Offset:" + offset.getX() + "," + offset.getY() + "," + offset.getZ());
        for (int i = 0; i < tileViews.length; i++) {
            for (int j = 0; j < tileViews[0].length; j++){
                //updates the location of all the objects
                for (int k = 0; k < 10; k++){
                    tileViews[i][j][k].updateCameraOffset(offset);

                }
                //tileViews[i][j].setLocation();
            }
        }

    }
    public void renderTiles(Graphics g){
        for (int i = 0; i < MAXSIZE; i++) {
            for (int j = 0; j < MAXSIZE; j++){
//                for (int k = 0; i < 10; i++) {
//                    tileViews[i][j][k].paintComponent(g);
//                }
                tileViews[i][j][0].paintComponent(g);
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //System.out.println("Area viewport is painting");
       // Location offset = cameraView.computeOffset();
//        if (cameraView.requiresOffset()) {
//            System.out.println("offset required");
//            offsetTiles();
//            //avatarView.updateCameraOffset(offset);
//            System.out.println("Offset done");
//        }
        renderTiles(g);
        avatarView.paintComponent(g);
    }
}
