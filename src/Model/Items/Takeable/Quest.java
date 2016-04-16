package Model.Items.Takeable;

import Model.Entity.Character.Character;

/**
 * Created by Wimberley on 4/16/16.
 */
public class Quest extends TakeableItem {

    public static Quest makeKey(){
        return new Quest();
    }
    // probably the most useless class ever
    @Override
    protected void utilize(Character character) {
        //character.removeItem(this);
    }
}
