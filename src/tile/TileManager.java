package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

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

        try {

            File grass = new File("src/res/tiles/0.png");
            FileInputStream fisGrass = new FileInputStream(grass);
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(fisGrass);

            File wall = new File("src/res/tiles/1.png");
            FileInputStream fisWall = new FileInputStream(wall);
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(fisWall);
            tile[1].collision = true;
            

            File water = new File("src/res/tiles/2.png");
            FileInputStream fisWater = new FileInputStream(water);
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(fisWater);
            tile[2].collision = true;
            

            File earth = new File("src/res/tiles/3.png");
            FileInputStream fisEarth = new FileInputStream(earth);
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(fisEarth);

            File tree = new File("src/res/tiles/4.png");
            FileInputStream fisTree = new FileInputStream(tree);
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(fisTree);
            tile[4].collision = true;

            File sand = new File("src/res/tiles/5.png");
            FileInputStream fisSand = new FileInputStream(sand);
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(fisSand);

        } catch (IOException e) {
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
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
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
