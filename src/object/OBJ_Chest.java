package object;

import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class OBJ_Chest extends SuperObject {
    public OBJ_Chest() {
        name = "Chest";
        try {

            File file = new File("src\\res\\objects\\chest.png");
            FileInputStream fisFile = new FileInputStream(file);
            image = ImageIO.read(fisFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}