package Utilities;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dyeung on 4/5/16.
 */
public class SpriteImageFactory {

    public static ImageIcon getImageIcon(String string) {

        ImageIcon image = new ImageIcon(string);

        if (image.getIconWidth() == -1 || image.getIconHeight() == -1) {

            System.out.println("Bad Image Path: " + string);
            image = new ImageIcon(string);

        }

        return image;
    }
    public static Image getImage(String string) {

        ImageIcon image = new ImageIcon(string);

        if (image.getIconWidth() == -1 || image.getIconHeight() == -1) {

            System.out.println("Bad Image Path: " + string);
            image = new ImageIcon(string);

        }

        return image.getImage();
    }
}
