package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Door extends Entity {

    public OBJ_Door(GamePanel gp) {
        super(gp);

        direction = "down";
        name = "Door";


        down1 = setup("src\\res\\objects\\door.png");
        collision = true;

        solidArea.x = 0;
        solidArea.y = 16;
        solidArea.width = 48;
        solidArea.height = 32;
        solidAreaDefaltX = solidArea.x;
        solidAreaDefaltY = solidArea.y;

        // FileInputStream fisFile = new FileInputStream(file);
        // image = ImageIO.read(fisFile);
        // image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
    }
}
