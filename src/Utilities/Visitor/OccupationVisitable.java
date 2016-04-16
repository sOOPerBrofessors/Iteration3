package Utilities.Visitor;

import Model.Map.Orientation;

/**
 * Created by dyeung on 4/10/16.
 */

//This will be inherited by occupation
public interface OccupationVisitable {
    //This will allow occupation views to visit
    void acceptOccupationVistor(OccupationVisitor occupationViewVisitor, Orientation orientation);

    //In the future might require just strictly occupation visitors to visit (for load/save)
//    void acceptOccupationVistor(OccupationViewVisitor occupationVisitor);

}
