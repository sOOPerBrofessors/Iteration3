package Utilities.Visitor;

import Model.Map.Orientation;

/**
 * Created by dyeung on 4/10/16.
 */
public interface OccupationVisitor {
    void visitSmasher(Orientation orientation);
    void visitSummoner(Orientation orientation);
    void visitSneak(Orientation orientation);
    void visitPet(Orientation orientation);
    void visitShopkeeper(Orientation orientation);
    void visitEnemy(Orientation orientation);

    //For future usage
//    void createNPCView();

}
