// Declaração do pacote onde a classe se encontra
package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

// Classe que representa uma entidade do jogo
public class Entity {
    // Posição x e y da entidade no mundo
    public int worldX, worldY;
    // Velocidade da entidade
    public int speed;
    // Imagens para a animação da entidade em diferentes direções
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    // Direção atual da entidade
    public String direction;
    // Contador de animação para controlar o número de sprites exibidos
    public int spriteCounter = 0;
    // Número de sprites a serem exibidos em cada animação
    public int spriteNum = 1;
    // Área sólida para colisão
    public Rectangle solidArea;
    // Posição x e y padrão da área sólida para colisão
    public int solidAreaDefaltX, solidAreaDefaltY;
    // Verifica se a colisão está ativa
    public boolean collisionOn = false;
}
