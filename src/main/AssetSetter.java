package main;

import entity.NPC_Pinguim;
import object.OBJ_Boots;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

    //     gp.obj[1] = new OBJ_Boots(gp);
    //     gp.obj[1].worldX = 27 * gp.tileSize;
    //     gp.obj[1].worldY = 21 * gp.tileSize;

    // //     gp.obj[2] = new OBJ_Boots(gp);
    // //     gp.obj[2].worldX = 35 * gp.tileSize;
    // //     gp.obj[2].worldY = 20 * gp.tileSize;

    // //     gp.obj[3] = new OBJ_Boots(gp);
    // //     gp.obj[3].worldX = 25 * gp.tileSize;
    // //     gp.obj[3].worldY = 14 * gp.tileSize;

        gp.obj[4] = new OBJ_Boots(gp);
        gp.obj[4].worldX = 28 * gp.tileSize;
        gp.obj[4].worldY = 24 * gp.tileSize;
    }

    public void setNPC() {
        gp.npc[0] = new NPC_Pinguim(gp);
        gp.npc[0].worldX = gp.tileSize * 21;
        gp.npc[0].worldY = gp.tileSize * 22;
    }
}
