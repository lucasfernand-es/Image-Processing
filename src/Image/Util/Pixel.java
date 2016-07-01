package Image.Util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucasfernandes
 */
public class Pixel {
    
    private long x;
    private long y;
    
    private Color color;

    
    public Pixel(int x, int y) {
        
        this.x = x;
        this.y = y;
    }
    
    public Pixel(int x, int y, Color color) {
        
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Pixel() {
    }
    
    /**
     * @return the x
     */
    public long getX() {
        return x;
    }
    
    public int getIntX() {
        return (int) x;
    }

    /**
     * @param x the x to set
     */
    public void setX(long x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public long getY() {
        return y;
    }
    
    public int getIntY() {
        return (int) y;
    }

    /**
     * @param y the y to set
     */
    public void setY(long y) {
        this.y = y;
    }
    
    
    
    public static List<Pixel> generateiLstPixel(int maxWidth, int maxHeight) {
        
        ArrayList<Pixel> listPixel = new ArrayList<>();
        
        for (int x = 0; x < maxWidth; x++) {
            
            for (int y = 0; y < maxHeight; y++) {
                listPixel.add( new Pixel(x, y) );
            }
            
        }
        return listPixel;
    }
    
    public static List<Pixel> generateRandomListPixel(int maxWidth, int maxHeight) {
        
        ArrayList<Pixel> listPixel = (ArrayList<Pixel>) generateiLstPixel(maxWidth, maxHeight);
        
        Collections.shuffle(listPixel);
        
        return listPixel;
    }
    
    
    public static List<Pixel> generateRandomListPixel(int maxWidth, int maxHeight, int countItems) {
        
        ArrayList<Pixel> listPixel = (ArrayList<Pixel>) generateRandomListPixel(maxWidth, maxHeight);
        
        return listPixel.subList(0, countItems);
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
    @Override
    public String toString()
    {
        return this.color.getRed() + " - " + this.color.getBlue()+ " - " + this.color.getBlue();
    }
    
}
