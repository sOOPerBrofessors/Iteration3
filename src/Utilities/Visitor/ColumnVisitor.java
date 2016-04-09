package Utilities.Visitor;

import Model.Entity.Character.Avatar;
import View.EntityView.AvatarView;

/**
 * Created by dyeung on 4/9/16.
 */
public interface ColumnVisitor {
    //void createNPCView();
    //void createItemView();
    //void createProjectileView();
    //void createMountView();


    //We actually can't do avatar since it requires an avatar to be passed in. Also doesn't make sense since there is only
    // one avatar
    AvatarView createAvatarView(Avatar avatar);
}
