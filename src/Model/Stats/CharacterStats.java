package Model.Stats;

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
public class CharacterStats extends EntityStats {
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
    private int baseHealth;
    private int health;
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
    private int experienceThreshold;        // experience to next level
    private double experienceMultiplier;    // amount to multiply experienceThreshold by on level up
    private double levelMultiplier;         // amount to multiply primary stats by on level up

    private CharacterStats(int... stats){
        agility = baseAgility = stats[0];
        experience = stats[1];
        hardiness = baseHardiness = stats[2];
        intellect = baseIntellect = stats[3];
        lives = baseLives = stats[4];
        strength = baseStrength = stats[5];

        equippedWeapon = equippedArmor = 0;

        level = 1;
        health = baseHealth = (baseHardiness + level);
        mana = baseMana = (baseIntellect + level);
        baseOffensiveRating = (equippedWeapon + baseStrength + level);
        baseDefensiveRating = (baseAgility + level);
        baseArmorRating = (equippedArmor + baseHardiness);

        experienceThreshold = 10;
        experienceMultiplier = 1.5;
        levelMultiplier = 1.2;
    } // end constructor

    public static CharacterStats makeSmasherStats() {
        return new CharacterStats(
                3,      // agility
                0,      // experience
                3,      // hardiness
                3,      // intellect
                3,      // lives
                5);     // strength
    } // end factory method makeSmasherStats

    public static CharacterStats makeSneakStats() {
        return new CharacterStats(
                5,      // agility
                0,      // experience
                3,      // hardiness
                3,      // intellect
                3,      // lives
                3);     // strength
    } // end factory method makeSneakStats

    public static CharacterStats makeSummonerStats() {
        return new CharacterStats(
                3,      // agility
                0,      // experience
                3,      // hardiness
                5,      // intellect
                3,      // lives
                5);     // strength
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

    public void livesEffect(int effect){
        lives += effect;
        if (lives < 0){//GAME OVER
            lives = 0;
        }
    }
    public void strengthEffect(int effect){
        strength += effect;
        if (strength < 0){
            strength = 0;
        }
    }
    public void agilityEffect(int effect){
        agility += effect;
        if (agility < 0){
            agility = 0;
        }
    }
    public void intellectEffect(int effect){
        intellect += effect;
        if (intellect < 0){
            intellect = 0;
        }
    }
    public void hardinessEffect(int effect){
        hardiness += effect;
        if (hardiness < 0){
            hardiness = 0;
        }
    }
    public void experienceEffect(int effect){
        experience += effect;
        if (experience < 0){
            experience = 0;
        }
    }
    public void levelEffect(int effect){
        level += effect;
        if (level < 0){
            level = 0;
        }
    }
    public void healthEffect(int effect){
        health += effect;
        if (health < 0){
            health = 0;
            livesEffect(-1); //decrement a life
        }
    }
    public void manaEffect(int effect){
        mana += effect;
        if (mana < 0){
            mana = 0;
        }
    }
    public void offensiveRatingEffect(int effect){
        offensiveRating += effect;
        if (offensiveRating < 0){
            offensiveRating = 0;
        }
    }
    public void defensiveRatingEffect(int effect){
        defensiveRating += effect;
        if (defensiveRating < 0){
            defensiveRating = 0;
        }
    }
    public void armorRatingEffect(int effect){
        armorRating += effect;
        if (armorRating < 0){
            armorRating = 0;
        }
    }


}
