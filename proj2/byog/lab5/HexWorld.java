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
    public static void addHexagon(int s) {

        int spaceNumber = s - 1;
        int chNumber = s;
        while (spaceNumber >= 0) {
            if (spaceNumber > 0) {
                System.out.print(new String(new char[spaceNumber]).replace('\0', ' '));
            }
            System.out.print(new String(new char[chNumber]).replace('\0', '*'));
            System.out.println();
            spaceNumber -= 1;
            chNumber += 2;
        }
        spaceNumber += 1;
        chNumber -= 2;
        while (spaceNumber <= s - 1) {
            if (spaceNumber > 0) {
                System.out.print(new String(new char[spaceNumber]).replace('\0', ' '));
            }
            System.out.print(new String(new char[chNumber]).replace('\0', '*'));
            System.out.println();
            spaceNumber += 1;
            chNumber -= 2;
        }
    }

    public static void main(String[] args) {
        addHexagon(4);
    }
}
