package View.ViewUtilities.Sprites;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//static class used to load in sprites, should only be used in ImageAssets class
class SpriteLoader {
    public static BufferedImage loadImage(String path){
        try {
            //Changed the path to match res
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
