package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
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
    int standCounter = 0;

    public Player(GamePanel gp, Keyhandler keyH) {

        super(gp);

        this.keyH = keyH;

        screenX = gp.screenWidth / 2;
        screenY = gp.screenHeight / 2;

        solidArea = new Rectangle();
        solidArea.x = 15; // posiçao
        solidArea.y = 25; // posiçao
        solidAreaDefaltX = solidArea.x;
        solidAreaDefaltY = solidArea.y;
        solidArea.width = 15; // tamanho x
        solidArea.height = 20; // tamanho y

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        worldX = gp.tileSize * 24 - (gp.tileSize / 2);
        worldY = gp.tileSize * 28 - (gp.tileSize / 2);
        speed = 4;
        direction = "up";

        // PLAYER STATUS
        maxLife = 6;
        life = maxLife;
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
                || keyH.rightPressed == true
                || keyH.enterPressed == true) {
            if (keyH.upPressed == true) {
                direction = "up";

            } else if (keyH.downPressed == true) {
                direction = "down";

            } else if (keyH.leftPressed == true) {
                direction = "left";

            } else if (keyH.rightPressed == true) {
                direction = "right";
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

            // CHECK MONSTER COLLISION
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            contactMonster(monsterIndex);

            // CHECK EVENT
            gp.eHandler.checkEvent();

            gp.keyH.enterPressed = false;

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
        } else {
            standCounter++;
            if (standCounter > 80) {
                direction = "stopped";
                standCounter = 0;
            }
        }
        // THIS NEEDS TO BE OUTSIDE OF KEY IF STATEMENT
        if (invincible == true) {
            invincibleCounter++;
            if (invincibleCounter > 60) {
                invincible = false;
                invincibleCounter = 0;
            }
        }

    }

    public void pickUpObject(int i) {
        if (i != 999) {
            String objectName = gp.obj[i].name;

            switch (objectName) {

                case "Boots":
                    gp.playSE(2); // toca a musica 2 powerup
                    speed += 2; // velocidade bota
                    gp.obj[i] = null; // desaparecer
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
    }

    private void contactMonster(int i) {
        if (i != 999) {
            if (invincible == false) {
                life -= 1;
                invincible = true;
            }

        }

    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

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
            case "stopped":
                if (spriteNum == 1) {
                    image = stopped;
                }
                if (spriteNum == 2) {
                    image = stopped;
                }
                break;
        }

        // gp.timeWithoutCommands++;
        if (invincible == true) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        }
        g2.drawImage(image, screenX, screenY, null);
        // Colisao player
        // g2.setColor(Color.red);
        // g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width,
        // solidArea.height);
        // Reset alpha
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        // DEBUG
        // g2.setFont(new Font("Arieal", Font.PLAIN, 26));
        // g2.setColor(Color.white);
        // g2.drawString("Invencivel:" + invincibleCounter, 10, 400);
    }
    // teste de dimençoes
    // OBJ_Teste testeObj = new OBJ_Teste(gp);
    // Image testeImagem = testeObj.image;
    // g2.drawImage(testeImagem, screenX, screenY, null);

}
