package Model.Entity.Character.NPC;

import Controller.AI_Controller.AI_Controller;
import Controller.AI_Controller.Brain;
import Controller.AI_Controller.Personality.Personality;
import Model.Entity.Character.Character;
import Model.Entity.Character.NPC.NPCStrategy.NPCStrategy;
import Model.Entity.Character.Occupation.Occupation;
import Model.Faction.Faction;
import Model.Map.Location;
import Utilities.Tickable;
import Utilities.Visitor.CharacterTypeVisitor;
import Utilities.Visitor.CharacterVisitor;

/**
 * Created by Wimberley on 4/9/16.
 */
public class NPC extends Character implements Tickable{

    private Brain brain;
    private Faction faction;
    private Personality personality;
    private NPCStrategy npcStrategy;
    AI_Controller controller;

    public NPC(Occupation o, Location location, Personality personality, Faction faction, NPCStrategy npcStrategy) {
        super(o, location);
        this.faction = faction;
        this.personality = personality;
        this.npcStrategy = npcStrategy;
    }

    @Override
    public void tick(){
        brain.tick();
    }

    public void setController(AI_Controller controller) {

        this.controller = controller;

    }

    public AI_Controller getController() {

        return controller;

    }

    @Override
    public void update() {
        setDelay(getMovement());
    }

    @Override
    public void remove() {

    }

    public Personality getPersonality(){
        return personality;
    }

    public void setBrain(Brain brain){
        this.brain = brain;
    }

    @Override
    public void acceptCharacterVisitor(CharacterVisitor characterVisitor) {
        characterVisitor.visitInventory(inventory);
        characterVisitor.visitOccupation(o);
        characterVisitor.visitSkills(skills);
        characterVisitor.visitStats(stats);
    }

    @Override
    public void acceptCharacterTypeVisitor(CharacterTypeVisitor characterTypeVisitor) {
        characterTypeVisitor.visitNPC(this);
    }

    @Override
    public void onInteract() {
        System.out.println("NPC: I am being interacted on");
        npcStrategy.onInteract();
    }
}
