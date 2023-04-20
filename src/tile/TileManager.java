package tile;

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

        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        // loadMap("src/res/maps/world01.txt");
        loadMap("src/res/maps/mapateste.txt");
    }

    public void getTileImage() {

            setup("grass","0",0, false);
            setup("wall","1",1, true);
            setup("water","2",2, true);
            setup("earth","3",3, false);
            setup("tree","4",4, true);
            setup("sand","5",5, false);
            
    }

    public void setup(String Sprite, String imagePath, int index, boolean collision) {

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
