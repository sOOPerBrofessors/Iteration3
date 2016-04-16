package View.EntityView;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.Character;
import Model.Map.Orientation;
import Utilities.Settings;
import Utilities.Visitor.OccupationVisitor;
import View.EntityView.AvatarViewFactory.OccupationViewFactory;
import View.ViewUtilities.ImageAssets;

import java.awt.*;

/**
 * Created by dyeung on 4/6/16.
 */
public class CharacterView extends EntityView implements OccupationVisitor {
    //Width height scale formula is Height/Width * new width = new height
    private Image characterImage;
    public CharacterView(Character character){
        super(character);
        character.getOccupation().acceptOccupationVistor(this, orientation); //This will create the correct Occupation View
        characterImage = orientationView.getCurrentDirectionImage();
    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawImage(characterImage,xPixel* Settings.SCALEFACTOR,yPixel*Settings.SCALEFACTOR,entityWidth*Settings.SCALEFACTOR,entityHeight* Settings.SCALEFACTOR,null);

        g2d.dispose();

        // doesn't work
        drawHealthBar(g);
    }

    public void drawHealthBar(Graphics g) {
        double health = entity.getHealth();
        double baseHealth = entity.getBaseHealth();
        int width = Settings.GAMEWIDTH;
        int height = Settings.GAMEHEIGHT;

        g.setColor(Color.BLACK);
        g.drawRect(xPixel-width/128,yPixel-16,width/16+1,height/56+1);
        g.setColor(Color.RED);
        g.fillRect(xPixel-width/128+1,yPixel-16+1,(int)((health/baseHealth)*width/16), height/56);
    } // end drawHealthBar

    @Override
    public void updateOrientation(){
        if (orientation != entity.getOrientation()){
            orientationView.setDirection(entity.getOrientation());
            characterImage = orientationView.getCurrentDirectionImage();
        }
    }

    @Override
    public void visitSmasher(Orientation orientation) {
        orientationView = OccupationViewFactory.createSmasherView(orientation);
    }

    //TODO: CHANGE TO SUMMONER (CREATE A SUMMONERVIEW)
    @Override
    public void visitSummoner(Orientation orientation) {
        orientationView = OccupationViewFactory.createSummonerView(orientation);
    }

    @Override
    public void visitSneak(Orientation orientation) {
        orientationView = OccupationViewFactory.createSneakView(orientation);
    }

}
