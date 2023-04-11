package object;

import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class OBJ_Key extends SuperObject {

    public OBJ_Key() {
        name = "Key";
        try {

            File key = new File("src\\res\\objects\\key.png");
            FileInputStream fisKey = new FileInputStream(key);
            image = ImageIO.read(fisKey);

        } catch (Exception e) {
            e.printStackTrace();
        }
}

}
