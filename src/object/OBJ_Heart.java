package object;

import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Heart extends SuperObject {

    GamePanel gp;

    public OBJ_Heart(GamePanel gp) {

        this.gp = gp;

        name = "Heart";
        try {

            File heart_full = new File("src\\res\\objects\\heart_full.png");
            File heart_half = new File("src\\res\\objects\\heart_half.png");
            File heart_blank = new File("src\\res\\objects\\heart_blank.png");

            FileInputStream hFull = new FileInputStream(heart_full);
            FileInputStream hHalf = new FileInputStream(heart_half);
            FileInputStream hBlank = new FileInputStream(heart_blank);

            image = ImageIO.read(hFull);
            image2 = ImageIO.read(hHalf);
            image3 = ImageIO.read(hBlank);

            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
            image2 = uTool.scaleImage(image2, gp.tileSize, gp.tileSize);
            image3 = uTool.scaleImage(image3, gp.tileSize, gp.tileSize);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}