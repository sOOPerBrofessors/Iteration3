package Model.Items.Takeable;

import Model.Entity.Character.Character;

/**
 * Created by Wimberley on 4/16/16.
 */
public class Quest extends TakeableItem {

    private Quest(String name, String description) {
        super("Key", "A key to a chest", 5);
    }

    public static Quest makeKey(){
        return new Quest("Key", "A key to a chest");
    }
    // probably the most useless class ever
    @Override
    public boolean utilize(Character character) {
        //character.removeItem(this);
        return true;
    }
}
