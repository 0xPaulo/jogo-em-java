package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.OBJ_Key;

public class UI {
    GamePanel gp;
    Font arial_40, arial_80B, arial_30;
    BufferedImage keyImage;

    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Areial", Font.PLAIN, 40);
        arial_80B = new Font("Areial", Font.BOLD, 80);
        arial_30 = new Font("Areial", Font.PLAIN, 30);

        OBJ_Key keyUI = new OBJ_Key(gp);
        keyImage = keyUI.image;
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {

        // Verifica se o jogo foi finalizado
        if (gameFinished == true) {

            // Define a fonte e a cor do texto de vitória
            g2.setFont(arial_40);
            g2.setColor(Color.white);

            // Define a mensagem de vitória, calcula seu tamanho e posição na tela
            String text;
            int textLength;
            int x;
            int y;

            text = "Papa encontrou o maior tesouro de todos!";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 - (gp.tileSize * 3);
            g2.drawString(text, x, y);


            text = "Seu tempo: "+ dFormat.format(playTime)+"!";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 + (gp.tileSize * 4);

            // Desenha a mensagem de vitória na tela
            g2.drawString(text, x, y);

            // g2.setFont(arial_80B);
            // g2.setColor(Color.ORANGE);
            // text = "O amor";
            // textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            // x = gp.screenWidth / 2 - textLength / 2;
            // y = gp.screenHeight / 2 + (gp.tileSize * 2);
            // g2.drawString(text, x, y);

            // g2.setFont(arial_30);
            // g2.setColor(Color.ORANGE);
            // text = "Te amo win";
            // textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            // x = gp.screenWidth / 2 - textLength / 2;
            // y = gp.screenHeight / 2 + (gp.tileSize * 5);
            // g2.drawString(text, x, y);

            // Define a variável de execução do jogo como nula para finalizá-lo
            gp.gameThread = null;

        } else {

            // Define a fonte e a cor do texto de chaves coletadas
            g2.setFont(arial_40);
            g2.setColor(Color.white);

            // Desenha a imagem da chave coletada e a quantidade de chaves na tela
            g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2, null);
            g2.drawString("x " + gp.player.hasKey, 74, 65);

            // Timer
            playTime += (double) 1 / 60;
            g2.drawString("Time:" + dFormat.format(playTime), gp.tileSize * 11, 65);

            // Verifica se há uma mensagem a ser exibida na tela
            if (messageOn == true) {

                // Define a fonte e a posição da mensagem na tela
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);

                // Incrementa o contador de mensagens e verifica se o tempo de exibição terminou
                messageCounter++;

                if (messageCounter > 120) {
                    messageCounter = 2;
                    messageOn = false;
                }
            }
        }
    }
}
