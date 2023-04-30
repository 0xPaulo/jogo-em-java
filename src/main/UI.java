package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import object.OBJ_Heart;
import object.OBJ_Orange;
import object.SuperObject;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font /*font1*/ font2;
    BufferedImage heart_full, heart_half, heart_blank;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialogue = "";
    public int commandNum = 0;
    public int titleScreenState = 0; // 0: menu 1:segundo menu
    Image laranjaImage;

    // double playTime;
    // DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {

        this.gp = gp;

        try {
            // FONTES
            // File ffont1 = new File("src\\res\\font\\m5x7.ttf");
            File ffont2 = new File("src\\res\\font\\m6x11.ttf");
            // FileInputStream m5x7 = new FileInputStream(ffont1);
            FileInputStream m6x11 = new FileInputStream(ffont2);

            // font1 = Font.createFont(Font.TRUETYPE_FONT, m5x7);
            font2 = Font.createFont(Font.TRUETYPE_FONT, m6x11);

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // CREATE HUD OBJECT
        SuperObject heart = new OBJ_Heart(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;

    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setFont(font2);
        g2.setColor(Color.white);

        // TITLE STATE
        if (gp.gameState == gp.titleState) {
            drawTitleScreen();
        }
        // PLAY STATE
        if (gp.gameState == gp.playState) {
            drawPlayerLife();
        }
        // PAUSE STATE
        if (gp.gameState == gp.pauseState) {
            // drawPlayerLife();
            drawPauseScreen();
        }
        // DIALOGUE STATE
        if (gp.gameState == gp.dialogueState) {
            drawPlayerLife();
            drawDialogueScreen();

        }
    }

    private void drawPlayerLife() {

        // gp.player.life = 3;

        int x = gp.tileSize / 2;
        int y = gp.tileSize / 2;
        int i = 0;

        // DRAW MAX LIFE
        while (i < gp.player.maxLife / 2) {
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += gp.tileSize;
        }
        // RESET
        x = gp.tileSize / 2;
        y = gp.tileSize / 2;
        i = 0;

        // DRAW CURRENT LIFE
        while (i < gp.player.life) {
            g2.drawImage(heart_half, x, y, null);
            i++;
            if (i < gp.player.life) {
                g2.drawImage(heart_full, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }
    }

    public void drawTitleScreen() {

        // Icone menu
        OBJ_Orange iconeLaranja = new OBJ_Orange(gp);
        laranjaImage = iconeLaranja.image;

        if (titleScreenState == 0) {

            g2.setColor(new Color(212, 144, 169)); // Rosa
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

            // TITLE NAME
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
            String text = "PAPA 200 DE QI";
            int x = getXforCenterdText(text);
            int y = gp.tileSize * 3;
            // SHADOW
            g2.setColor(Color.gray);
            g2.drawString(text, x + 5, y + 6);
            // MAIN COLOR
            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            // IMAGE TITLE SCREEN
            x = gp.screenWidth / 2 - (gp.tileSize * 2) / 2; // Colocar no centro da tela
            y += gp.tileSize * 2; // Aqui em baixo é bom colocar numeros divisores por 16
            g2.drawImage(gp.player.stopped, x, y, gp.tileSize * 2, gp.tileSize * 2, null);

            // MENU
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 42F));

            // commandNum = 0;

            text = "NEM GAME";
            x = getXforCenterdText(text);
            y += gp.tileSize * 3.5; // Distancia
            // Shadow
            g2.setColor(Color.gray);
            g2.drawString(text, x + 2, y + 2);
            // Color
            g2.setColor(Color.white);
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                // Icone g2.drawImage
                // g2.drawString(">", x - gp.tileSize, y);
                g2.drawImage(laranjaImage, x - gp.tileSize - 10, y - 45, null);

            }

            text = "LOAD GAME";
            x = getXforCenterdText(text);
            y += gp.tileSize + 5; // 1 Tile a mais dividido
            // Shadow
            g2.setColor(Color.gray);
            g2.drawString(text, x + 2, y + 2);
            // Color
            g2.setColor(Color.white);
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                // Icone g2.drawImage
                // g2.drawString(">", x - gp.tileSize, y);
                g2.drawImage(laranjaImage, x - gp.tileSize - 10, y - 45, null);

            }
            text = "QUIT";
            x = getXforCenterdText(text);
            y += gp.tileSize * 1.2; // Mais um tile a mais dividido
            // Shadow
            g2.setColor(Color.gray);
            g2.drawString(text, x + 2, y + 2);
            // Color
            g2.setColor(Color.white);
            g2.drawString(text, x, y);
            if (commandNum == 2) {
                // Icone g2.drawImage
                // g2.drawString(">", x - gp.tileSize, y);
                g2.drawImage(laranjaImage, x - gp.tileSize - 10, y - 45, null);

            }
        } else if (titleScreenState == 1) {
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(42f));

            String text = "Quem e voce?";
            int x = getXforCenterdText(text);
            int y = gp.tileSize * 3;
            g2.drawString(text, x, y);

            text = "PAPA";
            x = getXforCenterdText(text);
            y += gp.tileSize * 3;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x - gp.tileSize, y);
            }
            text = "Quase";
            x = getXforCenterdText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString(">", x - gp.tileSize, y);
            }
            text = "Manteiga";
            x = getXforCenterdText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 2) {
                g2.drawString(">", x - gp.tileSize, y);
            }
            text = "Back";
            x = getXforCenterdText(text);
            y += gp.tileSize * 2;
            g2.drawString(text, x, y);
            if (commandNum == 3) {
                g2.drawString(">", x - gp.tileSize, y);
            }
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
        int height = gp.tileSize * 4; // 4 tiles de altura
        
        drawSubWindow(x, y, width, height);
        // TEXTO DENTRO DA JANELA
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 38));
        x += gp.tileSize;
        y += gp.tileSize;

        for (String line : currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 40;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height) {
        // Cor do Retangulo
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
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }
}
