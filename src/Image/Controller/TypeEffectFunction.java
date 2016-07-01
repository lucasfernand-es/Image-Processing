/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Image.Controller;

import static Image.Controller.TypeEffect.*;
import Image.Util.Pixel;
import java.awt.Color;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author lucasfernandes
 */
public class TypeEffectFunction {
    
    public static ImageEffectPixel getEffectPixel(TypeEffect typeEffect)
    {
        ImageEffectPixel effect;
        switch(typeEffect){
            case GrayScale:
                effect = pixel ->
                    {
                        int R = pixel.getColor().getRed();
                        int G = pixel.getColor().getGreen();
                        int B = pixel.getColor().getBlue();
                        
                        int newColor = (int)(0.299 * R + 0.587 * G + 0.114 * B); 
                        pixel.setColor( new Color(newColor, newColor, newColor) );
                    };
                break;
            case Gamma:
                effect = pixel -> { 
            
                    int R = (int) (Math.pow(pixel.getColor().getRed()/255.0, 0.4) * 255);
                    int G = (int) (Math.pow(pixel.getColor().getGreen()/255.0, 0.4) * 255);
                    int B = (int) (Math.pow(pixel.getColor().getBlue()/255.0, 0.4) * 255);

                    pixel.setColor( new Color(R, G, B) );

                };
                break;
            case Negative:
                effect = pixel -> { 
            
                    
                    int R = 255 - pixel.getColor().getRed();
                    int G = 255 - pixel.getColor().getGreen();
                    int B = 255 - pixel.getColor().getBlue();
                    
                    pixel.setColor( new Color(R, G, B) );

                };
                break;
            default:
                effect = pixel ->
                    {
                        
                    };
                break;
        }
        
        return effect;
    }
    
    public static ImageEffectLocal getEffectLocal(TypeEffect typeEffect)
    {
        ImageEffectLocal effect;
        switch(typeEffect){
            case Median:
                effect = colors ->
                    {
                        Collections.sort(colors, ColorComparator);
                        return colors.get( colors.size()/2 ).getRGB();
                    };
                break;
            default:
                effect = colors ->
                    {
                        return 0;
                    };
                break;
        }
        
        return effect;
    }
    
    public static ImageEffectPixelComplex getEffectPixelComplex(TypeEffect typeEffect)
    {
        ImageEffectPixelComplex effect;
        switch(typeEffect){
            case Swirl:
                effect = (pixel, angle, x0, y0) -> { 
                    
                    
                    
                    double dx = pixel.getX() - x0;
                    double dy = pixel.getY() - y0;
                    
                    double r = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
                    
                    angle = Math.PI / angle * r;
                
                    //double angle = Math.PI / 256 * r;
                    double dtx = (dx * Math.cos(angle) + dy * Math.sin(angle) + x0);
                    double dty = (-dx * Math.sin(angle) + dy * Math.cos(angle) + y0);
                    
                    long tx = Math.round( dtx );
                    long ty = Math.round( dty );
                    //System.out.println("dtx = " + dtx + " tx = " + tx);
                    //System.out.println("Original = (" + pixel.getX() + ", " + pixel.getY() + ")");
                    //System.out.println("New = (" + tx + ", " + ty + ")");
                    
                    pixel.setX(tx);
                    pixel.setY(ty);
                    

                };
                break;
            default:
                effect = (pixel, angle, x0, y0) ->
                    {
                    };
                break;
        }
        
        return effect;
    }
    
    public static ImageEffectPixelEE getEffectPixelEE(TypeEffect typeEffect)
    {
        ImageEffectPixelEE effect = null;
        
        switch(typeEffect){
            case Erode:
                effect = (pixel, ee) ->
                    {
                        //System.out.println("-----");
                        //System.out.println(pixel);
                        //ArrayList min = new ArrayList();
                        int min = 255; // Valor Máximo de cor
                        
                        for (int i = 0; i < ee.getHeight(); i++) {
                            for (int j = 0; j < ee.getWidth(); j++) {
                                //System.out.print(ee.getAssociateNeighbours()[i][j].getIntX() + "|" + ee.getAssociateNeighbours()[i][j].getIntY() + " ");
                                //System.out.println(ee.getAssociateNeighbours()[i][j]);
                                int tempMin = Math.abs( pixel.getColor().getRed() - ee.getAssociateNeighbours()[i][j].getColor().getRed() ) ;
                                
                                if(tempMin < 0)
                                {
                                    System.out.println("muitos?" + tempMin);
                                    tempMin = 0;
                                }
                                
                                if(tempMin < min)
                                    min = tempMin;
                                
                            }
                            //System.out.println("");
                        }

                        pixel.setColor( new Color(min, min, min) );
                        
                        //System.out.println(pixel.getIntX() + " - " + pixel.getIntY());
                    };
                break;
            default:
                break;
        }
        
        return effect;
    }
    
            
    /*Comparator for sorting the list by roll no*/
    public static Comparator<Color> ColorComparator = (Color c1, Color c2) -> 
    {

        Pixel p1 = new Pixel(0, 0, c1); getEffectPixel(Negative).effect(p1);
        Pixel p2 = new Pixel(0, 0, c2); getEffectPixel(Negative).effect(p2);
        
        /*For ascending order*/
        return p1.getColor().getRed() - p2.getColor().getRed();
        
        /*For descending order*/
        //rollno2-rollno1;
    };
    
}
