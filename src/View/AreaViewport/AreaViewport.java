package View.AreaViewport;

import Model.Entity.Avatar;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Tile.GrassTile;
import Model.State.GameState;
import Utilities.GameLoader;
import Utilities.Settings;
import View.EntityView.AvatarView;
import View.EntityView.EntityView;
import View.TerrainView.GrassTileview;

import javax.swing.*;
import java.awt.*;



/**
 * Created by dyeung on 4/5/16.
 */
public class AreaViewport extends JPanel {

    //used for testing purposes
    public static final int MAXSIZE = 10;

    //TODO: Change this to map
    private GrassTileview[][] tileViews = new GrassTileview[MAXSIZE][MAXSIZE];

    //TODO: Add avatar views and stuff
    private AvatarView avatarView;
    private CameraView cameraView;
    public AreaViewport(GameState gameState){
        //This needs to be initialized later on or grabbed from the inventory
        this.setBackground(Color.GRAY);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));


        //THIS IS HELLA TEMPORARY
        //Avatar a = gameState.getAvatar();
        //Location loc = new Location(5,5,1);

        //Might be a variable in AreaViewport
        //avatarView = new AvatarView(loc);
        //cameraView = new CameraView(avatarView);
        //a.addObserver(avatarView);
        //Initializing the map
        //Map map = gameState.getMap();

        for (int i = 0; i < MAXSIZE; i++){
            for(int j = 0; j < MAXSIZE; j++){
                Location location = new Location(i,j, 1);
                tileViews[i][j] = new GrassTileview(location);
                //add(tileViews[i][j]);
            }
        }


    }
    public void offsetTiles(){
        Location offset = cameraView.computeOffset();
        System.out.println("Offset:" + offset.getX() + "," + offset.getY() + "," + offset.getZ());
        for (int i = 0; i < MAXSIZE; i++) {
            for (int j = 0; j < MAXSIZE; j++){
                //updates the location of all the objects
                tileViews[i][j].updateCameraOffset(offset);
                //tileViews[i][j].setLocation();
            }
        }

    }
    public void renderTiles(Graphics g){
        for (int i = 0; i < MAXSIZE; i++) {
            for (int j = 0; j < MAXSIZE; j++){
                tileViews[i][j].paintComponent(g);
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       // Location offset = cameraView.computeOffset();
        /*if (cameraView.requiresOffset()) {
            System.out.println("offset required");
            offsetTiles();
            //avatarView.updateCameraOffset(offset);
            System.out.println("Offset done");
        }*/
        //renderTiles(g);
        //avatarView.paintComponent(g);
    }
}
