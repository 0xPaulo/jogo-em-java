package object;

import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class OBJ_Key extends SuperObject {

    public OBJ_Key() {
        name = "Key";
        try {

            File file = new File("src\\res\\objects\\key.png");
            FileInputStream fisFile = new FileInputStream(file);
            image = ImageIO.read(fisFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
