package Model.Items.Takeable;

import Model.Entity.Character.Character;

/**
 * Created by Wimberley on 4/16/16.
 */
public class Quest extends TakeableItem {

    private Quest(String name, String description, int value) {
        super(name, description, value);
    }

    public static Quest makeKey(){
        return new Quest("Key", "A key to a chest", 5);
    }
    // probably the most useless class ever
    @Override
    public void utilize(Character character) {
        //character.removeItem(this);
    }
}
