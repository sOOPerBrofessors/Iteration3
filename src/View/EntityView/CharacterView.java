package View.EntityView;

import Model.Entity.Character.Character;
import Model.Map.Orientation;
import Utilities.Splats.DamageQueue;
import Utilities.Settings;
import Utilities.Splats.DamageSplat;
import Utilities.Splats.ExperienceQueue;
import Utilities.Splats.ExperienceSplat;
import Utilities.Visitor.OccupationVisitor;
import View.EntityView.AvatarViewFactory.OccupationViewFactory;

import java.awt.*;

/**
 * Created by dyeung on 4/6/16.
 */

public class CharacterView extends EntityView implements OccupationVisitor {
    //Width height scale formula is Height/Width * new width = new height
    private Image image;
    private Character character;
    protected int viewHeight = Settings.ENTITYHEIGHT;
    protected int viewWidth = Settings.ENTITYWIDTH;

    public CharacterView(Character character){
        super(character);
        this.character = character;
        character.getOccupation().acceptOccupationVistor(this, orientation); //This will create the correct Occupation View
        image = orientationView.getCurrentDirectionImage();
    }

    @Override
    public void paintComponent(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, character.getAlpha()));

        g2d.drawImage(image,xPixel* Settings.SCALEFACTOR,yPixel*Settings.SCALEFACTOR,viewWidth*Settings.SCALEFACTOR,viewHeight* Settings.SCALEFACTOR,null);

        if(character.isInCombat()) {
            drawHealthBar(g2d);
        }
        if(character.hasDamageQueued())
            renderDamageSplats(g2d);
        if(character.hasExperienceQueued())
            renderExperienceSplats(g2d);


        g2d.dispose();
    }

    public void renderDamageSplats(Graphics2D g2d) {
        g2d.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 20));
        for(DamageSplat d : character.getDamageQueue().getAll()) {
            if(!d.isRunning())
                d.start();
            g2d.setColor(d.getColor());
            g2d.drawString(Integer.toString(d.getDamage()),
                    xPixel+Settings.ENTITYWIDTH/2+d.getxDelta()-10,
                    yPixel+Settings.ENTITYHEIGHT/2+d.getyDelta()+10);
            d.decrementyDelta();
            d.decrementAlpha();
        }
    } // end renderDamageSplate

    public void renderExperienceSplats(Graphics2D g2d) {
        g2d.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 20));
        for(ExperienceSplat e : character.getExperienceQueue().getAll()) {
            if(!e.isRunning())
                e.start();
            g2d.setColor(e.getColor());
            g2d.drawString("+" + Integer.toString(e.getExperience()),
                    xPixel+Settings.ENTITYWIDTH/2+e.getxDelta()-10,
                    yPixel+Settings.ENTITYHEIGHT/2+e.getyDelta()+10);
            e.decrementyDelta();
            e.decrementAlpha();
        }
    }

    @Override
    protected void adjustHeight() {
        yPixel = yPixel - viewHeight;
    }

    public void drawHealthBar(Graphics2D g2d) {
        double health = character.getHealth();
        double baseHealth = character.getBaseHealth();
        int width = Settings.GAMEWIDTH;
        int height = Settings.GAMEHEIGHT;

        g2d.setColor(Color.BLACK);
        g2d.drawRect(xPixel-width/128,yPixel-16,width/16+1,height/56+1);
        g2d.setColor(Color.RED);
        g2d.fillRect(xPixel-width/128+1,yPixel-16+1,(int)((health/baseHealth)*width/16), height/56);
    } // end drawHealthBar

    @Override
    public void updateOrientation(){
        if (orientation != character.getOrientation()){
            orientation = character.getOrientation();
            orientationView.setDirection(character.getOrientation());
            image = orientationView.getCurrentDirectionImage();
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

    public void visitPet(Orientation orientation) {

        orientationView = OccupationViewFactory.createPetView(orientation);

    }

}