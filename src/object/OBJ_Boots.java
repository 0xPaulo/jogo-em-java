package object;

import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Boots extends SuperObject {
        
    GamePanel gp;

    public OBJ_Boots(GamePanel gp) {
        
        this.gp = gp;

       name = "Boots";
        try {

            File file = new File("src\\res\\objects\\boots.png");
            FileInputStream fisFile = new FileInputStream(file);
            image = ImageIO.read(fisFile);
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}