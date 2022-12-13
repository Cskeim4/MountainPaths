package mountainpaths;

import java.awt.Color;
import java.awt.Graphics;

public class MountainPaths
{
    public static void main(String[] args)
    {
        // Construct DrawingPanel, and get its Graphics context
        DrawingPanel panel = new DrawingPanel(840, 480);
        Graphics g = panel.getGraphics();
        
        // Test Step 1 - construct mountain map data
        MapDataDrawer map = new MapDataDrawer("Colorado_844x480.dat", 480, 840);
        
        // Test Step 2 - min, max, minRow in col
        int min = map.findMinValue();
        System.out.println("Min value in map: " + min);
        
        int max = map.findMaxValue();
        System.out.println("Max value in map: " + max);
        
        // Test Step 3 - draw the map
        map.drawMap(g);
        
        // The steps below are extra credit.
        
        //Test Step 4 - draw a greedy path
        //int totalChange = map.drawLowestElevPath(g, 0);
        //System.out.println("Lowest-Elevation-Change Path starting at row 0 gives total change of: " + totalChange);
        
        //Test Step 5 - draw all the paths and find the index of the best one.
        //int bestRow = map.indexOfLowestElevPath(g);
        //map.drawMap(g); //use this to get rid of all the lines
        //totalChange = map.drawLowestElevPath(g, bestRow);
        //System.out.println("The Lowest-Elevation-Change Path starts at row: " + bestRow + " and gives a total change of: " + totalChange);
        
    }
}
