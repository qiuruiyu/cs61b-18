package byog.lab5;

import org.junit.Test;

import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    /**
     * help method to draw a Hexagon with certain character
     *
     * @param s the length of edge of the Hexagon
     */
//    public static void addHexagon(int s) {
//
//        int spaceNumber = s - 1;
//        int chNumber = s;
//        while (spaceNumber >= 0) {
//            if (spaceNumber > 0) {
//                System.out.print(new String(new char[spaceNumber]).replace('\0', ' '));
//            }
//            System.out.print(new String(new char[chNumber]).replace('\0', '*'));
//            System.out.println();
//            spaceNumber -= 1;
//            chNumber += 2;
//        }
//        spaceNumber += 1;
//        chNumber -= 2;
//        while (spaceNumber <= s - 1) {
//            if (spaceNumber > 0) {
//                System.out.print(new String(new char[spaceNumber]).replace('\0', ' '));
//            }
//            System.out.print(new String(new char[chNumber]).replace('\0', '*'));
//            System.out.println();
//            spaceNumber += 1;
//            chNumber -= 2;
//        }
//    }

    /**
     * Computes the width of row i for a size s heagon
     * @param s The size of the hex
     * @param i The row number where i = 0 is the highest one
     * @return
     */
    public static int hexRowWidth(int s, int i) {
        int effectiveI = i;
        if (effectiveI >= s) {
            effectiveI = 2 * s - 1 - effectiveI;
        }
        return s + 2 * effectiveI;
    }

    /**
     * Compute the space number of each row
     * @param s The size of the hex
     * @param i The row number where i = 0 is the highest one
     * @return
     */
    public static int hexRowOffset(int s, int i) {
        int effectiveI = i;
        if (i >= s) {
            effectiveI = 2 * s - 1 - effectiveI;
        }
        return s - 1 - effectiveI;
    }

    /**
     * Add a row of a hex to the world
     * @param world the world to draw
     * @param x     the x position
     * @param y     the y position
     * @param width the number of tiles wide to draw
     * @param t     the tile to draw
     */
    public static void addRow(TETile[][] world, int x, int y, int width, TETile t) {
        Random RANDOM = new Random();
        for(int xi = 0; xi < width; xi += 1) {
            int xCoord = x + xi;
            int yCoord = y;
//            world[xCoord][yCoord] = Tileset.GRASS;
            world[xCoord][yCoord] = TETile.colorVariant(t, 32, 32, 32, RANDOM);
        }
    }

    public static void addHexagon(TETile[][] world, int x, int y, int s, TETile t) {
        if (s < 2) {
            throw new IllegalArgumentException("Hexagon must be at least size 2.");
        }
        for (int yi = 0; yi < 2 * s; yi += 1) {
            int rowY = y + yi;
            int xStart = x + hexRowOffset(s, yi);
            int rowWidth = hexRowWidth(s, yi);
            addRow(world, xStart, rowY, rowWidth, t);
        }
    }



    public static void main(String[] args) {
        TETile t = Tileset.GRASS;
        TERenderer ter = new TERenderer();
        ter.initialize(40, 40);
        TETile[][] world = new TETile[40][40];
        for (int i = 0; i < 40; i += 1) {
            for (int j = 0; j < 40; j += 1) {
                world[i][j] = Tileset.NOTHING;
            }
        }
        addHexagon(world, 0, 0, 3, t);
        ter.renderFrame(world);
    }
}
