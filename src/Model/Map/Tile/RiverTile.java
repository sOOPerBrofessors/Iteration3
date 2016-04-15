package Model.Map.Tile;

import Model.Map.Orientation;
import Utilities.Visitor.TileVisitor;


/**
 * Created by sgl on 4/5/16.
 */
public class RiverTile extends WaterTile {
    private int flowRate;
    private Orientation direction;

    private RiverTile(int flowRate, Orientation direction){
        this.flowRate = flowRate;
        this.direction = direction;
    } // end private constructor

    public RiverTile makeNRiverTile(int flowRate) {
        return new RiverTile(flowRate, Orientation.NORTH);
    } // end factory method makeNRiverTile

    public RiverTile makeNERiverTile(int flowRate) {
        return new RiverTile(flowRate, Orientation.NORTHEAST);
    } // end factory method makeNERiverTile

    public RiverTile makeSERiverTile(int flowRate) {
        return new RiverTile(flowRate, Orientation.SOUTHEAST);
    } // end factory method makeSERiverTile

    public RiverTile makeSRiverTile(int flowRate) {
        return new RiverTile(flowRate, Orientation.SOUTH);
    } // end factory method makeSRiverTile

    public RiverTile makeSWRiverTile(int flowRate) {
        return new RiverTile(flowRate, Orientation.SOUTHWEST);
    } // end factory method makeSWRiverTile

    public RiverTile makeNWRiverTile(int flowRate) {
        return new RiverTile(flowRate, Orientation.NORTHWEST);
    } // end factory method makeNWRiverTile

    private boolean movePlayer(){
        //entity.move(direction);
        return true;
    }

    @Override
    public void acceptTileVisitor(TileVisitor tv) {
         tv.visitRiverTile(this);
    }
}
