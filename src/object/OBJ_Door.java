package object;

import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class OBJ_Door extends SuperObject {
    public OBJ_Door() {
        name = "Door";
        try {

            File key = new File("src\\res\\objects\\door.png");
            FileInputStream fisKey = new FileInputStream(key);
            image = ImageIO.read(fisKey);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
