package Utilities.Visitor;

/**
 * Created by dyeung on 4/16/16.
 */
public interface ItemVisitor {
    void visitTakeableItem();
    void visitObstacle();
    void visitInteractive();
    void visitOneShot();
}
