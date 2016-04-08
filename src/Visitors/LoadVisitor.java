package Visitors;

import LoadSave.LoadDocument;

/**
 * Created by aseber on 4/7/16.
 */
public interface LoadVisitor {

    void visit(LoadDocument document);

}
