package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.OBJ_Key;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B, arial_30;
    // BufferedImage keyImage;

    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {
        // FONTES
        this.gp = gp;
        arial_40 = new Font("Areial", Font.PLAIN, 40);
        arial_80B = new Font("Areial", Font.BOLD, 80);
        arial_30 = new Font("Areial", Font.PLAIN, 30);

        // OBJ_Key keyUI = new OBJ_Key(gp);
        // keyImage = keyUI.image;
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);

        if (gp.gameState == gp.playState) {
            // Do playState stuff later
        }
        if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
        }
    }

    public void drawPauseScreen() {

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 50f));
        String text = "PAUSED";
        int x = getXforCenterdText(text);
        int y = gp.screenHeight / 2;

        g2.drawString(text, x, y);
    }

    public int getXforCenterdText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenHeight / 2 - length / 2;
        return x;
    }
}
