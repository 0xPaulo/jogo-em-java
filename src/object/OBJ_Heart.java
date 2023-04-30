package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity {

    public OBJ_Heart(GamePanel gp) {
        super(gp);

        name = "Heart";
        image = setup("src\\res\\objects\\heart_full.png");
        image2 = setup("src\\res\\objects\\heart_half.png");
        image3 = setup("src\\res\\objects\\heart_blank.png");
    }
}