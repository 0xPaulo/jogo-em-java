package object;

import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class OBJ_Chest extends SuperObject {
    public OBJ_Chest() {
        name = "Chest";
        try {

            File key = new File("src\\res\\objects\\chest.png");
            FileInputStream fisKey = new FileInputStream(key);
            image = ImageIO.read(fisKey);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}