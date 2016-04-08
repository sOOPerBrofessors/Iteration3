package Model.Stats;

/**
 * Created by sgl on 4/7/16.
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

    public CharacterStats(){
        agility = baseAgility = 3;
        experience = 0;
        hardiness = baseHardiness = 3;
        intellect = baseIntellect = 3;
        lives = baseLives = 3;
        strength = baseStrength = 3;

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
