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
public interface ImageEffectPixelComplex {
    
    // angle in radians
    public void effect(Pixel pixel, double angle, double x0, double y0);
    
}
