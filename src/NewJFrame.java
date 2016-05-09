/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author ionildo
 */
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.filechooser.*;

public class NewJFrame extends javax.swing.JFrame {
    private BufferedImage imagem1;
    int flag=0;
    private BufferedImage imagem1Backup;
    
    private int X1, Y1, X2, Y2;
   
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMISobrepor = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMIReset = new javax.swing.JMenuItem();
        jMNegativo = new javax.swing.JMenuItem();
        jMISepia = new javax.swing.JMenuItem();
        jMIEscalaCinza = new javax.swing.JMenuItem();
        jMIAmpliar = new javax.swing.JMenuItem();
        jMIReducao = new javax.swing.JMenuItem();
        jMIEspelhoHorizontal = new javax.swing.JMenuItem();
        jMIEspelhoVertical = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMIRed = new javax.swing.JMenuItem();
        jMIGreen = new javax.swing.JMenuItem();
        jMIBlue = new javax.swing.JMenuItem();
        jMIRetanguloRecorte = new javax.swing.JMenuItem();
        jMIRotDir = new javax.swing.JMenuItem();
        jMIRotEsq = new javax.swing.JMenuItem();
        jMIGama = new javax.swing.JMenuItem();

        jMenuItem4.setText("jMenuItem4");

        jMenuItem7.setText("jMenuItem7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel1MouseReleased(evt);
            }
        });

        jMenu1.setText("Arquivo");

        jMenuItem1.setLabel("Abrir...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setLabel("Salvar...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMISobrepor.setText("Abrir Imagem e Soprepor...");
        jMISobrepor.setActionCommand("");
        jMISobrepor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISobreporActionPerformed(evt);
            }
        });
        jMenu1.add(jMISobrepor);

        jMenuItem3.setLabel("Sair");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Imagem");

        jMIReset.setText("Original");
        jMIReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIResetActionPerformed(evt);
            }
        });
        jMenu2.add(jMIReset);

        jMNegativo.setLabel("Negativo");
        jMNegativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMNegativoActionPerformed(evt);
            }
        });
        jMenu2.add(jMNegativo);

        jMISepia.setText("Sépia");
        jMISepia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISepiaActionPerformed(evt);
            }
        });
        jMenu2.add(jMISepia);

        jMIEscalaCinza.setText("Escala de Cinza");
        jMIEscalaCinza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIEscalaCinzaActionPerformed(evt);
            }
        });
        jMenu2.add(jMIEscalaCinza);

        jMIAmpliar.setText("Ampliar");
        jMIAmpliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAmpliarActionPerformed(evt);
            }
        });
        jMenu2.add(jMIAmpliar);

        jMIReducao.setText("Redução");
        jMIReducao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIReducaoActionPerformed(evt);
            }
        });
        jMenu2.add(jMIReducao);

        jMIEspelhoHorizontal.setText("Espelhar na Horizontal");
        jMIEspelhoHorizontal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIEspelhoHorizontalActionPerformed(evt);
            }
        });
        jMenu2.add(jMIEspelhoHorizontal);

        jMIEspelhoVertical.setText("Espelhar na Vertical");
        jMIEspelhoVertical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIEspelhoVerticalActionPerformed(evt);
            }
        });
        jMenu2.add(jMIEspelhoVertical);

        jMenu3.setText("Canais");

        jMIRed.setText("Red");
        jMIRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRedActionPerformed(evt);
            }
        });
        jMenu3.add(jMIRed);

        jMIGreen.setText("Green");
        jMIGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIGreenActionPerformed(evt);
            }
        });
        jMenu3.add(jMIGreen);

        jMIBlue.setText("Blue");
        jMIBlue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIBlueActionPerformed(evt);
            }
        });
        jMenu3.add(jMIBlue);

        jMenu2.add(jMenu3);

        jMIRetanguloRecorte.setText("Recortar (Retângulo)");
        jMIRetanguloRecorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRetanguloRecorteActionPerformed(evt);
            }
        });
        jMenu2.add(jMIRetanguloRecorte);

        jMIRotDir.setText("Rotacionar à direita");
        jMIRotDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRotDirActionPerformed(evt);
            }
        });
        jMenu2.add(jMIRotDir);

        jMIRotEsq.setText("Rotacionar à esquerda");
        jMIRotEsq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRotEsqActionPerformed(evt);
            }
        });
        jMenu2.add(jMIRotEsq);

        jMIGama.setText("Correção Gama");
        jMIGama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIGamaActionPerformed(evt);
            }
        });
        jMenu2.add(jMIGama);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("BMP, JPG, PNG & GIF Images", "bmp", "jpg", "png", "gif");
        chooser.setCurrentDirectory(new File("lucasfernandes\\Dropbox"));
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Abrir Imagem");
        int op = chooser.showOpenDialog(this);
        if(op == JFileChooser.APPROVE_OPTION){  
            File arq = chooser.getSelectedFile();  
            String path = arq.toString();  
            try { 
                  //carrega nova imagem
                  imagem1 = ImageIO.read(new File(path));
                  System.out.println("Arquivo aberto com sucesso!");
                  ImageIcon icon = new ImageIcon(imagem1);
                  if (flag==0) {
                      jLabel1.setIcon(icon);
                      Container contentPane = getContentPane();
                      contentPane.setLayout(new GridLayout());
                      contentPane.add(new JScrollPane(jLabel1));
                      flag=1;
                  }
                  else jLabel1.setIcon(icon);
                  setSize(imagem1.getWidth()+25, imagem1.getHeight()+70);
                  this.imagem1Backup =  deepCopy(imagem1);
	    }
	    catch(IOException e){
		System.out.println("Erro IO Exception! Verifique se o arquivo especificado existe e tente novamente.");
	    }
	    catch(Exception e){
		System.out.println("Erro Exception! " + e.getMessage());
	    }                   
        }  
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    
    private static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
    
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(1);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Salvar Imagem");
        int op = chooser.showSaveDialog(this);
        if(op == JFileChooser.APPROVE_OPTION){  
            File arq = chooser.getSelectedFile();  
            String path = arq.toString();  
            try {
		ImageIO.write(imagem1,"jpg",new File(path));
		System.out.println("Arquivo salvo com sucesso!");
		}
		catch(IOException e){
			System.out.println("Erro IO Exception! Verifique se o arquivo especificado existe e tente novamente.");
		}
		catch(Exception e){
			System.out.println("Erro Exception! " + e.getMessage());
		}
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMNegativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMNegativoActionPerformed
        int width = imagem1.getWidth();
	int height = imagem1.getHeight();
	for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) { 				
                
                /*
                int rgb = imagem1.getRGB(i, j); 				//a cor inversa é dado por 255 menos o valor de cada canal 				
                
                //int alpha    = 255 - (int)((rgb&0xFF000000)>>24);
                int r        = 255 - (int)((rgb&0x00FF0000)>>>16);
		int g        = 255 - (int)((rgb&0x0000FF00)>>>8);
		int b        = 255 - (int) (rgb&0x000000FF);
                */
		Color cor = new Color(imagem1.getRGB(i, j));
                
                //int alpha = 255 - cor.getAlpha();
                int r = 255 - cor.getRed();
                int g = 255 - cor.getGreen();
                int b = 255 - cor.getBlue();
                
                
                Color color = new Color(r, g, b);
		imagem1.setRGB(i, j, color.getRGB());
	    }
        }
        this.imageUpdate(imagem1, ALLBITS, 0, 0, width, height);

    }//GEN-LAST:event_jMNegativoActionPerformed

    private void jMIEscalaCinzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIEscalaCinzaActionPerformed
        // TODO add your handling code here:
        
        int width = imagem1.getWidth();
	int height = imagem1.getHeight();
        
	for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) { 	
                
                //int rgb = imagem1.getRGB(i, j); 	
		Color cor = new Color(imagem1.getRGB(i, j));
                
                int r = cor.getRed();
                int g = cor.getGreen();
                int b = cor.getBlue();
                
                int y = (int)(0.299 * r + 0.587 * g + 0.114 * b); 
                
                
                Color color = new Color(y,y,y);
		imagem1.setRGB(i, j, color.getRGB());
	    }
        }
        this.imageUpdate(imagem1, ALLBITS, 0, 0, width, height);
    }//GEN-LAST:event_jMIEscalaCinzaActionPerformed

    private void jMIAmpliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAmpliarActionPerformed

        
        int height = imagem1.getHeight() ;
        int width = imagem1.getWidth();
        int type = imagem1.getType();
        // Ampliar * 2
        BufferedImage imagemAux = new BufferedImage(width*2, height*2, type);
        
        int pixel;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) { 	
                
                //int rgb = imagem1.getRGB(i, j); 	
		pixel = imagem1.getRGB(i, j);
                
                imagemAux.setRGB(i * 2, j * 2, pixel);
                imagemAux.setRGB(i * 2, j * 2 + 1, pixel);
                imagemAux.setRGB(i * 2 + 1, j * 2, pixel);
                imagemAux.setRGB(i * 2 + 1, j * 2 + 1, pixel);
                
	    }
        }
        this.imagem1 = imagemAux;
        ImageIcon icon = new ImageIcon(this.imagem1);
        this.jLabel1.setIcon(icon);
        setSize(imagem1.getWidth() + 25, imagem1.getHeight()+ 70);
        this.imageUpdate(imagemAux, ALLBITS, 0, 0, width*2, height*2);
        
    }//GEN-LAST:event_jMIAmpliarActionPerformed

    private void jMIReducaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIReducaoActionPerformed

        int height = imagem1.getHeight();
        int width = imagem1.getWidth();
        int type = imagem1.getType();
        // Ampliar * 2
        BufferedImage imagemAux = new BufferedImage((width + 1)/2, (height + 1)/2, type);
        

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) { 	
                imagemAux.setRGB(i/2, j/2, imagem1.getRGB(i, j));
	    }
        }
        this.imagem1 = imagemAux;
        ImageIcon icon = new ImageIcon(this.imagem1);
        this.jLabel1.setIcon(icon);
        setSize(imagem1.getWidth() + 25, imagem1.getWidth() + 70);
        //this.imageUpdate(imagemAux, ALLBITS, 0, 0, width*2, height*2);
    }//GEN-LAST:event_jMIReducaoActionPerformed

    private void jMISepiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISepiaActionPerformed

        
        int width = imagem1.getWidth();
	int height = imagem1.getHeight();
        
	for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) { 	
                
                //int rgb = imagem1.getRGB(i, j); 	
		Color cor = new Color(imagem1.getRGB(i, j));
                
                cor = calcSepiaRGB(cor);
                
		imagem1.setRGB(i, j, cor.getRGB());
	    }
        }
        this.imageUpdate(imagem1, ALLBITS, 0, 0, width, height);
        
    }//GEN-LAST:event_jMISepiaActionPerformed

    private void jMIEspelhoHorizontalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIEspelhoHorizontalActionPerformed
        // TODO add your handling code here:
        
        int width = imagem1.getWidth();
	int height = imagem1.getHeight();
        int pixel;
	for (int i = 0; i < width/2; i++) {
            for (int j = 0; j < height; j++) { 	
                
                pixel = imagem1.getRGB(i, j);
                imagem1.setRGB(i, j, imagem1.getRGB(width-i-1, j));
                imagem1.setRGB(width-i-1, j, pixel);
	    }
        }
        this.imageUpdate(imagem1, ALLBITS, 0, 0, width, height);
        
    }//GEN-LAST:event_jMIEspelhoHorizontalActionPerformed

    private void jMIEspelhoVerticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIEspelhoVerticalActionPerformed
        // TODO add your handling code here:
        
        int width = imagem1.getWidth();
	int height = imagem1.getHeight();
        int pixel;
	for (int i = 0; i < width; i++) {
            for (int j = 0; j < height/2; j++) { 	
                
                pixel = imagem1.getRGB(i, j);
                imagem1.setRGB(i, j, imagem1.getRGB(i, height-j-1));
                imagem1.setRGB(i, height-j-1, pixel);
	    }
        }
        this.imageUpdate(imagem1, ALLBITS, 0, 0, width, height);
    }//GEN-LAST:event_jMIEspelhoVerticalActionPerformed

    private void jMIRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRedActionPerformed
        
        int width = imagem1.getWidth();
	int height = imagem1.getHeight();
	for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) { 	
                
		Color cor = new Color(imagem1.getRGB(i, j));
                
                //int alpha = 255 - cor.getAlpha();
                int r = cor.getRed();
                int g = 0;
                int b = 0;
                
                
                Color color = new Color(r, g, b);
		imagem1.setRGB(i, j, color.getRGB());
	    }
        }
        this.imageUpdate(imagem1, ALLBITS, 0, 0, width, height);
        
    }//GEN-LAST:event_jMIRedActionPerformed

    private void jMIGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIGreenActionPerformed
        int width = imagem1.getWidth();
	int height = imagem1.getHeight();
	for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) { 	
                
		Color cor = new Color(imagem1.getRGB(i, j));
                
                //int alpha = 255 - cor.getAlpha();
                int r = 0;
                int g = cor.getGreen();
                int b = 0;
                
                
                Color color = new Color(r, g, b);
		imagem1.setRGB(i, j, color.getRGB());
	    }
        }
        this.imageUpdate(imagem1, ALLBITS, 0, 0, width, height);
    }//GEN-LAST:event_jMIGreenActionPerformed

    private void jMIBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIBlueActionPerformed
        int width = imagem1.getWidth();
	int height = imagem1.getHeight();
	for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) { 	
                
		Color cor = new Color(imagem1.getRGB(i, j));
                
                //int alpha = 255 - cor.getAlpha();
                int r = 0;
                int g = 0;
                int b = cor.getBlue();
                
                
                Color color = new Color(r, g, b);
		imagem1.setRGB(i, j, color.getRGB());
	    }
        }
        this.imageUpdate(imagem1, ALLBITS, 0, 0, width, height);
    }//GEN-LAST:event_jMIBlueActionPerformed

    private void jMIResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIResetActionPerformed
        
        this.imagem1 = deepCopy(imagem1Backup);
        ImageIcon icon = new ImageIcon(this.imagem1);
        this.jLabel1.setIcon(icon);
        setSize(imagem1.getWidth() + 25, imagem1.getWidth() + 70);
        this.imageUpdate(imagem1, ALLBITS, 0, 0, imagem1.getWidth(), imagem1.getHeight());
    }//GEN-LAST:event_jMIResetActionPerformed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        X1 = evt.getX();
        Y1 = evt.getY();
        
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseReleased
        // TODO add your handling code here:
        X2 = evt.getX();
        Y2 = evt.getY();
    }//GEN-LAST:event_jLabel1MouseReleased

    private void jMIRetanguloRecorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRetanguloRecorteActionPerformed
        // TODO add your handling code here:
        
        int x = X2-X1;
        int y = Y2-Y1;
        
        if(x <= 0) {
            
        }
        
        imagem1 = imagem1.getSubimage(X1, Y1, Math.abs(x),Math.abs(y));
        ImageIcon icon = new ImageIcon(this.imagem1);
        this.jLabel1.setIcon(icon);
        setSize(imagem1.getWidth() + 25, imagem1.getWidth() + 70);
        
    }//GEN-LAST:event_jMIRetanguloRecorteActionPerformed

    private void jMIRotDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRotDirActionPerformed
        
        
        rotateImage("right");
        
    }//GEN-LAST:event_jMIRotDirActionPerformed

    private void rotateImage(String direction) {
        
        int height = imagem1.getWidth();
        int width = imagem1.getHeight();
        int type = imagem1.getType();
        // Ampliar * 2
        BufferedImage imagemAux = new BufferedImage(width, height, type);
        
        int pixel;
        
        //double rotatioDegree = Math.toRadians (90);
        switch (direction) {
            case "right":
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        
                        //int rgb = imagem1.getRGB(i, j);
                        pixel = imagem1.getRGB(j, i);
                        
                        
                        //imagemAux.setRGB(i, j, imagem1.getRGB(j, i) );
                        imagemAux.setRGB(width - i - 1, j, pixel );
                        
                    }
                }   break;
            case "left":
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        
                        //int rgb = imagem1.getRGB(i, j);
                        pixel = imagem1.getRGB(j, i);
                        
                        
                        //imagemAux.setRGB(i, j, imagem1.getRGB(j, i) );
                        imagemAux.setRGB(i, height-j-1, pixel );
                        
                    }
                }   break;
            default:
                return;
        }
        
        this.imagem1 = imagemAux;
        ImageIcon icon = new ImageIcon(this.imagem1);
        this.jLabel1.setIcon(icon);
        setSize(imagem1.getWidth() + 25, imagem1.getWidth() + 70);
    }
    
    private void jMIGamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIGamaActionPerformed
        // TODO add your handling code here:
        
        
        
        int width = imagem1.getWidth();
	int height = imagem1.getHeight();
	for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) { 	
                
		Color cor = new Color(imagem1.getRGB(i, j));
                int R = (int) (Math.pow(cor.getRed()/255.0, 0.4) * 255);
                int G = (int) (Math.pow(cor.getGreen()/255.0, 0.4) * 255);
                int B = (int) (Math.pow(cor.getBlue()/255.0, 0.4) * 255);

                Color color = new Color(R, G, B);

                imagem1.setRGB(i, j, color.getRGB());
	    }
        }
        this.imageUpdate(imagem1, ALLBITS, 0, 0, width, height);
        
    }//GEN-LAST:event_jMIGamaActionPerformed

    private void jMISobreporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISobreporActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("BMP, JPG, PNG & GIF Images", "bmp", "jpg", "png", "gif");
        chooser.setCurrentDirectory(new File("lucasfernandes\\Dropbox"));
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Abrir Imagem");
        int op = chooser.showOpenDialog(this);
        if(op == JFileChooser.APPROVE_OPTION){  
            File arq = chooser.getSelectedFile();  
            String path = arq.toString();  
            try { 
                  //carrega nova imagem
                  BufferedImage imagemSobrepor = ImageIO.read(new File(path));
                  
                  System.out.println("Arquivo aberto com sucesso!");
                  sobrepor(imagemSobrepor);
                  /*
                    ImageIcon icon = new ImageIcon(imagemSobrepor);
                    if (flag==0) {
                        jLabel1.setIcon(icon);
                        Container contentPane = getContentPane();
                        contentPane.setLayout(new GridLayout());
                        contentPane.add(new JScrollPane(jLabel1));
                        flag=1;
                    }
                    else jLabel1.setIcon(icon);
                    setSize(imagem1.getWidth()+25, imagem1.getHeight()+70);
                    this.imagem1Backup =  deepCopy(imagem1);
                  */
	    }
	    catch(IOException e){
		System.out.println("Erro IO Exception! Verifique se o arquivo especificado existe e tente novamente.");
	    }
	    catch(Exception e){
		System.out.println("Erro Exception! " + e.getMessage());
	    }                   
        } 
    }//GEN-LAST:event_jMISobreporActionPerformed

    private void jMIRotEsqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRotEsqActionPerformed
        // TODO add your handling code here
        rotateImage("left");
    }//GEN-LAST:event_jMIRotEsqActionPerformed
    private void sobrepor(BufferedImage imagemSobrepor) {
        //C = c1*(1-α) + c2*α;
        
        int width = imagem1.getWidth();
	int height = imagem1.getHeight();
        
        if(imagemSobrepor.getHeight() != height || imagemSobrepor.getWidth() != width){
            JOptionPane.showMessageDialog(null, "Imagens possuem tamanhos diferentes", "Erro!", ERROR_MESSAGE);
            return;
        }
        
        double alpha;
        try{
            String number;
            do {
                number = JOptionPane.showInputDialog(null, "Digite um número alpha entre 0 à 1", "Selecione alpha", INFORMATION_MESSAGE);
                alpha = Double.parseDouble(number);
            }while(alpha < 0 || alpha > 1);
        }
        catch(HeadlessException | NumberFormatException ex){
		System.out.println("Erro Exception! " + ex.getMessage());
                return;
        }
        
	for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) { 	
                
		Color corI1 = new Color(imagem1.getRGB(i, j));
                Color corIS = new Color(imagemSobrepor.getRGB(i, j));
                int R = (int) (corI1.getRed()   * (1 - alpha) + corIS.getRed()      * alpha );
                int G = (int) (corI1.getGreen() * (1 - alpha) + corIS.getGreen()    * alpha );
                int B = (int) (corI1.getBlue()  * (1 - alpha) + corIS.getBlue()     * alpha );
                

                Color color = new Color(R, G, B);

                imagem1.setRGB(i, j, color.getRGB());
	    }
        }
        this.imageUpdate(imagem1, ALLBITS, 0, 0, width, height);
    }
    
    private Color calcSepiaRGB(Color cor){
        
        int red = cor.getRed();
        int green = cor.getGreen();
        int blue = cor.getBlue();
        
        int nRed    = (int) ((red * .393) + (green *.769) + (blue * .189));
        int nGreen  = (int)((red * .349) + (green *.686) + (blue * .168));
        int nBlue   = (int)((red * .272) + (green *.534) + (blue * .131));
        
        if(nRed > 255)
            nRed = 255;
        if(nGreen > 255)
            nGreen = 255;
        if(nBlue > 255)
            nBlue = 255;
        
        Color newCor = new Color(nRed, nGreen, nBlue);
        
        return newCor;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMIAmpliar;
    private javax.swing.JMenuItem jMIBlue;
    private javax.swing.JMenuItem jMIEscalaCinza;
    private javax.swing.JMenuItem jMIEspelhoHorizontal;
    private javax.swing.JMenuItem jMIEspelhoVertical;
    private javax.swing.JMenuItem jMIGama;
    private javax.swing.JMenuItem jMIGreen;
    private javax.swing.JMenuItem jMIRed;
    private javax.swing.JMenuItem jMIReducao;
    private javax.swing.JMenuItem jMIReset;
    private javax.swing.JMenuItem jMIRetanguloRecorte;
    private javax.swing.JMenuItem jMIRotDir;
    private javax.swing.JMenuItem jMIRotEsq;
    private javax.swing.JMenuItem jMISepia;
    private javax.swing.JMenuItem jMISobrepor;
    private javax.swing.JMenuItem jMNegativo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem7;
    // End of variables declaration//GEN-END:variables
}
