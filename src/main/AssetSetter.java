package main;

import entity.NPC_Pinguim;
import main.monster.MON_MatrixRobot;
import object.OBJ_Boots;
import object.OBJ_Door;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

        gp.obj[1] = new OBJ_Door(gp);
        gp.obj[1].worldX = 24 * gp.tileSize;
        gp.obj[1].worldY = 20 * gp.tileSize;

        gp.obj[4] = new OBJ_Boots(gp);
        gp.obj[4].worldX = 28 * gp.tileSize;
        gp.obj[4].worldY = 24 * gp.tileSize;
    }

    public void setNPC() {
        gp.npc[0] = new NPC_Pinguim(gp);
        gp.npc[0].worldX = gp.tileSize * 8;
        gp.npc[0].worldY = gp.tileSize * 46;
        gp.npc[1] = new NPC_Pinguim(gp);
        gp.npc[1].worldX = gp.tileSize * 9;
        gp.npc[1].worldY = gp.tileSize * 47;
        gp.npc[2] = new NPC_Pinguim(gp);
        gp.npc[2].worldX = gp.tileSize * 10;
        gp.npc[2].worldY = gp.tileSize * 45;

    }

    public void setMonster() {
        gp.monster[0] = new MON_MatrixRobot(gp);
        gp.monster[0].worldX = gp.tileSize * 42;
        gp.monster[0].worldY = gp.tileSize * 54;

        gp.monster[1] = new MON_MatrixRobot(gp);
        gp.monster[1].worldX = gp.tileSize * 11;
        gp.monster[1].worldY = gp.tileSize * 46;

        gp.monster[2] = new MON_MatrixRobot(gp);
        gp.monster[2].worldX = gp.tileSize * 4;
        gp.monster[2].worldY = gp.tileSize * 47;

    }
}
