package object;

import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class OBJ_Boots extends SuperObject {
    public OBJ_Boots() {
        name = "Boots";
        try {

            File key = new File("src\\res\\objects\\boots.png");
            FileInputStream fisKey = new FileInputStream(key);
            image = ImageIO.read(fisKey);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}