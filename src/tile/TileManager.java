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

        tile = new Tile[400];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        // loadMap("src/res/maps/world01.txt");
        loadMap("src/res/maps/mapa_new_sprite1.txt");
    }

    public void getTileImage() {

        setup("0", "000", 0, false);
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
        setup("tree01", "016", 16, false);
        setup("earth01", "017", 17, false);
        setup("water00", "018", 18, false);
        setup("water01", "019", 19, false);
        setup("water02", "020", 20, false);
        setup("water03", "021", 21, false);
        setup("water04", "022", 22, false);
        setup("water05", "023", 23, false);
        setup("water06", "024", 24, false);
        setup("water07", "025", 25, false);
        setup("water08", "026", 26, false);
        setup("water09", "027", 27, false);
        setup("water10", "028", 28, false);
        setup("water11", "029", 29, false);
        setup("water12", "030", 30, false);
        setup("water13", "031", 31, false);
        setup("wall", "032", 32, false);
        setup("hut01", "033", 33, false);
        setup("floor01", "034", 34, false);
        setup("table", "035", 35, false);
        setup("ladder01", "036", 36, false);
        setup("ladder02", "037", 37, false);
        setup("ship01", "038", 38, false);
        setup("ship02", "039", 39, false);
        setup("ship03", "040", 40, false);
        setup("ship04", "041", 41, false);
        setup("ship05", "042", 42, false);
        setup("ship06", "043", 43, false);
        setup("ship06", "044", 44, false);
        setup("ship06", "045", 45, false);
        setup("ship06", "043", 43, false);
        setup("ship06", "044", 44, false);
        setup("ship06", "045", 45, false);
        setup("ship06", "046", 46, false);
        setup("ship06", "047", 47, false);
        setup("ship06", "048", 48, false);
        setup("ship06", "049", 49, false);
        setup("ship06", "050", 50, false);
        setup("ship06", "051", 51, false);
        setup("ship06", "052", 52, false);
        setup("ship06", "053", 53, false);
        setup("ship06", "054", 54, false);
        setup("ship06", "055", 55, false);
        setup("ship06", "056", 56, false);
        setup("ship06", "057", 57, false);
        setup("ship06", "058", 58, false);
        setup("ship06", "059", 59, false);
        setup("ship06", "060", 60, false);
        setup("ship06", "061", 61, false);
        setup("ship06", "062", 62, false);
        setup("ship06", "063", 63, false);
        setup("ship06", "064", 64, false);
        setup("ship06", "065", 65, false);
        setup("ship06", "066", 66, false);
        setup("ship06", "067", 67, false);
        setup("ship06", "068", 68, false);
        setup("ship06", "069", 69, false);
        setup("ship06", "070", 70, false);
        setup("ship06", "071", 71, false);
        setup("ship06", "072", 72, false);
        setup("ship06", "073", 73, false);
        setup("ship06", "074", 74, false);
        setup("ship06", "075", 75, false);
        setup("ship06", "076", 76, false);
        setup("ship06", "077", 77, false);
        setup("ship06", "078", 78, false);
        setup("ship06", "079", 79, false);
        setup("ship06", "080", 80, false);
        setup("ship06", "081", 81, false);
        setup("ship06", "082", 82, false);
        setup("ship06", "083", 83, false);
        setup("ship06", "084", 84, false);
        setup("ship06", "085", 85, false);
        setup("ship06", "086", 86, false);
        setup("ship06", "087", 87, false);
        setup("ship06", "088", 88, false);
        setup("ship06", "089", 89, false);
        setup("ship06", "090", 90, false);
        setup("ship06", "091", 91, false);
        setup("ship06", "092", 92, false);
        setup("ship06", "093", 93, false);
        setup("ship06", "094", 94, false);
        setup("ship06", "095", 95, false);
        setup("ship06", "096", 96, false);
        setup("ship06", "097", 97, false);
        setup("ship06", "098", 98, false);
        setup("ship06", "099", 99, false);
        setup("ship06", "100", 100, false);
        setup("ship06", "101", 101, false);
        setup("ship06", "102", 102, false);
        setup("ship06", "103", 103, false);
        setup("ship06", "104", 104, false);
        setup("ship06", "105", 105, false);
        setup("ship06", "106", 106, false);
        setup("ship06", "107", 107, false);
        setup("ship06", "108", 108, false);
        setup("ship06", "109", 109, false);
        setup("ship06", "110", 110, false);
        setup("ship06", "111", 111, false);
        setup("ship06", "112", 112, false);
        setup("ship06", "113", 113, false);
        setup("ship06", "114", 114, false);
        setup("ship06", "115", 115, false);
        setup("ship06", "116", 116, false);
        setup("ship06", "117", 117, false);
        setup("ship06", "118", 118, false);
        setup("ship06", "119", 119, false);
        setup("ship06", "120", 120, false);
        setup("ship06", "121", 121, false);
        setup("ship06", "122", 122, false);
        setup("ship06", "123", 123, false);
        setup("ship06", "124", 124, false);
        setup("ship06", "125", 125, false);
        setup("ship06", "126", 126, false);
        setup("ship06", "127", 127, false);
        setup("ship06", "128", 128, false);
        setup("ship06", "129", 129, false);
        setup("ship06", "130", 130, false);
        setup("ship06", "131", 131, false);
        setup("ship06", "132", 132, false);
        setup("ship06", "133", 133, false);
        setup("ship06", "134", 134, false);
        setup("ship06", "135", 135, false);
        setup("ship06", "136", 136, false);
        setup("ship06", "137", 137, false);
        setup("ship06", "138", 138, false);
        setup("ship06", "139", 139, false);
        setup("ship06", "140", 140, false);
        setup("ship06", "141", 141, false);
        setup("ship06", "142", 142, false);
        setup("ship06", "143", 143, false);
        setup("ship06", "144", 144, false);
        setup("ship06", "145", 145, false);
        setup("ship06", "146", 146, false);
        setup("ship06", "147", 147, false);
        setup("ship06", "148", 148, false);
        setup("ship06", "149", 149, false);
        setup("ship06", "150", 150, false);
        setup("ship06", "151", 151, false);
        setup("ship06", "152", 152, false);
        setup("ship06", "153", 153, false);
        setup("ship06", "154", 154, false);
        setup("ship06", "155", 155, false);
        setup("ship06", "156", 156, false);
        setup("ship06", "157", 157, false);
        setup("ship06", "158", 158, false);
        setup("ship06", "159", 159, false);
        setup("ship06", "160", 160, false);
        setup("ship06", "161", 161, false);
        setup("ship06", "162", 162, false);
        setup("ship06", "163", 163, false);
        setup("ship06", "164", 164, false);
        setup("ship06", "165", 165, false);
        setup("ship06", "166", 166, false);
        setup("ship06", "167", 167, false);
        setup("ship06", "168", 168, false);
        setup("ship06", "169", 169, false);
        setup("ship06", "170", 170, false);
        setup("ship06", "171", 171, false);
        setup("ship06", "172", 172, false);
        setup("ship06", "173", 173, false);
        setup("ship06", "174", 174, false);
        setup("ship06", "175", 175, false);
        setup("ship06", "176", 176, false);
        setup("ship06", "177", 177, false);
        setup("ship06", "178", 178, false);
        setup("ship06", "179", 179, false);
        setup("ship06", "180", 180, false);
        setup("ship06", "181", 181, false);
        setup("ship06", "182", 182, false);
        setup("ship06", "183", 183, false);
        setup("ship06", "184", 184, false);
        setup("ship06", "185", 185, false);
        setup("ship06", "186", 186, false);
        setup("ship06", "187", 187, false);
        setup("ship06", "188", 188, false);
        setup("ship06", "189", 189, false);
        setup("ship06", "190", 190, false);
        setup("ship06", "191", 191, false);
        setup("ship06", "192", 192, false);
        setup("ship06", "193", 193, false);
        setup("ship06", "194", 194, false);
        setup("ship06", "195", 195, false);
        setup("ship06", "196", 196, false);
        setup("ship06", "197", 197, false);
        setup("ship06", "198", 198, false);
        setup("ship06", "199", 199, false);
        setup("ship06", "200", 200, false);
        setup("ship06", "201", 201, false);
        setup("ship06", "202", 202, false);
        setup("ship06", "203", 203, false);
        setup("ship06", "204", 204, false);
        setup("ship06", "205", 205, false);
        setup("ship06", "206", 206, false);
        setup("ship06", "207", 207, false);
        setup("ship06", "208", 208, false);
        setup("ship06", "209", 209, false);
        setup("ship06", "210", 210, false);
        setup("ship06", "211", 211, false);
        setup("ship06", "212", 212, false);
        setup("ship06", "213", 213, false);
        setup("ship06", "214", 214, false);
        setup("ship06", "215", 215, false);
        setup("ship06", "216", 216, false);
        setup("ship06", "217", 217, false);
        setup("ship06", "218", 218, false);
        setup("ship06", "219", 219, false);
        setup("ship06", "220", 220, false);
        setup("ship06", "221", 221, false);
        setup("ship06", "222", 222, false);
        setup("ship06", "223", 223, false);
        setup("ship06", "224", 224, false);
        setup("ship06", "225", 225, false);
        setup("ship06", "226", 226, false);
        setup("ship06", "227", 227, false);
        setup("ship06", "228", 228, false);
        setup("ship06", "229", 229, false);
        setup("ship06", "230", 230, false);
        setup("ship06", "231", 231, false);
        setup("ship06", "232", 232, false);
        setup("ship06", "233", 233, false);
        setup("ship06", "234", 234, false);
        setup("ship06", "235", 235, false);
        setup("ship06", "236", 236, false);
        setup("ship06", "237", 237, false);
        setup("ship06", "238", 238, false);
        setup("ship06", "239", 239, false);
        setup("ship06", "240", 240, false);
        setup("ship06", "241", 241, false);
        setup("ship06", "242", 242, false);
        setup("ship06", "243", 243, false);
        setup("ship06", "244", 244, false);
        setup("ship06", "245", 245, false);
        setup("ship06", "246", 246, false);
        setup("ship06", "247", 247, false);
        setup("ship06", "248", 248, false);
        setup("ship06", "249", 249, false);
        setup("ship06", "250", 250, false);
        setup("ship06", "251", 251, false);
        setup("ship06", "252", 252, false);
        setup("ship06", "253", 253, false);
        setup("ship06", "254", 254, false);
        setup("ship06", "255", 255, false);
        setup("ship06", "256", 256, false);
        setup("ship06", "257", 257, false);
        setup("ship06", "258", 258, false);
        setup("ship06", "259", 259, false);
        setup("ship06", "260", 260, false);
        setup("ship06", "261", 261, false);
        setup("ship06", "262", 262, false);
        setup("ship06", "263", 263, false);
        setup("ship06", "264", 264, false);
        setup("ship06", "265", 265, false);
        setup("ship06", "266", 266, false);
        setup("ship06", "267", 267, false);
        setup("ship06", "268", 268, false);
        setup("ship06", "269", 269, false);
        setup("ship06", "270", 270, false);
        setup("ship06", "271", 271, false);
        setup("ship06", "272", 272, false);
        setup("ship06", "273", 273, false);
        setup("ship06", "274", 274, false);
        setup("ship06", "275", 275, false);
        setup("ship06", "276", 276, false);
        setup("ship06", "277", 277, false);
        setup("ship06", "278", 278, false);
        setup("ship06", "279", 279, false);
        setup("ship06", "280", 280, false);
        setup("ship06", "281", 281, false);
        setup("ship06", "282", 282, false);
        setup("ship06", "283", 283, false);
        setup("ship06", "284", 284, false);
        setup("ship06", "285", 285, false);
        setup("ship06", "286", 286, false);
        setup("ship06", "287", 287, false);
        setup("ship06", "288", 288, false);
        setup("ship06", "289", 289, false);
        setup("ship06", "290", 290, false);
        setup("ship06", "291", 291, false);
        setup("ship06", "292", 292, false);
        setup("ship06", "293", 293, false);
        setup("ship06", "294", 294, false);
        setup("ship06", "295", 295, false);
        setup("ship06", "296", 296, false);
        setup("ship06", "297", 297, false);
        setup("ship06", "298", 298, false);
        setup("ship06", "299", 299, false);
        setup("ship06", "300", 300, false);
        setup("ship06", "301", 301, false);
        setup("ship06", "302", 302, false);
        setup("ship06", "303", 303, false);
        setup("ship06", "304", 304, false);
        setup("ship06", "305", 305, false);
        setup("ship06", "306", 306, false);
        setup("ship06", "307", 307, false);
        setup("ship06", "308", 308, false);
        setup("ship06", "309", 309, false);
        setup("ship06", "310", 310, false);
        setup("ship06", "311", 311, false);
        setup("ship06", "312", 312, false);
        setup("ship06", "313", 313, false);
        setup("ship06", "314", 314, false);
        setup("ship06", "315", 315, false);
        setup("ship06", "316", 316, false);
        setup("ship06", "317", 317, false);
        setup("ship06", "318", 318, false);
        setup("ship06", "319", 319, false);
        setup("ship06", "320", 320, false);
        setup("ship06", "321", 321, false);
        setup("ship06", "322", 322, false);
        setup("ship06", "323", 323, false);
        setup("ship06", "324", 324, false);
        setup("ship06", "325", 325, false);
        setup("ship06", "326", 326, false);
        setup("ship06", "327", 327, false);
        setup("ship06", "328", 328, false);
        setup("ship06", "329", 329, false);
        setup("ship06", "330", 330, false);
        setup("ship06", "331", 331, false);
        setup("ship06", "332", 332, false);
        setup("ship06", "333", 333, false);
        setup("ship06", "334", 334, false);
        setup("ship06", "335", 335, false);
        setup("ship06", "336", 336, false);
        setup("ship06", "337", 337, false);
        setup("ship06", "338", 338, false);
        setup("ship06", "339", 339, false);
        setup("ship06", "340", 340, false);
        setup("ship06", "341", 341, false);
        setup("ship06", "342", 342, false);
        setup("ship06", "343", 343, false);
        setup("ship06", "344", 344, false);
        setup("ship06", "345", 345, false);
        setup("ship06", "346", 346, false);
        setup("ship06", "347", 347, false);
        setup("ship06", "348", 348, false);
        setup("ship06", "349", 349, false);
        setup("ship06", "350", 350, false);
        setup("ship06", "351", 351, false);
        setup("ship06", "352", 352, false);
        setup("ship06", "353", 353, false);
        setup("ship06", "354", 354, false);
        setup("ship06", "355", 355, false);
        setup("ship06", "356", 356, false);
        setup("ship06", "357", 357, false);
        setup("ship06", "358", 358, false);
        setup("ship06", "359", 359, false);

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
            System.out.println(index);

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
