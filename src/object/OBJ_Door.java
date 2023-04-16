package object;

import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class OBJ_Door extends SuperObject {
    public OBJ_Door() {
        name = "Door";
        try {

            File file = new File("src\\res\\objects\\door.png");
            FileInputStream fisFile = new FileInputStream(file);
            image = ImageIO.read(fisFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }

}
