/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Image.Controller;

import Image.Util.Pixel;

/**
 *
 * @author lucasfernandes
 */
public class ElementoEstruturante {
    
    private int width;
    private int height;
    
    private int ee[][];
    private Pixel associateNeighbours[][];
    
    public ElementoEstruturante(int width, int height, int elements[]){
        this.width = width;
        this.height = height;
        
        ee = new int[this.height][this.width];
        associateNeighbours = new Pixel[this.height][this.width];
        
        int count = 0;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ee[i][j] = elements[count++];
                associateNeighbours[i][j] = new Pixel();
            }
        }
        
    }

    public void setAssociateNeighbours(int i, int j, Pixel pixel)
    {
        this.associateNeighbours[i][j] = pixel;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the ee
     */
    public int[][] getEe() {
        return ee;
    }

    /**
     * @param ee the ee to set
     */
    public void setEe(int[][] ee) {
        this.ee = ee;
    }

    /**
     * @return the associateNeighbours
     */
    public Pixel[][] getAssociateNeighbours() {
        return associateNeighbours;
    }

    /**
     * @param associateNeighbours the associateNeighbours to set
     */
    public void setAssociateNeighbours(Pixel[][] associateNeighbours) {
        this.associateNeighbours = associateNeighbours;
    }
    
    
}
