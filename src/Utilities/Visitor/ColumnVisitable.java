package Utilities.Visitor;

import View.MapView.MapObjectView;

import java.util.ArrayList;

/**
 * Created by dyeung on 4/9/16.
 */
public interface ColumnVisitable {
    //MapObjectView acceptMapVisitor(ColumnVisitor columnVisitor);
    ArrayList<MapObjectView> acceptMapVisitor(ColumnVisitor columnVisitor);
}
