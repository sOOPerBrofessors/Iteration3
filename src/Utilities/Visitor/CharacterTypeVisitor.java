package Utilities.Visitor;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.NPC.NPC;

/**
 * Created by dyeung on 4/16/16.
 */
public interface CharacterTypeVisitor {
    void visitAvatar(Avatar avatar); // this will be taken care of by the actually entity
    void visitNPC(NPC npc);
}
