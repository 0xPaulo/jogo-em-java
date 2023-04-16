package object;

import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class OBJ_Boots extends SuperObject {
    public OBJ_Boots() {
        name = "Boots";
        try {

            File file = new File("src\\res\\objects\\boots.png");
            FileInputStream fisFile = new FileInputStream(file);
            image = ImageIO.read(fisFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}