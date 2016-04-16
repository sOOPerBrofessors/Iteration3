package Model.Entity.Character.Mount;

import Model.Entity.Character.Character;
import Model.Entity.Entity;
import Model.Map.Location;
import Utilities.Navigation.Navigation;
import Utilities.Tickable;
import Utilities.Visitor.CharacterVisitor;

/**
 * Created by Wimberley on 4/6/16.
 */

//For now this will only contain this stuff (might implement more later)
public abstract class Mount extends Entity implements Tickable{
    protected Character character;
    public Mount(Navigation navigation, Location location){
        super(navigation, location);
    }

    @Override
    public void tick() {

    }


    public void addCharacter(Character character){
        this.character = character;
    }
}
