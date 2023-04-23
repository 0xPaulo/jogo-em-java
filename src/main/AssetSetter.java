package main;

import entity.NPC_OldMan;
import object.OBJ_Boots;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

        gp.obj[7] = new OBJ_Boots(gp);
        gp.obj[7].worldX = 28 * gp.tileSize;
        gp.obj[7].worldY = 24 * gp.tileSize;
    }

    public void setNPC() {
        gp.npc[0] = new NPC_OldMan(gp);
        gp.npc[0].worldX = gp.tileSize * 21;
        gp.npc[0].worldY = gp.tileSize * 21;
    }
}
