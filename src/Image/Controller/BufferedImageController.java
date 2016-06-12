/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Image.Controller;

import static Image.Controller.TypeEffect.*;
import Image.Util.Pixel;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author lucasfernandes
 */
public class BufferedImageController {
    
    
    
    private static final int PGMTYPE = 10;
    private static final int RGBTYPE = 5;
    
    public static int getPGMTYPE()
    {
        return PGMTYPE;
    }
    
    public static int getRGBTYPE()
    {
        return RGBTYPE;
    }
    
    public static BufferedImage load(String message, String[] acceptedTypes)
    {
        BufferedImage newImage = null;
        
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(message, acceptedTypes);
        chooser.setCurrentDirectory(new File("lucasfernandes//Dropbox"));
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Abrir Imagem");
        
        
        int option = chooser.showOpenDialog(null);
        
        //int op = chooser.showOpenDialog(this);
        
        if(option == JFileChooser.APPROVE_OPTION){  
            File arq = chooser.getSelectedFile();  
            String path = arq.toString();  
            try { 
                  //carrega nova imagem
                  newImage = ImageIO.read(new File(path));
                  System.out.println("Arquivo aberto com sucesso!");
	    }
	    catch(IOException ex){
		System.out.println("Erro IO Exception! Verifique se o arquivo especificado existe e tente novamente.");
	    }
	    catch(Exception e){
		System.out.println("Erro Exception! " + e.getMessage());
	    }               
        } 
        
        
        return newImage;
        
    }
    
    
    public static BufferedImage clone(BufferedImage bufferedImage) 
    {
        
        ColorModel colorModel = bufferedImage.getColorModel();
        boolean isAlphaPremultiplied = colorModel.isAlphaPremultiplied();
        WritableRaster raster = bufferedImage.copyData(null);
        
        return new BufferedImage(colorModel, raster, isAlphaPremultiplied, null);
    }

    public static void setSaltAndPepperNoise(BufferedImage bufferedImage, double percentage) 
    {
        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();
        
        int countPixel =  (int) ( (height * width) * percentage );
        
        List<Pixel> noisyPixels = 
                Pixel.generateRandomListPixel(width, height, countPixel);
        
        List<Pixel> firstHalf =     noisyPixels.subList(0, noisyPixels.size()/2 );
        List<Pixel> secondHalf =    noisyPixels.subList(noisyPixels.size()/2 + 1, noisyPixels.size());
        
        setPixel(bufferedImage, firstHalf  ,  getColor(255)); // white
        setPixel(bufferedImage, secondHalf  ,  getColor(0)); // black
    }
    
    private static int getColor(int color)
    {
        return new Color(color, color, color).getRGB();
    }
    
    private static void setPixel(BufferedImage image, List<Pixel> listPixels, int color)
    {
        for(Pixel pixel : listPixels)
        {
            image.setRGB(pixel.getX(), pixel.getY(), color);

        }
    }

    
    private static void applyImageEffect(BufferedImage bufferedImage, ImageEffectPixel imageEffect)
    {
        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();
        
        
        Color currentColor;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                
                currentColor = new Color(bufferedImage.getRGB(x, y));
                
                bufferedImage.setRGB(x, y, imageEffect.effect(currentColor));
	    }
        }
        
        
    }
    
    private static void applyImageEffect(BufferedImage bufferedImage, ImageEffectLocal imageEffect, int maskSize)
    {
        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();
        
        if(maskSize % 2 == 0) maskSize += 1;
        
        
        int radius = maskSize / 2; 
        
        List<Color> colors = new ArrayList<>();
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                
                colors.clear();
                
                for (int radiusX = x - radius; radiusX <= x + radius; radiusX++) {
                    if(radiusX < 0 || radiusX >= width) continue;
                    for (int radiusY = y - radius; radiusY <= y + radius; radiusY++) {
                        if(radiusY < 0 || radiusY >= height) continue;
                        
                        colors.add( new Color(bufferedImage.getRGB(radiusX, radiusY)) );
                    }
                }
                
                bufferedImage.setRGB(x, y, imageEffect.effect(colors));
	    }
        }
    }
    
    public static void gammaEffect(BufferedImage bufferedImage)
    {
        applyImageEffect(bufferedImage, TypeEffectFunction.getEffectPixel(Gamma));
    }
    

    public static void grayScaleEffect(BufferedImage bufferedImage) {
        applyImageEffect(bufferedImage, TypeEffectFunction.getEffectPixel(GrayScale));
    }

    public static void negativeEffect(BufferedImage bufferedImage) {
        applyImageEffect(bufferedImage, TypeEffectFunction.getEffectPixel(Negative));
    }
    
    
    public static void medianFilterEffect(BufferedImage bufferedImage) {
       
        applyImageEffect(bufferedImage, TypeEffectFunction.getEffectLocal(Median), 3);
  
    }
    
    
    
}
