package View.ViewUtilities.Panels;


import View.ViewManager;

import javax.swing.*;

/**
 * Created by Wimberley on 4/6/16.
 */
public class InitPanels {

    public InitPanels(){
    }

    public static void initialize(ViewManager viewManager){
        // initialize intro Jpanel onto main JFrame
        new IntroPanel(viewManager);
    }
}
