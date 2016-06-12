/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Image.Controller;

import static Image.Controller.TypeEffect.*;
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
                effect = color ->
                    {
                        int R = color.getRed();
                        int G = color.getGreen();
                        int B = color.getBlue();
                        
                        int newColor = (int)(0.299 * R + 0.587 * G + 0.114 * B); 
                        
                        return new Color(newColor, newColor, newColor).getRGB();
                    };
                break;
            case Gamma:
                effect = color -> { 
            
                    int R = (int) (Math.pow(color.getRed()/255.0, 0.4) * 255);
                    int G = (int) (Math.pow(color.getGreen()/255.0, 0.4) * 255);
                    int B = (int) (Math.pow(color.getBlue()/255.0, 0.4) * 255);

                    return new Color(R, G, B).getRGB(); 

                };
                break;
            case Negative:
                effect = color -> { 
            
                    
                    int R = 255 - color.getRed();
                    int G = 255 - color.getGreen();
                    int B = 255 - color.getBlue();
                    
                    return new Color(R, G, B).getRGB(); 

                };
                break;
            default:
                effect = color ->
                    {
                        return color.getRGB();
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
    
    /*Comparator for sorting the list by roll no*/
    public static Comparator<Color> ColorComparator = (Color c1, Color c2) -> {

        Color brightnessC1 = new Color(  getEffectPixel(Negative).effect(c1) );
        Color brightnessC2 = new Color(  getEffectPixel(Negative).effect(c2) );
        
        /*For ascending order*/
        return brightnessC1.getRed() - brightnessC2.getRed();
        
        /*For descending order*/
        //rollno2-rollno1;
    };
    
}
