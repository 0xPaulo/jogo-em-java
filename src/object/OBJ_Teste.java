package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Teste extends Entity {
        
    public OBJ_Teste(GamePanel gp) {
        super(gp);

        name = "Teste";
        down1 = setup("src\\res\\objects\\teste.png");

    }
}