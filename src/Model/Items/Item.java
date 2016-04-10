package Model.Items;

import Model.Map.MapObject;
import Model.Model;
import View.MapView.MapObjectView;

/**
 * Created by broskj on 4/6/16.
 *
 * Abstract class used to define all things which can be put on the map and used by a character in one form or another.
 *  May be extended to be picked up by a player, may act as an obstacle, or may be interacted with by the player.
 */
//Why is this extending model???
//public abstract class Item extends Model {
public abstract class Item implements MapObject {


} // end abstract class Item

