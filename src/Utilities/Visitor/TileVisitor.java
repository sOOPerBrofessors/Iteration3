package Utilities.Visitor;

import Model.Entity.Character.Character;
import Model.Entity.Character.Mount.Mount;
import Model.Map.AreaEffect.AreaOfEffect;
import Model.Map.Tile.Terrain.Terrain;
import Model.Entity.Projectile.Projectile;

/**
 * Created by dyeung on 4/15/16.
 */
public interface TileVisitor {
    void visitTileHasMount(Mount mount);
    void visitTileTerrain(Terrain terrain);
    void visitTileHasCharacter(Character character);
    //void visitTileHasItem(Item item);
    void visitTileHasAOE(AreaOfEffect areaOfEffect);
    void visitTileHasProjectile(Projectile projectile);
}
