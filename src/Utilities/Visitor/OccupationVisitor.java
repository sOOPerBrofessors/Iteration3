package Utilities.Visitor;

import Model.Map.Orientation;

/**
 * Created by dyeung on 4/10/16.
 */
public interface OccupationVisitor {
    void visitSmasher(Orientation orientation);
    void visitSummoner(Orientation orientation);
    void visitSneak(Orientation orientation);

    //For future usage
//    void createNPCView();

}
