package mountainpaths;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MapDataDrawer
{
    private int[][] grid;
    private int minValue;
    private int maxValue;
    
    private static final String fileName = "Colorado_844x480.dat";
    
    public MapDataDrawer(String fileName, int rows, int cols){
        // Create the two-dimensional grid array.
        // The first dimension is the number of rows, and the second 
        // dimension is the number of columns.
        grid = new int[rows][cols];
        
        // Read in the elevation values from the file specified.
        // All the values are in one line of the file.
        // You can use the Scanner's nextInt method to read them in.
        // The first 840 go in the first row of the array, the next 840 go in
        // the next row of the array, and so on.
        
        //Try to catch file not found exceptions
        //Use the scanner to create the new file
        try(Scanner fileInput = new Scanner(new File(fileName))){
            
            int number;
            
            //Get every number by row and column in the grid(go through the grid)
            for(int x=0; x < rows; x++){
                for(int y = 0; y < cols;y++){
                    //Go to the next integer in the grid
                    number = fileInput.nextInt();
                    //System.out.println(number);
                    //Set the number to the grid coordinates 
                    grid[x][y] = number;
                }
            }
        }
        //If the specified file name cannot be found, catch it here
        catch(FileNotFoundException exception){
            System.out.println("Error " + fileName + " was not found.");
            //Print out error details to the user
            System.out.println("Error Details: " + exception.getMessage());
            
        }
        
        // Set the minValue and maxValue to the minimum elevation value in the grid
        // and the maximum elevation value in the grid, respectively.
        minValue = 0;
        maxValue = 0;
    }
  
    /**
     * @return the min value in the entire grid
     */
    public int findMinValue(){
        //Use .length for the first dimension of the array, go through the grid
        for(int x =0; x<grid.length;x++){
            //Use [].length for the second dimension of the array
            for(int y =0; y<grid[0].length;y++){
                //Set the coordinates to the minimum value if they are less than the current min value
                if(grid[x][y] < minValue){
                    minValue = grid[x][y];
                }
            }
        }
        //Return the minimum elevation value
        return minValue;    
    }
    
    /**
     * @return the max value in the entire grid
     */
    public int findMaxValue(){
        //Use .length for the first dimension of the array
        for(int x =0; x<grid.length;x++){
            //Use [].length for the second dimension of the array
            for(int y =0; y<grid[0].length;y++){
                //Set the coordinates to the maximum value if they are greater than the current max value
                if(grid[x][y] > maxValue){
                    maxValue = grid[x][y];
                }
            }
        }
        //Return the maximum elevation value
        return maxValue;
    }
  
    /**
     * Draws the grid using the given Graphics object.
     * Colors should be grayscale values 0-255, scaled based on min/max values in grid
     */
    public void drawMap(Graphics g){
        int range = maxValue - minValue + 1;
        int greyScaleColor = 0;
        int rowCounter = 0;
        int columnCounter = 0;
        
        try
        {
            for(rowCounter = 0; rowCounter < grid.length; rowCounter++)
            {
                for(columnCounter = 0; columnCounter < grid[0].length; columnCounter++)
                {
                    greyScaleColor = (int) ((((double) grid[rowCounter][columnCounter] - minValue) / range) * 255);
                    g.setColor(new Color(greyScaleColor, greyScaleColor, greyScaleColor));
                    g.fillRect(columnCounter, rowCounter, 1, 1);
                }
            }
        }
        catch(IllegalArgumentException exception)
        {
            System.out.println(exception.getMessage());
            System.out.println("Row: " + rowCounter + ", Column: " + columnCounter + ", greyScaleColor: " + greyScaleColor);
            System.out.println("Raw Value: " + grid[rowCounter][columnCounter] + ", Column: " + columnCounter + ", Value: " + greyScaleColor);
        }
    }

    /**
    * Find a path from West-to-East starting at given row.
    * Choose a foward step out of 3 possible forward locations, using greedy method described in assignment.
    * @return the total change in elevation traveled from West-to-East
    */
    public int drawLowestElevPath(Graphics g, int row){
        return 0;
    }
  
    /**
     * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
     */
    public int indexOfLowestElevPath(Graphics g){
        return 0;
    }
}
