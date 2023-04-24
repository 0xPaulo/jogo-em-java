package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
// import java.text.DecimalFormat;
import java.io.InputStream;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font font1, font2;
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

        // arial_80B = new Font("Areial", Font.BOLD, 80);
        // arial_30 = new Font("Areial", Font.PLAIN, 30);

        try {

            File ffont1 = new File("src\\res\\font\\m5x7.ttf");
            File ffont2 = new File("src\\res\\font\\m6x11.ttf");
            FileInputStream m5x7 = new FileInputStream(ffont1);
            FileInputStream m6x11 = new FileInputStream(ffont2);
            
            font1 = Font.createFont(Font.TRUETYPE_FONT, m5x7);
            font2 = Font.createFont(Font.TRUETYPE_FONT, m6x11);

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setFont(font2);
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
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32));
        x += gp.tileSize;
        y += gp.tileSize;

        for (String line : currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 40;
        }
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
