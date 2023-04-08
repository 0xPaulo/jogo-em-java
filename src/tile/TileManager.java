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
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp) {

        this.gp = gp;

        tile = new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();
        loadMap("src/res/maps/map01.txt");
    }

    public void getTileImage() {

        try {

            File grass = new File("src/res/tiles/grass.png");
            FileInputStream fisGrass = new FileInputStream(grass);
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(fisGrass);

            File wall = new File("src/res/tiles/wall.png");
            FileInputStream fisWall = new FileInputStream(wall);
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(fisWall);

            File water = new File("src/res/tiles/water.png");
            FileInputStream fisWater = new FileInputStream(water);
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(fisWater);

            File earth = new File("src/res/tiles/earth.png");
            FileInputStream fisEarth = new FileInputStream(earth);
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(fisEarth);

            File tree = new File("src/res/tiles/tree.png");
            FileInputStream fisTree = new FileInputStream(tree);
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(fisTree);

            File sand = new File("src/res/tiles/sand.png");
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

            while (col < gp.maxScreenCol && row < gp.maxScreenRow) {

                String line = br.readLine();

                while (col < gp.maxScreenCol) {

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxScreenCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
        }
    }

    public void draw(Graphics2D g2) {

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {

            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if (col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }

    }
}
