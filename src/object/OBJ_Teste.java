package object;

import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Teste extends SuperObject {

    GamePanel gp;

    public OBJ_Teste(GamePanel gp) {

        this.gp = gp;

        name = "Teste";
        try {

            File file = new File("src\\res\\objects\\teste48.png");
            FileInputStream fisFile = new FileInputStream(file);
            image = ImageIO.read(fisFile);
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}