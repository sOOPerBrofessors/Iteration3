package Visitors;

import Controller.AI_Controller.VisualCortex.VisualInformation.VisualInformation;

/**
 * Created by aseber on 4/7/16.
 */
public interface VisualInformationVisitor {

    void visit(VisualInformation target);

}
