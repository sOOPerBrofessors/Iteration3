package Utilities.Visitor;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.NPC.NPC;
import Model.Entity.Character.Occupation.Occupation;
import Model.Inventory.Inventory;
import Model.Map.Location;
import Model.Skills.Skill;
import Model.Stats.CharacterStats;
import com.sun.org.glassfish.external.statistics.Stats;

import java.util.ArrayList;

/**
 * Created by dyeung on 4/9/16.
 */
public interface CharacterVisitor {

    void visitInventory(Inventory inventory);
    void visitOccupation(Occupation occupation);
    void visitStats(CharacterStats stats);
}

