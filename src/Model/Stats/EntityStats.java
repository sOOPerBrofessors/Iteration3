package Model.Stats;

/**
 * Created by sgl on 4/7/16.
 */

//Entity stats contain just health and movement
    //can be modified with
    //
public class EntityStats {

    private int health = 0;
    private int movement = 0;

    public EntityStats(int health, int movement){
        healthEffect(health); //for rings of operation
        movementEffect(movement);
    }

    public EntityStats(){
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
}
