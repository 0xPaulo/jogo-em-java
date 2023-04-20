package object;

import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Bike extends SuperObject {

    GamePanel gp;

    public OBJ_Bike(GamePanel gp) {
        
        this.gp = gp;

       name = "Bike";
        try {

            File file = new File("src\\res\\objects\\bike.png");
            FileInputStream fisFile = new FileInputStream(file);
            image = ImageIO.read(fisFile);
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}