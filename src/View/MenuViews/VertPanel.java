package View.MenuViews;

/**
 * Created by sgl on 4/16/16.
 */
abstract class VertPanel extends ViewPanel {

    int ySel;
    int yMax;
    public abstract void selectUp();
    public abstract void selectDown();
    //public abstract void select();
}
