package Model.Map.Tile;

import Model.Entity.Entity;

/**
 * Created by sgl on 4/5/16.
 */

//This tile can hold LandEntities and items
public class GrassTile extends MobileTile {

    //private ArrayList<Item> itemList = new ArrayList<Item>();

    public GrassTile(){
    }

    @Override
    public void moveChar(Entity entity){
        super.entity = entity;
    }


}
