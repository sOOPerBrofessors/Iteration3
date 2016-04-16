package Utilities.Visitor;

import Model.Entity.Character.Character;
import Model.Entity.Entity;
import Model.Items.Item;
import Model.Map.AreaEffect.AreaOfEffect;
import Model.Map.Tile.Terrain.Terrain;
import Model.Projectile.Projectile;

/**
 * Created by dyeung on 4/15/16.
 */
public interface TileVisitor {
    void visitTileTerrain(Terrain terrain);
    void visitTileHasCharacter(Character character);
    //void visitTileHasItem(Item item);
    void visitTileHasAOE(AreaOfEffect areaOfEffect);
    void visitTileHasProjectile(Projectile projectile);
}
