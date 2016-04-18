package Utilities.GameLoaderSaver.Load;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.NPC.NPC;
import Model.Entity.Character.Occupation.Occupation;
import Model.Map.Location;
import Model.Map.Orientation;
import org.w3c.dom.Element;

import java.util.HashMap;

/**
 * Created by dyeung on 4/17/16.
 */
class LoadCharacters {
    //Creating a list of commands to run by the messsage
    private final HashMap<String, Runnable> orientationCommands;
    private final HashMap<String, Runnable> occupationCommands;

    private Orientation orientation;
    private Occupation occupation;
    private Location location;
    private Avatar avatar;
    private NPC npc;
    public LoadCharacters(){
        occupationCommands = new HashMap<>();
        orientationCommands = new HashMap<>();
        occupationCommands.put("smasher", this::makeSmasher);
        occupationCommands.put("summoner", this::makeSummoner);
        occupationCommands.put("sneak", this::makeSneak);

        orientationCommands.put("south", this::setSouth);
        orientationCommands.put("southWest", this::setSouthWest);
        orientationCommands.put("southEast", this::setSouthEast);
        orientationCommands.put("north", this::setNorth);
        orientationCommands.put("northWest", this::setNorthWest);
        orientationCommands.put("northEast", this::setNorthEast);
    }
    public Avatar convertToAvatar(Element characterElement){
        //Idea is that I make it call all these functions and set it later and then reset to redo
        setLocation(characterElement);
        //Terrible design
        String occ = characterElement.getAttribute("occupation");
        occupationCommands.get(occ).run();
        String ori = characterElement.getAttribute("orientation");
        orientationCommands.get(ori).run();

        return avatar;
    }
    public NPC convertToCharacter(Element characterElement){
        setLocation(characterElement);
        String occ = characterElement.getAttribute("occupation");
        occupationCommands.get(occ).run();
        String ori = characterElement.getAttribute("orientation");
        orientationCommands.get(ori).run();

        return npc;
    }

    private void setLocation(Element characterElement){
        String loc = characterElement.getAttribute("location");
        String delims = ",";
        String[] tokens = loc.split(delims);
        int x = Integer.parseInt(tokens[0]);
        int y = Integer.parseInt(tokens[1]);
        int z = Integer.parseInt(tokens[2]);
        location = new Location(x,y,z);
    }

    private void makeSmasher(){
        avatar = Avatar.makeSmasher(location);
    }
    private void makeSneak(){
        avatar = Avatar.makeSneak(location);

    }
    private void makeSummoner(){
        avatar = Avatar.makeSummoner(location);

    }
    private void setSouth(){
        avatar.setOrientation(Orientation.SOUTH);
    }
    private void setSouthWest(){
        avatar.setOrientation(Orientation.SOUTHWEST);
    }
    private void setSouthEast(){
        avatar.setOrientation(Orientation.SOUTHEAST);
    }
    private void setNorth(){
        avatar.setOrientation(Orientation.NORTH);
    }
    private void setNorthWest(){
        avatar.setOrientation(Orientation.NORTHWEST);
    }
    private void setNorthEast(){
        avatar.setOrientation(Orientation.NORTHEAST);
    }
}
