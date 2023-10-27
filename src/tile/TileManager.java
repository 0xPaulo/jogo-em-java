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

        tile = new Tile[359];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        // loadMap("src/res/maps/hub.txt");
        loadMap("src/res/maps/hub100.txt");
    }

    public void getTileImage() {

        setup("black", "000", 0, true);
        setup("sand", "001", 1, false);
        setup("banco1", "002", 2, true);
        setup("banco2", "003", 3, true);
        setup("placa", "004", 4, true);
        setup("grama", "005", 5, false);
        setup("grama2", "006", 6, false);
        setup("grama3", "007", 7, false);
        setup("grama5", "008", 8, false);
        setup("grama6", "009", 9, false);
        setup("grama7", "010", 10, false);
        setup("grama8", "011", 11, false);
        setup("road09", "012", 12, true);
        setup("road10", "013", 13, true);
        setup("road11", "014", 14, true);
        setup("road12", "015", 15, true);
        setup("tree01", "016", 16, true);
        setup("earth01", "017", 17, true);
        setup("water00", "018", 18, true);
        setup("water01", "019", 19, true);
        setup("water02", "020", 20, true);
        setup("water03", "021", 21, true);
        setup("water04", "022", 22, true);
        setup("water05", "023", 23, true);
        setup("water06", "024", 24, true);
        setup("water07", "025", 25, false);
        setup("water08", "026", 26, false);
        setup("water09", "027", 27, false);
        setup("water10", "028", 28, false);
        setup("water11", "029", 29, false);
        setup("water12", "030", 30, false);
        setup("water13", "031", 31, false);
        setup("wall", "032", 32, true);
        setup("hut01", "033", 33, false);
        setup("floor01", "034", 34, true);
        setup("table", "035", 35, true);
        setup("AGUA", "036", 36, true);
        setup("ladder02", "037", 37, true);
        setup("ship01", "038", 38, true);
        setup("ship02", "039", 39, true);
        setup("ship03", "040", 40, true);
        setup("ship04", "041", 41, true);
        setup("ship05", "042", 42, true);
        setup("ship06", "043", 43, true);
        setup("ship06", "044", 44, true);
        setup("ship06", "045", 45, true);
        setup("ship06", "043", 43, true);
        setup("ship06", "044", 44, false);
        setup("ship06", "045", 45, true);
        setup("ship06", "046", 46, false);
        setup("ship06", "047", 47, false);
        setup("ship06", "048", 48, false);
        setup("ship06", "049", 49, false);
        setup("ship06", "050", 50, true);
        setup("ship06", "051", 51, true);
        setup("ship06", "052", 52, true);
        setup("ship06", "053", 53, true);
        setup("ship06", "054", 54, true);
        setup("ship06", "055", 55, true);
        setup("ship06", "056", 56, true);
        setup("ship06", "057", 57, true);
        setup("ship06", "058", 58, true);
        setup("ship06", "059", 59, true);
        setup("ship06", "060", 60, true);
        setup("ship06", "061", 61, true);
        setup("ship06", "062", 62, true);
        setup("ship06", "063", 63, true);
        setup("ship06", "064", 64, false);
        setup("ship06", "065", 65, true);
        setup("ship06", "066", 66, false);
        setup("ship06", "067", 67, false);
        setup("ship06", "068", 68, false);
        setup("ship06", "069", 69, false);
        setup("ship06", "070", 70, true);
        setup("ship06", "071", 71, true);
        setup("ship06", "072", 72, true);
        setup("ship06", "073", 73, true);
        setup("ship06", "074", 74, true);
        setup("ship06", "075", 75, true);
        setup("ship06", "076", 76, true);
        setup("ship06", "077", 77, true);
        setup("ship06", "078", 78, true);
        setup("ship06", "079", 79, true);
        setup("ship06", "080", 80, false);
        setup("ship06", "081", 81, false);
        setup("ship06", "082", 82, false);
        setup("ship06", "083", 83, false);
        setup("ship06", "084", 84, false);
        setup("ship06", "085", 85, false);
        setup("ship06", "086", 86, true);
        setup("ship06", "087", 87, true);
        setup("ship06", "088", 88, true);
        setup("ship06", "089", 89, true);
        setup("ship06", "090", 90, true);
        setup("ship06", "091", 91, true);
        setup("ship06", "092", 92, false);
        setup("ship06", "093", 93, false);
        setup("ship06", "094", 94, true);
        setup("ship06", "095", 95, false);
        setup("ship06", "096", 96, true);
        setup("ship06", "097", 97, true);
        setup("ship06", "098", 98, true);
        setup("ship06", "099", 99, true);
        setup("ship06", "100", 100, true);
        setup("ship06", "101", 101, true);
        setup("ship06", "102", 102, true);
        setup("ship06", "103", 103, true);
        setup("ship06", "104", 104, true);
        setup("ship06", "105", 105, true);
        setup("ship06", "106", 106, true);
        setup("ship06", "107", 107, true);
        setup("ship06", "108", 108, true);
        setup("ship06", "109", 109, true);
        setup("ship06", "110", 110, true);
        setup("TERRA", "111", 111, false);
        setup("ship06", "112", 112, false);
        setup("ship06", "113", 113, false);
        setup("ship06", "114", 114, true);
        setup("ship06", "115", 115, true);
        setup("ship06", "116", 116, true);
        setup("ship06", "117", 117, true);
        setup("ship06", "118", 118, true);
        setup("ship06", "119", 119, true);
        setup("ship06", "120", 120, true);
        setup("ship06", "121", 121, true);
        setup("ship06", "122", 122, true);
        setup("ship06", "123", 123, true);
        setup("ship06", "124", 124, true);
        setup("ship06", "125", 125, true);
        setup("ship06", "126", 126, true);
        setup("ship06", "127", 127, true);
        setup("ship06", "128", 128, true);
        setup("ship06", "129", 129, true);
        setup("ship06", "130", 130, true);
        setup("ship06", "131", 131, false);
        setup("ship06", "132", 132, false);
        setup("ship06", "133", 133, false);
        setup("ship06", "134", 134, true);
        setup("ship06", "135", 135, true);
        setup("ship06", "136", 136, true);
        setup("ship06", "137", 137, true);
        setup("ship06", "138", 138, true);
        setup("ship06", "139", 139, true);
        setup("ship06", "140", 140, true);
        setup("ship06", "141", 141, true);
        setup("ship06", "142", 142, true);
        setup("ship06", "143", 143, true);
        setup("ship06", "144", 144, true);
        setup("ship06", "145", 145, true);
        setup("ship06", "146", 146, true);
        setup("ship06", "147", 147, true);
        setup("ship06", "148", 148, true);
        setup("ship06", "149", 149, false);
        setup("ship06", "150", 150, false);
        setup("ship06", "151", 151, false);
        setup("ship06", "152", 152, false);
        setup("ship06", "153", 153, false);
        setup("ship06", "154", 154, true);
        setup("ship06", "155", 155, true);
        setup("ship06", "156", 156, true);
        setup("ship06", "157", 157, true);
        setup("ship06", "158", 158, false);
        setup("ship06", "159", 159, true);
        setup("ship06", "160", 160, true);
        setup("ship06", "161", 161, true);
        setup("ship06", "162", 162, true);
        setup("ship06", "163", 163, true);
        setup("ship06", "164", 164, true);
        setup("ship06", "165", 165, true);
        setup("ship06", "166", 166, true);
        setup("ship06", "167", 167, true);
        setup("ship06", "168", 168, true);
        setup("ship06", "169", 169, false);
        setup("ship06", "170", 170, false);
        setup("ship06", "171", 171, false);
        setup("ship06", "172", 172, false);
        setup("ship06", "173", 173, false);
        setup("ship06", "174", 174, true);
        setup("ship06", "175", 175, true);
        setup("ship06", "176", 176, true);
        setup("ship06", "177", 177, true);
        setup("ship06", "178", 178, true);
        setup("ship06", "179", 179, true);
        setup("ship06", "180", 180, true);
        setup("ship06", "181", 181, true);
        setup("ship06", "182", 182, true);
        setup("ship06", "183", 183, true);
        setup("ship06", "184", 184, true);
        setup("ship06", "185", 185, true);
        setup("ship06", "186", 186, true);
        setup("ship06", "187", 187, true);
        setup("ship06", "188", 188, true);
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
        setup("ship06", "200", 200, true);
        setup("ship06", "201", 201, true);
        setup("ship06", "202", 202, true);
        setup("ship06", "203", 203, true);
        setup("ship06", "204", 204, true);
        setup("ship06", "205", 205, true);
        setup("ship06", "206", 206, false);
        setup("ship06", "207", 207, false);
        setup("ship06", "208", 208, true);
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
        setup("ship06", "220", 220, true);
        setup("ship06", "221", 221, true);
        setup("ship06", "222", 222, true);
        setup("ship06", "223", 223, true);
        setup("ship06", "224", 224, false);
        setup("ship06", "225", 225, false);
        setup("ship06", "226", 226, false);
        setup("ship06", "227", 227, false);
        setup("ship06", "228", 228, true);
        setup("ship06", "229", 229, true);
        setup("ship06", "230", 230, true);
        setup("ship06", "231", 231, true);
        setup("ship06", "232", 232, true);
        setup("ship06", "233", 233, true);
        setup("ship06", "234", 234, true);
        setup("ship06", "235", 235, true);
        setup("ship06", "236", 236, true);
        setup("ship06", "237", 237, true);
        setup("ship06", "238", 238, true);
        setup("ship06", "239", 239, true);
        setup("ship06", "240", 240, true);
        setup("ship06", "241", 241, true);
        setup("ship06", "242", 242, true);
        setup("ship06", "243", 243, true);
        setup("ship06", "244", 244, true);
        setup("ship06", "245", 245, true);
        setup("ship06", "246", 246, true);
        setup("ship06", "247", 247, true);
        setup("ship06", "248", 248, true);
        setup("ship06", "249", 249, true);
        setup("ship06", "250", 250, true);
        setup("ship06", "251", 251, true);
        setup("ship06", "252", 252, true);
        setup("ship06", "253", 253, true);
        setup("ship06", "254", 254, true);
        setup("ship06", "255", 255, true);
        setup("ship06", "256", 256, false);
        setup("ship06", "257", 257, false);
        setup("ship06", "258", 258, false);
        setup("ship06", "259", 259, false);
        setup("ship06", "260", 260, true);
        setup("ship06", "261", 261, true);
        setup("ship06", "262", 262, true);
        setup("ship06", "263", 263, true);
        setup("ship06", "264", 264, true);
        setup("ship06", "265", 265, true);
        setup("ship06", "266", 266, true);
        setup("ship06", "267", 267, true);
        setup("ship06", "268", 268, true);
        setup("ship06", "269", 269, true);
        setup("ship06", "270", 270, true);
        setup("ship06", "271", 271, true);
        setup("ship06", "272", 272, true);
        setup("ship06", "273", 273, false);
        setup("ship06", "274", 274, false);
        setup("ship06", "275", 275, false);
        setup("ship06", "276", 276, false);
        setup("ship06", "277", 277, false);
        setup("ship06", "278", 278, false);
        setup("ship06", "279", 279, false);
        setup("ship06", "280", 280, true);
        setup("ship06", "281", 281, true);
        setup("ship06", "282", 282, true);
        setup("ship06", "283", 283, true);
        setup("ship06", "284", 284, true);
        setup("ship06", "285", 285, true);
        setup("ship06", "286", 286, true);
        setup("ship06", "287", 287, true);
        setup("ship06", "288", 288, true);
        setup("ship06", "289", 289, true);
        setup("ship06", "290", 290, true);
        setup("ship06", "291", 291, false);
        setup("ship06", "292", 292, true);
        setup("ship06", "293", 293, false);
        setup("ship06", "294", 294, false);
        setup("ship06", "295", 295, false);
        setup("ship06", "296", 296, false);
        setup("ship06", "297", 297, false);
        setup("ship06", "298", 298, false);
        setup("ship06", "299", 299, false);
        setup("ship06", "300", 300, true);
        setup("ship06", "301", 301, true);
        setup("ship06", "302", 302, true);
        setup("ship06", "303", 303, true);
        setup("ship06", "304", 304, true);
        setup("ship06", "305", 305, false);
        setup("ship06", "306", 306, false);
        setup("ship06", "307", 307, false);
        setup("ship06", "308", 308, true);
        setup("ship06", "309", 309, true);
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
        setup("ship06", "320", 320, true);
        setup("ship06", "321", 321, false);
        setup("ship06", "322", 322, true);
        setup("ship06", "323", 323, true);
        setup("ship06", "324", 324, true);
        setup("ship06", "325", 325, false);
        setup("ship06", "326", 326, true);
        setup("ship06", "327", 327, true);
        setup("ship06", "328", 328, true);
        setup("ship06", "329", 329, true);
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
        setup("ship06", "340", 340, true);
        setup("ship06", "341", 341, true);
        setup("ship06", "342", 342, true);
        setup("ship06", "343", 343, true);
        setup("ship06", "344", 344, true);
        setup("ship06", "345", 345, false);
        setup("ship06", "346", 346, true);
        setup("ship06", "347", 347, true);
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
