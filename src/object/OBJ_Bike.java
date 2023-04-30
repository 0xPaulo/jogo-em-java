package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Bike extends Entity {
        
    public OBJ_Bike(GamePanel gp) {
        super(gp);

        name = "Bike";
        down1 = setup("src\\res\\objects\\bike.png");

    }

}