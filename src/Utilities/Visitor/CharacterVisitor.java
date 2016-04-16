package Utilities.Visitor;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.NPC.NPC;

/**
 * Created by dyeung on 4/9/16.
 */
public interface CharacterVisitor {
    //void createItemView(Item item)
    //void createProjectileView(Projectile projectile)
    void visitAvatar(Avatar avatar); // this will be taken care of by the actually entity
    void visitNPC(NPC npc);
}
