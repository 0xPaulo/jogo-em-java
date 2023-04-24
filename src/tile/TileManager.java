package tile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp) {

        this.gp = gp;

        tile = new Tile[50];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        // loadMap("src/res/maps/world01.txt");
        loadMap("src/res/maps/mapateste.txt");
    }

    public void getTileImage() {

        setup("0", "000", 0, true);
        setup("grass00", "001", 1, false);
        setup("grass01", "002", 2, false);
        setup("road00", "003", 3, false);
        setup("road01", "004", 4, false);
        setup("road02", "005", 5, false);
        setup("road03", "006", 6, false);
        setup("road04", "007", 7, false);
        setup("road05", "008", 8, false);
        setup("road06", "009", 9, false);
        setup("road07", "010", 10, false);
        setup("road08", "011", 11, false);
        setup("road09", "012", 12, false);
        setup("road10", "013", 13, false);
        setup("road11", "014", 14, false);
        setup("road12", "015", 15, false);
        setup("tree01", "016", 16, true);
        setup("earth01", "017", 17, false);
        setup("water00", "018", 18, true);
        setup("water01", "019", 19, true);
        setup("water02", "020", 20, true);
        setup("water03", "021", 21, true);
        setup("water04", "022", 22, true);
        setup("water05", "023", 23, true);
        setup("water06", "024", 24, true);
        setup("water07", "025", 25, true);
        setup("water08", "026", 26, true);
        setup("water09", "027", 27, true);
        setup("water10", "028", 28, true);
        setup("water11", "029", 29, true);
        setup("water12", "030", 30, true);
        setup("water13", "031", 31, true);
        setup("wall", "032", 32, true);
        setup("hut01", "033", 33, true);
        setup("floor01", "034", 34, false);
        setup("table", "035", 35, false);
        setup("ladder01", "036", 36, false);
        setup("ladder02", "037", 37, false);
        setup("ship01", "038", 38, true);
        setup("ship02", "039", 39, true);
        setup("ship03", "040", 40, true);
        setup("ship04", "041", 41, true);
        setup("ship05", "042", 42, true);
        setup("ship06", "043", 43, true);

    }

    public void setup(String sprite, String imagePath, int index, boolean collision) {

        UtilityTool uTool = new UtilityTool();

        try {
            File novoSprite = new File("src/res/tiles/" + imagePath + ".png");
            FileInputStream fis = new FileInputStream(novoSprite);
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(fis);

            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadMap(String filePath) {
        try {
            FileInputStream is = new FileInputStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {

                String line = br.readLine();

                while (col < gp.maxWorldCol) {

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
        }
    }

    public void draw(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];
            // A posição da tela é calculada subtraindo a posição do jogador no mundo
            int worldX = worldCol * gp.tileSize; // adicionando a posição atual da tela do jogador
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                // if para renderizar apenas o que for visivel
                g2.drawImage(tile[tileNum].image, screenX, screenY, null);

                // // DEBUG COLLISION
                // Color c = new Color(0, 0, 255, 100); // 255 max transparencia
                // g2.setColor(c);
                // g2.fillRect(screenX, screenY, 47, 47);
            }
            // Estas linhas atualizam as variáveis
            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;


            }
        }

    }
}
