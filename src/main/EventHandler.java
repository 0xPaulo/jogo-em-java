package main;

public class EventHandler {

    GamePanel gp;
    EventRect eventRect[][];
    int previousEventX, previousEventY;
    boolean canTouchEvent = true; // ativa se o player sair e voltar 1 tile de distancia

    public EventHandler(GamePanel gp) {
        this.gp = gp;

        eventRect = new EventRect[gp.maxWorldCol][gp.maxWorldRow];

        int col = 0;
        int row = 0;
        while (col < gp.maxWorldCol && row < gp.maxWorldRow) {

            eventRect[col][row] = new EventRect();
            eventRect[col][row].x = 23;
            eventRect[col][row].y = 23;
            eventRect[col][row].width = 48; // tamanho do objeto evento
            eventRect[col][row].height = 48;
            eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
            eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;

            col++;
            if (col == gp.maxWorldCol) {
                col = 0;
                row++;
            }
        }

    }

    public void checkEvent() {

        // CHECK IF THE PLAYER CHARACTER IS MORE THAN 1 TILE AWAY FROM THE LAST EVENT
        int xDistance = Math.abs(gp.player.worldX - previousEventX);
        int yDistance = Math.abs(gp.player.worldX - previousEventY);
        int distance = Math.max(xDistance, yDistance);
        if (distance > gp.tileSize) {
            canTouchEvent = true;
        }

        if (canTouchEvent == true) {

            if (hit(17, 18, "left") == true) {
                damagePit(17, 18, gp.dialogueState);
            }
            if (hit(28, 18, "up") == true) {
                healingPool(28, 18, gp.dialogueState);
            }
        }
        if (hit(25, 28, "any") == true) {
        teleport(gp.dialogueState);
        }
        // if (hit(6, 42, "left") == true) {
        // teleportBack(gp.dialogueState);
        // }
    }

    public boolean hit(int col, int row, String reqDirection) {
        // parecido com collision
        boolean hit = false;
        // Pegando a area do player solidad
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        // Pegando o solid do event
        eventRect[col][row].x = col * gp.tileSize + eventRect[col][row].x;
        eventRect[col][row].y = row * gp.tileSize + eventRect[col][row].y;

        // Checar se o player ta colidindo com o retangulo
        if (gp.player.solidArea.intersects(eventRect[col][row]) && eventRect[col][row].eventDone == false) {
            if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                hit = true;

                previousEventX = gp.player.worldX;
                previousEventY = gp.player.worldY;
            }
        }
        // RESETANDO
        gp.player.solidArea.x = gp.player.solidAreaDefaltX;
        gp.player.solidArea.y = gp.player.solidAreaDefaltY;
        eventRect[col][row].x = eventRect[col][row].eventRectDefaultX;
        eventRect[col][row].y = eventRect[col][row].eventRectDefaultY;

        return hit;
    }

    private void damagePit(int col, int row, int gameState) {
        gp.gameState = gameState;
        gp.ui.currentDialogue = "caiu no buraco";
        gp.player.life -= 1;
        // eventRect[col][row].eventDone = true; // Uma Unica Vez
        canTouchEvent = false; // Tem que sair de perto, fix bug
    }

    public void healingPool(int col, int row, int gameState) {
        if (gp.keyH.enterPressed == true) {
            gp.gameState = gameState;
            gp.ui.currentDialogue = "Coisa boua!!!";
            gp.player.life = gp.player.maxLife;
        }
    }


private void teleport(int gameState) {
gp.gameState = gameState;
gp.ui.currentDialogue = "Teleportado!";
gp.player.direction = "right";
gp.player.worldX = gp.tileSize * 7;
gp.player.worldY = gp.tileSize * 42;

}}

// private void teleportBack(int gameState) {
// gp.gameState = gameState;
// gp.ui.currentDialogue = "Teleportado!";
// gp.player.direction = "down";
// gp.player.worldX = gp.tileSize * 25;
// gp.player.worldY = gp.tileSize * 29;
// }
// }
