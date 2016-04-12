package Utilities.Visitor;

/**
 * Created by dyeung on 4/10/16.
 */

//This will be inherited by occupation
public interface OccupationVisitable {
    //This will allow occupation views to visit
    void acceptOccupationViewVistor(OccupationViewVisitor occupationViewVisitor);

    //In the future might require just strictly occupation visitors to visit (for load/save)
//    void acceptOccupationVistor(OccupationViewVisitor occupationVisitor);

}