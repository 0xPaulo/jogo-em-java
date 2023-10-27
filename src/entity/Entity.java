
package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

// Classe que representa uma entidade do jogo
public class Entity {

    GamePanel gp;
    public int worldX, worldY; // Entidade no mundo
    public int speed;

    // Imagens para a animação da entidade em diferentes direções
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, stopped;
    public String direction = "down"; // Direção atual da entidad
    public int spriteCounter = 0; // número de sprites exibidos
    public int spriteNum = 1; // Número de sprites cada animação

    public Rectangle solidArea = new Rectangle(0, 0, 60, 48);

    // Posição x e y padrão da área sólida para colisão
    public int solidAreaDefaltX, solidAreaDefaltY;
    public boolean collisionOn = false;
    public int type; // 0 = player, 1 = npc, 2 = monster

    public int actionLockCounter = 0; // Delay movimento npc
    public boolean invincible = false;
    public int invincibleCounter = 0;
    String dialogues[] = new String[20];
    int dialogueIndex = 0;

    // SUPER OBJ COISAS
    public BufferedImage image, image2, image3;
    public String name;
    public boolean collision = false;

    // CHARACTER STATUS
    public int maxLife;
    public int life;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public void setAction() {
    }

    public void speak() {
        if (dialogues[dialogueIndex] == null) { // [proximo nao existe] Se é null
            dialogueIndex = 3; // Loopa no joelho
        }
        gp.ui.currentDialogue = dialogues[dialogueIndex]; // [0] [1]
        dialogueIndex++; // quando chamar o speak vai passa para o proximo index

        switch (gp.player.direction) { // arrumando a direçao do npc para conversar
            case "up":
                direction = "down";
                break;
            case "down":
                direction = "up";
                break;
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;

        }
    }

    public void update() {

        setAction();

        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkEntity(this, gp.npc);
        gp.cChecker.checkEntity(this, gp.monster);
        boolean contactPlayer = gp.cChecker.checkPlayer(this); // saber se esse this é o npc ou mon

        if (this.type == 2 && contactPlayer == true) {
            if (gp.player.invincible == false) {
                // leva dano
                gp.player.life -= 1;
                gp.player.invincible = true;
            }
        }

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

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        // CAMERA FRAME
        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

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
            // if para renderizar apenas o que for visivel
            g2.drawImage(image, screenX + 6, screenY, null);

            // // DEBUG COLLISION
            // Color c = new Color(0, 0, 255, 100); // 255 max transparencia
            // g2.setColor(c);
            // g2.fillRect(screenX, screenY+5, 62, 48);
        }
    }

    public BufferedImage setup(String imagePath) {

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        try {

            File file = new File(imagePath);
            FileInputStream fisFile = new FileInputStream(file);
            image = ImageIO.read(fisFile);
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
}
