package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldX, worldY; // Posição x e y da entidade
    public int speed; // Velocidade da entidade

    // Imagens para a animação da entidade em diferentes direções
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction; // Direção atual da entidade
    public int spriteCounter = 0; // Contador de animação para controlar o número de sprites exibidos
    public int spriteNum = 1; // Número de sprites a serem exibidos em cada animação
    public Rectangle solidArea;
    public boolean collisionOn = false;
}
