package object;

import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class OBJ_Bike extends SuperObject {
    public OBJ_Bike() {
        name = "Bike";
        try {

            File file = new File("src\\res\\objects\\bike.png");
            FileInputStream fisFile = new FileInputStream(file);
            image = ImageIO.read(fisFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}