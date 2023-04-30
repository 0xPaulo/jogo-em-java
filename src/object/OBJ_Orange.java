package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Orange extends Entity {
        
    public OBJ_Orange(GamePanel gp) {
        super(gp);

        name = "Orange";
        down1 = setup("src\\res\\objects\\orange.png");

    }
}