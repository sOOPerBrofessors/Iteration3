package Utilities.Visitor;

import Model.Entity.Character.Avatar;
import View.EntityView.EntityView;

/**
 * Created by dyeung on 4/9/16.
 */
public interface EntityVisitor {
    //void createItemView(Item item)
    //void createProjectileView(Projectile projectile)
    void createAvatarView(Avatar avatar); // this will be taken care of by the actually entity
}
