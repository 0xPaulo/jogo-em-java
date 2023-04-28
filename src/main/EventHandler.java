package main;

import java.awt.Rectangle;

public class EventHandler {

    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;

    public EventHandler(GamePanel gp) {
        this.gp = gp;

        eventRect = new Rectangle();
        eventRect.x = 23;
        eventRect.y = 23;
        eventRect.width = 48; // tamanho do objeto evento
        eventRect.height = 48;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultX = eventRect.y;
    }

    public void checkEvent() {
        if (hit(17, 18, "left") == true) {
            damagePit(gp.dialogueState);
        }
        if (hit(28, 19, "up") == true) { // tem alguma coisa errada aqui
            healingPool(gp.dialogueState);
            // damagePit(gp.dialogueState);
        }
    //     if (hit(25, 28, "up") == true) {
    //         teleport(gp.dialogueState);
    //     }
    //     if (hit(6, 42, "left") == true) {
    //         teleportBack(gp.dialogueState);
    //     }
    }

    public boolean hit(int eventCol, int eventRow, String reqDirection) {
        // parecido com collision
        boolean hit = false;
        // Pegando a area do player solidad
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        // Pegando o solid do event
        eventRect.x = eventCol * gp.tileSize + eventRect.x;
        eventRect.y = eventRow * gp.tileSize + eventRect.y;

        // Checar se o player ta colidindo com o retangulo
        if (gp.player.solidArea.intersects(eventRect)) {
            if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                hit = true;
            }
        }
        // RESETANDO
        gp.player.solidArea.x = gp.player.solidAreaDefaltX;
        gp.player.solidArea.y = gp.player.solidAreaDefaltY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;

        return hit;
    }

    private void damagePit(int gameState) {
        gp.gameState = gameState;
        gp.ui.currentDialogue = "caiu no buraco";
        gp.player.life -= 1;
    }

    public void healingPool(int gameState) {
        if (gp.keyH.enterPressed == true) {
            gp.gameState = gameState;
            gp.ui.currentDialogue = "Coisa boua!!!";
            gp.player.life = gp.player.maxLife;
        }
    }

    private void teleport(int gameState) {
        gp.gameState = gameState;
        gp.ui.currentDialogue = "Teleportado!";
        // gp.player.direction= "stopped";
        // gp.player.worldX = gp.tileSize * 8;
        // gp.player.worldY = gp.tileSize * 42;
        
    }
    
    private void teleportBack(int gameState) {
        gp.gameState = gameState;
        gp.ui.currentDialogue = "Teleportado!";
        // gp.player.direction = "stopped";
        // gp.player.worldX = gp.tileSize * 25;
        // gp.player.worldY = gp.tileSize * 29;
    }
}
