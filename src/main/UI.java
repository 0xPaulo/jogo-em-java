package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
// import java.text.DecimalFormat;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B, arial_30;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialogue = "";

    // double playTime;
    // DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {
        // FONTES
        this.gp = gp;
        arial_40 = new Font("Areial", Font.PLAIN, 40);
        arial_80B = new Font("Areial", Font.BOLD, 80);
        arial_30 = new Font("Areial", Font.PLAIN, 30);

    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);
        // PLAY STATE
        if (gp.gameState == gp.playState) {
            // Do playState stuff later
        }
        // PAUSE STATE
        if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
        }
        // DIALOGUE STATE
        if (gp.gameState == gp.dialogueState) {
            drawDialogueScreen();
        }
    }

    public void drawPauseScreen() {

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 50f));
        String text = "PAUSED";
        int x = getXforCenterdText(text);
        int y = gp.screenHeight / 2;

        g2.drawString(text, x, y);
    }

    public void drawDialogueScreen() {

        // int x = 50; funciona
        // WINDOW
        int x = gp.tileSize * 2; // 2 tiles da esquerda pra direita
        int y = gp.tileSize / 2; // de cima pra baixo
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4; // 5 tiles de altura
        drawSubWindow(x, y, width, height);

        // TEXTO DENTRO DA JANELA
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,32));
        x += gp.tileSize;
        y += gp.tileSize;
        g2.drawString(currentDialogue,x,y);

    }

    public void drawSubWindow(int x, int y, int width, int height) {

        Color c = new Color(0, 0, 0, 210); // 255 max transparencia
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35); // 35 borda

        // Bordas Brancas
        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5)); // 5 pixels
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    public int getXforCenterdText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenHeight / 2 - length / 2;
        return x;
    }
}
