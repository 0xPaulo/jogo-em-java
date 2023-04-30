package main.monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class MON_MatrixRobot extends Entity {

    public MON_MatrixRobot(GamePanel gp) {
        super(gp);

        type = 2;
        name = "Matrix Robot";
        speed = 1;
        maxLife = 4;
        life = maxLife;

        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaltX = solidArea.x;
        solidAreaDefaltY = solidArea.y;

        getImage();
    }

    public void getImage() {
        up1 = setup("src\\res\\monster\\matrix_robot_down_1.png");
        up2 = setup("src\\res\\monster\\matrix_robot_down_2.png");
        down1 = setup("src\\res\\monster\\matrix_robot_down_1.png");
        down2 = setup("src\\res\\monster\\matrix_robot_down_2.png");
        left1 = setup("src\\res\\monster\\matrix_robot_down_1.png");
        left2 = setup("src\\res\\monster\\matrix_robot_down_2.png");
        right1 = setup("src\\res\\monster\\matrix_robot_down_1.png");
        right2 = setup("src\\res\\monster\\matrix_robot_down_2.png");
    }

    public void setAction(){
        actionLockCounter++;

        if (actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1; // pick up a number 1 to 100

            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75 && i <= 100) {
                direction = "right";
            }
            actionLockCounter = 0;
    }

}}
