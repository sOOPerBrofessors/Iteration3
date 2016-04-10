package Utilities.Visitor;

/**
 * Created by dyeung on 4/9/16.
 */
public interface EntityVisitable {
    void acceptEntityVisitor(EntityVisitor entityVisitor);
}
