package Model.Stats;

import Model.State.State;
import Utilities.GameMessageQueue;
import Utilities.Splats.DamageQueue;
import Utilities.Observers.Observer;
import Utilities.Observers.Subject;
import Utilities.Splats.ExperienceQueue;

import java.util.ArrayList;

/**
 * Created by sgl on 4/7/16.
 *
 * Class to hold character stats.  Initialized using factory methods which return a new instance of CharacterStats
 *  using the private constructor.  Constructor parameters take in an unknown number of integers (the ... notation).
 *  Will only be called locally, so don't be a dumbass and give it the wrong number of integers (or you'll get a null
 *  pointer).
 *
 * todo:
 *  add method to take in armor/weapon values on equipping an item and modify the equippedWeapon/equippedArmor values,
 *   then recompute offensiveRating/armorRating
 */
public class CharacterStats extends EntityStats implements Subject {
    ArrayList<Observer> observers;
    // primaryStats
    private int baseAgility;
    private int agility;
    private int experience;
    private int baseHardiness;
    private int hardiness;
    private int baseIntellect;
    private int intellect;
    private int baseLives;
    private int lives;
    private int baseStrength;
    private int strength;

    // derived stats
    private int level;
    private int baseMana;
    private int mana;
    private int baseOffensiveRating;
    private int offensiveRating;
    private int baseDefensiveRating;
    private int defensiveRating;
    private int baseArmorRating;
    private int armorRating;

    // equipment values
    private int equippedWeapon;
    private int equippedArmor;

    // miscellaneous
    private int skillPoint;
    private int experienceThreshold;        // experience to next level
    private double experienceMultiplier;    // amount to multiply experienceThreshold by on level up
    private double levelMultiplier;         // amount to multiply primary stats by on level up

    private CharacterStats(int... stats){
        observers = new ArrayList<>();
        agility = baseAgility = stats[0];
        experience = stats[1];
        hardiness = baseHardiness = stats[2];
        intellect = baseIntellect = stats[3];
        lives = baseLives = stats[4];
        strength = baseStrength = stats[5];
        movement = baseMovement = stats[6];

        equippedWeapon = equippedArmor = 0;

        level = 1;
        health = baseHealth = (baseHardiness + level);
        mana = baseMana = (baseIntellect + level);
        baseOffensiveRating = (equippedWeapon + baseStrength + level);
        baseDefensiveRating = (baseAgility + level);
        baseArmorRating = (equippedArmor + baseHardiness);

        experienceThreshold = 10;
        experienceMultiplier = 1.5;
        levelMultiplier = 1.1;
        skillPoint = 1;
    } // end constructor

    public static CharacterStats makeSmasherStats() {
        return new CharacterStats(
                3,      // agility
                0,      // experience
                3,      // hardiness
                3,      // intellect
                3,      // lives
                5,      // strength
                3);      // movement
    } // end factory method makeSmasherStats

    public static CharacterStats makeSneakStats() {
        return new CharacterStats(
                5,      // agility
                0,      // experience
                3,      // hardiness
                3,      // intellect
                3,      // lives
                3,      // strength
                5);     // movement
    } // end factory method makeSneakStats

    public static CharacterStats makeSummonerStats() {
        return new CharacterStats(
                3,      // agility
                0,      // experience
                3,      // hardiness
                5,      // intellect
                3,      // lives
                3,      // strength
                4);     // movement
    } // end factory method makeSummonerStats

    public CharacterStats makeNPC() {
        /*
        not sure if this works.  Ideally, when you make an NPC's stats you'll do it by saying:
            NPC.makeSmasher() {
                return new NPC(new Smasher(), Smasher.initSmasherStats().makeNPC());
            }
         which I'm not 100% sure will do what I want it to do.  All this method should do is give that NPC the same
         stats a character with that occupation should get with the exception of having one life.
         */
        baseLives = lives = 1;
        return this;
    } // end makeNPC

    public void levelUp() {
        // increase level by one; reset lives
        level++;

        lives = baseLives;

        // modify current xp and xp to next level
        experience -= experienceThreshold;
        experienceThreshold *= experienceMultiplier;

        // modify base stats by a constant multiplier
        baseAgility = (int)(baseAgility * levelMultiplier + 1);
        baseHardiness = (int)(baseHardiness * levelMultiplier + 1);
        baseIntellect = (int)(baseIntellect * levelMultiplier + 1);
        baseStrength = (int)(baseStrength * levelMultiplier + 1);
        baseMovement = (int)(baseMovement * levelMultiplier + 1);

        // reflect new stats
        agility = baseAgility;
        hardiness = baseHardiness;
        intellect = baseIntellect;
        strength = baseStrength;
        movement = baseMovement;

        // recompute derived stats
        recompute();

        // reset health and mana
        health = baseHealth;
        mana = baseMana;

        skillPoint += level;
    } // end levelup

    public void kill() {
        --lives;

        agility = baseAgility;
        hardiness = baseHardiness;
        intellect = baseIntellect;
        strength = baseStrength;
        movement = baseMovement;

        health = baseHealth;
        mana = baseMana;
    }

    public void livesEffect(int effect){
        lives += effect;
        if (lives < 0) {//GAME OVER
            lives = 0;
        }
        alert();
    }
    public void strengthEffect(int effect){
        strength += effect;
        if (strength < 0){
            strength = 0;
        }
        alert();
    }
    public void agilityEffect(int effect){
        agility += effect;
        if (agility < 0){
            agility = 0;
        }
        alert();
    }
    public void intellectEffect(int effect){
        intellect += effect;
        if (intellect < 0){
            intellect = 0;
        }
        alert();
    }
    public void hardinessEffect(int effect){
        hardiness += effect;
        if (hardiness < 0){
            hardiness = 0;
        }
        alert();
    }
    public void experienceEffect(int effect){
        experience += effect;
        if (experience < 0){
            experience = 0;
        } else if (experience >= experienceThreshold) {
            levelUp();
        }
        alert();
    }
    public void levelEffect(int effect){
        for(int i = 0; i < effect; i++) {
            levelUp();
        }
        alert();
    }
    public void healthEffect(int effect){
        health += effect;
        if (health > baseHealth) {
            health = baseHealth;
        }
        alert();
    }
    public void manaEffect(int effect){
        mana += effect;
        if (mana < 0){
            mana = 0;
        } else if (mana > baseMana) {
            mana = baseMana;
        }
        else if (mana > baseMana) {
            mana = baseMana;
        }
        alert();
    }

    public void movementEffect(int effect) {
        movement += effect;
        if(movement < 1) {
            movement = 1;
        }
        alert();
    }

    public void skillPointEffect (int effect) {
        skillPoint += effect;
        if(skillPoint < 0) {
            skillPoint = 0;
        }
        alert();
    }

    public void defensiveRatingEffect (int effect) {
        defensiveRating += effect;
        if (defensiveRating < 0) {
            defensiveRating = 0;
        }
        alert();
    }

    public void setEquippedWeapon(int equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
        //alert();

    } // end setEquippedWeapon

    public void setEquippedArmor(int equippedArmor) {
        this.equippedArmor = equippedArmor;
        //alert();
    } // end setEquippedArmor

    public void recompute() {
        baseHealth = (hardiness + level);
        baseMana = (intellect + level);
        baseOffensiveRating = (equippedWeapon + baseStrength + level);
        baseDefensiveRating = (baseAgility + level);
        baseArmorRating = (equippedArmor + baseHardiness);
        offensiveRating = equippedWeapon+strength+level;
        defensiveRating = agility+level;
        armorRating = equippedArmor + hardiness;
    } // end recompute

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void alert() {
        observers.forEach(Observer::update);
    }
    public int getBaseAgility() {
        return baseAgility;
    }

    public int getAgility() {
        return agility;
    }

    public int getExperience() {
        return experience;
    }

    public int getBaseHardiness() {
        return baseHardiness;
    }

    public int getHardiness() {
        return hardiness;
    }

    public int getBaseIntellect() {
        return baseIntellect;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getBaseLives() {
        return baseLives;
    }

    public int getLives() {
        return lives;
    }

    public int getBaseStrength() {
        return baseStrength;
    }

    public int getStrength() {
        return strength;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public int getBaseMana() {
        return baseMana;
    }

    public int getMana() {
        return mana;
    }

    public int getBaseOffensiveRating() {
        return baseOffensiveRating;
    }

    public int getOffensiveRating() {
        return offensiveRating;
    }

    public int getBaseDefensiveRating() {
        return baseDefensiveRating;
    }

    public int getDefensiveRating() {
        return defensiveRating;
    }

    public int getBaseArmorRating() {
        return baseArmorRating;
    }

    public int getArmorRating() {
        return armorRating;
    }

    public int getEquippedWeapon() {
        return equippedWeapon;
    }

    public int getEquippedArmor() {
        return equippedArmor;
    }

    public int getSkillPoint() {return skillPoint;}

    public int getExperienceThreshold() {
        return experienceThreshold;
    }

    public double getExperienceMultiplier() {
        return experienceMultiplier;
    }

    public double getLevelMultiplier() {
        return levelMultiplier;
    }
}
