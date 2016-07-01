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

    public static BufferedImage setSaltAndPepperNoise(BufferedImage bufferedImage, double percentage) 
    {
        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();
        
        BufferedImage newImage = BufferedImageController.clone(bufferedImage);
        
        int countPixel =  (int) ( (height * width) * percentage );
        
        List<Pixel> noisyPixels = 
                Pixel.generateRandomListPixel(width, height, countPixel);
        
        List<Pixel> firstHalf =     noisyPixels.subList(0, noisyPixels.size()/2 );
        List<Pixel> secondHalf =    noisyPixels.subList(noisyPixels.size()/2 + 1, noisyPixels.size());
        
        setPixel(newImage, firstHalf  ,  getColor(255)); // white
        setPixel(newImage, secondHalf  ,  getColor(0)); // black
        
        return newImage;
    }
    
    private static int getColor(int color)
    {
        return new Color(color, color, color).getRGB();
    }
    
    private static void setPixel(BufferedImage bufferedImage, List<Pixel> listPixels, int color)
    {
        listPixels.stream().forEach((pixel) -> {
            bufferedImage.setRGB(pixel.getIntX(), pixel.getIntY(), color);
        });
    }
    
    
    private static BufferedImage applyImageEffect(BufferedImage bufferedImage, ImageEffectPixel imageEffect)
    {
        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();
        int type = bufferedImage.getType();
        
        BufferedImage newImage = new BufferedImage(width, height, type);
                
        Pixel currentPixel;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                
                currentPixel = new Pixel(x, y, new Color(bufferedImage.getRGB(x, y)) );
                imageEffect.effect(currentPixel);
                
                newImage.setRGB( currentPixel.getIntX(), currentPixel.getIntY(), currentPixel.getColor().getRGB() );
	    }
        }
        return newImage;
    }
    
    private static BufferedImage applyImageEffect(BufferedImage bufferedImage, ImageEffectLocal imageEffect, int maskSize)
    {
        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();
        int type = bufferedImage.getType();
        
        BufferedImage newImage = new BufferedImage(width, height, type);
        
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
                newImage.setRGB(x, y, imageEffect.effect(colors));
	    }
        }
        
        return newImage;
    }
    
    private static BufferedImage applyImageEffect(BufferedImage bufferedImage, ImageEffectPixelComplex imageEffect, double angle)
    {
        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();
        int type = bufferedImage.getType();
        
        BufferedImage newImage = new BufferedImage(width, height, type);
        
        //BufferedImage newImage = BufferedImageController.clone(bufferedImage);
        
        
        // Middle of the image
        double x0 = height * 0.5;
        double y0 = width * 0.5;
        
        Pixel currentPixel;
        
        for (int x = 0; x < width; x++) {
            
            for (int y = 0; y < height; y++) {
                
                currentPixel = new Pixel(x, y, new Color(bufferedImage.getRGB(x, y)) );
                imageEffect.effect(currentPixel, angle, x0, y0);
                
                if (currentPixel.getX() >= 0 && currentPixel.getX() < width && currentPixel.getY() >= 0 && currentPixel.getY() < height)
                {
                    newImage.setRGB( currentPixel.getIntX(), currentPixel.getIntY(), currentPixel.getColor().getRGB() );
                }
	    }
        }
        return newImage;
    }
    
    public static BufferedImage gammaEffect(BufferedImage bufferedImage)
    {
        return applyImageEffect(bufferedImage, TypeEffectFunction.getEffectPixel(Gamma));
    }
    

    public static BufferedImage grayScaleEffect(BufferedImage bufferedImage) {        
        return applyImageEffect(bufferedImage, TypeEffectFunction.getEffectPixel(GrayScale));
    }

    public static BufferedImage negativeEffect(BufferedImage bufferedImage) {
        return applyImageEffect(bufferedImage, TypeEffectFunction.getEffectPixel(Negative));
    }
    
    public static BufferedImage medianFilterEffect(BufferedImage bufferedImage) {
       
        return applyImageEffect(bufferedImage, TypeEffectFunction.getEffectLocal(Median), 3);
  
    }

    // Recebe angulo em Graus
    public static BufferedImage swirlEffect(BufferedImage bufferedImage, double angle) {
        
        return applyImageEffect(bufferedImage, TypeEffectFunction.getEffectPixelComplex(Swirl), angle);
    }

    public static BufferedImage erode(BufferedImage bufferedImage) {
        
        ElementoEstruturante ee = new ElementoEstruturante(3, 3, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1} );
        
        return applyImageEffect(bufferedImage, TypeEffectFunction.getEffectPixelEE(Erode), ee);
    }
    
    private static BufferedImage applyImageEffect(BufferedImage bufferedImage, ImageEffectPixelEE imageEffect, ElementoEstruturante ee)
    {
        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();
        int type = bufferedImage.getType();
        
        BufferedImage newImage = new BufferedImage(width, height, type);
        
        
        int halfHeight = ee.getHeight()/2;
        int halfWidth  = ee.getWidth()/2;
                
        Pixel currentPixel;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                
                currentPixel = new Pixel(x, y, new Color(bufferedImage.getRGB(x, y)) );
                
                if( x - halfWidth >= 0 && x + halfWidth < width &&
                    y - halfHeight >= 0 && y + halfHeight < height)
                {
                    
                        
                    for (int tempY = 0; tempY < ee.getHeight(); tempY++) {
                        int currentY = tempY + y - halfHeight;

                        for (int tempX = 0; tempX < ee.getWidth(); tempX++) {
                            int currentX = tempX + x - halfWidth;
                            
                            Pixel tempPixel = new Pixel(0, 0, new Color(bufferedImage.getRGB(currentY, currentX)) );
                            
                            ee.setAssociateNeighbours(tempX, tempY, tempPixel);
                            
                        }
                    }
                    
                    imageEffect.effect(currentPixel, ee);
                }
                else
                {
                    //System.out.println("Borda - " + x + " " + y);
                }
                
                //System.out.println(currentPixel.getColor().getBlue());
                
                newImage.setRGB( currentPixel.getIntX(), currentPixel.getIntY(), currentPixel.getColor().getRGB() );
	    }
        }
        return newImage;
    }
    
}
