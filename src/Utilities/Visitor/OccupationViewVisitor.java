package Utilities.Visitor;

import Model.Map.Orientation;

/**
 * Created by dyeung on 4/10/16.
 */
public interface OccupationViewVisitor {
    void createSmasherView(Orientation orientation);
    void createSummonerView(Orientation orientation);
    void createSneakView(Orientation orientation);

    //For future usage
//    void createNPCView();

}
