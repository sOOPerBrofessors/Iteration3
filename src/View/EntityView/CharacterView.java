package View.EntityView;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.Character;
import Utilities.Visitor.OccupationViewVisitor;
import View.EntityView.AvatarViewFactory.OccupationViewFactory;
import View.ViewUtilities.ImageAssets;

import java.awt.*;

/**
 * Created by dyeung on 4/6/16.
 */
public class CharacterView extends EntityView implements OccupationViewVisitor {

    //private String url = "./res/Entity/newSneak.png";
    //Width height scale formula is Height/Width * new width = new height
    private Image avatarImage;
    private OccupationViewFactory occupationViewFactory;
    private Character character;

    public CharacterView(Character character){
        super(character);
        this.character = character;
        character.getOccupation().acceptOccupationViewVistor(this); //This will create the avatarImage necessary
    }

    private void renderOrientation(){
        avatarImage = ImageAssets.sneakS;
    }

    @Override
    public void paintComponent(Graphics g) {
        //System.out.println("CharacterView: paint was called");
        //Used for testing purposes
        //g.setColor(Color.blue);
        //g.drawRect(xPixel,yPixel,entityWidth,entityHeight);
        updateOrientationImage();
        g.drawImage(avatarImage,xPixel,yPixel,entityWidth, entityHeight,null);
    }

    @Override
    public void updateOrientationImage() {
        //avatarViewFactory.getView(this, avatar.getOccupation());
    }

    @Override
    public void createSmasherView() {
        avatarImage = ImageAssets.smasherS;
    }

    //TODO: CHANGE TO SUMMONER (CREATE A SUMMONERVIEW)
    @Override
    public void createSummonerView() {
        avatarImage = ImageAssets.smasherN;
    }

    @Override
    public void createSneakView() {
        avatarImage = ImageAssets.sneakS;
    }
}
