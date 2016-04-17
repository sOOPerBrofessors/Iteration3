package Model.Stats;

/**
 * Created by sgl on 4/7/16.
 */

//Entity stats contain just health and movement
    //can be modified with
    //
public class EntityStats {

    protected int health;
    protected int baseHealth;
    protected int movement;
    protected int baseMovement;

    public EntityStats(int health, int movement){
        this.health = baseHealth = health;
        this.movement = baseMovement = movement;
    }

    public EntityStats(){
        health = baseHealth = 0;
        movement = baseMovement = 0;
    }

    public void healthEffect(int effect){
        health += effect;
        if (health < 0){ //make sure stat is always positive (uint would insure that but there could be overflow
            health = 0;
        }
    }

    public void movementEffect(int effect){
        movement += effect;
        if (movement < 0){ //make sure stat is always positive (uint would insure that but there could be overflow
            movement = 0;
        }
    }

    public int getHealth() { return health; }
    public int getMovement() { return movement; }
}
