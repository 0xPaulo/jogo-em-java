package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.GamePanel;
import main.Keyhandler;

public class Player extends Entity {

    Keyhandler keyH;

    public final int screenX;
    public final int screenY;
    public boolean bike = false;

    public Player(GamePanel gp, Keyhandler keyH) {

        super(gp);

        this.keyH = keyH;

        screenX = gp.screenWidth / 2;
        screenY = gp.screenHeight / 2;

        solidArea = new Rectangle();
        solidArea.x = 15; // pociçao
        solidArea.y = 25; // pociçao
        solidAreaDefaltX = solidArea.x;
        solidAreaDefaltY = solidArea.y;
        solidArea.width = 15; // tamanho x
        solidArea.height = 20; // tamanho y

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        worldX = gp.tileSize * 28; //- (gp.tileSize / 2);
        worldY = gp.tileSize * 19;
        speed = 4;
        direction = "up";
    }

    public void getPlayerImage() {

        stopped = setup("./src/res/player/papa_stopped.png");
        up1 = setup("./src/res/player/papa_up_1.png");
        up2 = setup("./src/res/player/papa_up_2.png");
        down1 = setup("./src/res/player/papa_down_1.png");
        down2 = setup("./src/res/player/papa_down_2.png");
        left1 = setup("./src/res/player/papa_left_1.png");
        left2 = setup("./src/res/player/papa_left_2.png");
        right1 = setup("./src/res/player/papa_right_1.png");
        right2 = setup("./src/res/player/papa_right_2.png");
    }

    public void update() {

        if (keyH.upPressed == true
                || keyH.downPressed == true
                || keyH.leftPressed == true
                || keyH.rightPressend == true
                || keyH.stopped == true) {
            if (keyH.upPressed == true) {
                direction = "up";

            } else if (keyH.downPressed == true) {
                direction = "down";

            } else if (keyH.leftPressed == true) {
                direction = "left";

            } else if (keyH.rightPressend == true) {
                direction = "right";
            } else if (keyH.stopped == true) {
                direction = "stopped";
            }
            // CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            // CHECK NPC COLLISION
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);

            // IF COLLESION IS FALSE, PLAYER CAN MOVE
            if (collisionOn == false) {

                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

    }

    public void pickUpObject(int i) {
        if (i != 999) {
            String objectName = gp.obj[i].name;

            switch (objectName) {

                case "Boots":
                    gp.playSE(2);
                    speed += 2; // velocidade bota
                    gp.obj[i] = null;
                    gp.ui.showMessage("Voce pegou botas!");
                    bike = false;
                    getPlayerImage();
                    break;

            }
        }
    }

    public void interactNPC(int i) { // Se o index nao é 999
        if (i != 999) { // o player ta tocando um npc

            if (gp.keyH.enterPressed == true) {
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }
        }
        gp.keyH.enterPressed = false;
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        if (gp.timeWithoutCommands > gp.MAX_TIME_WITHOUT_COMMANDS) {
            image = stopped;
        } else {

            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        image = up1;
                    }
                    if (spriteNum == 2) {
                        image = up2;
                    }
                    break;

                case "down":
                    if (spriteNum == 1) {
                        image = down1;
                    }
                    if (spriteNum == 2) {
                        image = down2;
                    }
                    break;

                case "left":
                    if (spriteNum == 1) {
                        image = left1;
                    }
                    if (spriteNum == 2) {
                        image = left2;
                    }
                    break;

                case "right":
                    if (spriteNum == 1) {
                        image = right1;
                    }
                    if (spriteNum == 2) {
                        image = right2;
                    }
                    break;

            }
            gp.timeWithoutCommands++;

        }
        // System.out.println(gp.timeWithoutCommands);
        g2.drawImage(image, screenX, screenY, null);

        // DEBUG COLLISION
        // Color c = new Color(255, 0, 0, 200); // 255 max transparencia
        // g2.setColor(c);
        // g2.fillRect(screenX + 12, screenY + 23, 20, 24);
    }
}
