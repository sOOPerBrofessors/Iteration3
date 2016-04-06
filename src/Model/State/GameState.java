package Model.State;

import Model.Entity.Entity;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Wimberley on 4/6/16.
 */
public abstract class GameState extends State{
    protected ArrayList<Entity> entities;
    //protected ArrayList<Item> items;
    protected Map map;
}
