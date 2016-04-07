package Model.Stats;

/**
 * Created by sgl on 4/7/16.
 */
public class CharacterStats extends EntityStats {

    private int lives;
    private int strength;
    private int agility;
    private int intellect;
    private int hardiness;
    private int experience;
    private int level;
    private int health;
    private int mana;
    private int offensiveRating;
    private int defensiveRating;
    private int armorRating;

    private int baseLives;
    private int baseStrength;
    private int baseAgility;
    private int baseIntellect;
    private int baseHardiness;
    private int baseExperience;
    private int baseLevel;
    private int baseHealth;
    private int baseMana;
    private int baseOffensiveRating;
    private int baseDefensiveRating;
    private int baseArmorRating;



    public CharacterStats(){

    }

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
