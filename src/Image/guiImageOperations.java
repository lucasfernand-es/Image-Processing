package Image;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author ionildo
 */
import Image.Controller.BufferedImageController;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.filechooser.*;



import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class guiImageOperations extends javax.swing.JFrame {
    
    private BufferedImage mainImage;
    private BufferedImage mainImageUndo;
    private BufferedImage mainImageOriginal;
    
    
    private BufferedImage imagemSobrepor = null;
    
    private int actualGrayPGM = 0;
    
    private double alpha = 0.0;
    
    private int X1, Y1, X2, Y2;
   
    public guiImageOperations() {
        initComponents();
        //this.setResizable(false);
        jPImage.setLayout(new GridLayout());
        jPImage.add(new JScrollPane(jLImage));
    }

    
    private void setMainImage(BufferedImage bufferedImage) {
        
        this.mainImage = BufferedImageController.clone(bufferedImage);
        ImageIcon icon = new ImageIcon(this.mainImage);
        this.jLImage.setIcon(icon);
        this.setSize(new Dimension((mainImage.getWidth() + 25 > 200)? mainImage.getWidth() + 25: 225, mainImage.getHeight() + 200));
    
    }
    
    private void loadMainImage(BufferedImage bufferedImage)
    {
        setMainImage(bufferedImage);
        this.mainImageOriginal =  BufferedImageController.clone(bufferedImage);
        this.mainImageUndo = BufferedImageController.clone(bufferedImage);
        
        System.out.println(bufferedImage.getType());
        System.out.println(mainImage.getType());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jPImage = new javax.swing.JPanel();
        jLImage = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSAlpha = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jLAlphaIndex = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMIOpenImage = new javax.swing.JMenuItem();
        jMISI = new javax.swing.JMenuItem();
        jMIAbrirPGM = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMISalvarPGM = new javax.swing.JMenuItem();
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
        jMenu4 = new javax.swing.JMenu();
        jMIMediana = new javax.swing.JMenuItem();
        jMIFiltroMedia = new javax.swing.JMenuItem();
        jMIFiltroGaussiano3 = new javax.swing.JMenuItem();
        jMIFiltroGaussiano5 = new javax.swing.JMenuItem();
        jMISharpen = new javax.swing.JMenuItem();
        jMILaplaciano = new javax.swing.JMenuItem();
        jMISaltAndPepper = new javax.swing.JMenuItem();
        jMIPrewittHorizontal = new javax.swing.JMenuItem();
        jMIPrewittVertical = new javax.swing.JMenuItem();
        jMISwirl = new javax.swing.JMenuItem();
        jMIErosao = new javax.swing.JMenuItem();
        jMISobrepor = new javax.swing.JMenuItem();

        jMenuItem4.setText("jMenuItem4");

        jMenuItem7.setText("jMenuItem7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLImageMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLImageMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPImageLayout = new javax.swing.GroupLayout(jPImage);
        jPImage.setLayout(jPImageLayout);
        jPImageLayout.setHorizontalGroup(
            jPImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPImageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLImage, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPImageLayout.setVerticalGroup(
            jPImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPImageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLImage, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sobrepor Imagens"));
        jPanel1.setName(""); // NOI18N

        jSAlpha.setToolTipText("");
        jSAlpha.setValue(0);
        jSAlpha.setEnabled(false);
        jSAlpha.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSAlphaStateChanged(evt);
            }
        });

        jLabel2.setText("Índice:");

        jLAlphaIndex.setText("0%");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSAlpha, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLAlphaIndex)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLAlphaIndex))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSAlpha, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jMenu1.setText("Arquivo");

        jMIOpenImage.setLabel("Abrir...");
        jMIOpenImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIOpenImageActionPerformed(evt);
            }
        });
        jMenu1.add(jMIOpenImage);

        jMISI.setText("Abrir Segunda Imagem...");
        jMISI.setActionCommand("");
        jMISI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISIActionPerformed(evt);
            }
        });
        jMenu1.add(jMISI);

        jMIAbrirPGM.setText("Abrir PGM (P2)...");
        jMIAbrirPGM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAbrirPGMActionPerformed(evt);
            }
        });
        jMenu1.add(jMIAbrirPGM);

        jMenuItem2.setLabel("Salvar...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMISalvarPGM.setText("Salvar PGM...");
        jMISalvarPGM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISalvarPGMActionPerformed(evt);
            }
        });
        jMenu1.add(jMISalvarPGM);

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

        jMenu4.setText("Filtros");

        jMIMediana.setText("Mediana");
        jMIMediana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIMedianaActionPerformed(evt);
            }
        });
        jMenu4.add(jMIMediana);

        jMIFiltroMedia.setText("Média");
        jMIFiltroMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIFiltroMediaActionPerformed(evt);
            }
        });
        jMenu4.add(jMIFiltroMedia);

        jMIFiltroGaussiano3.setText("Gaussiano 3X3");
        jMIFiltroGaussiano3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIFiltroGaussiano3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMIFiltroGaussiano3);

        jMIFiltroGaussiano5.setText("Gaussiano 5X5");
        jMIFiltroGaussiano5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIFiltroGaussiano5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMIFiltroGaussiano5);

        jMISharpen.setText("Sharpen");
        jMISharpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISharpenActionPerformed(evt);
            }
        });
        jMenu4.add(jMISharpen);

        jMenu2.add(jMenu4);

        jMILaplaciano.setText("Laplaciano");
        jMILaplaciano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMILaplacianoActionPerformed(evt);
            }
        });
        jMenu2.add(jMILaplaciano);

        jMISaltAndPepper.setText("Ruído Sal e Pimenta");
        jMISaltAndPepper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISaltAndPepperActionPerformed(evt);
            }
        });
        jMenu2.add(jMISaltAndPepper);

        jMIPrewittHorizontal.setText("Prewitt Horizontal");
        jMIPrewittHorizontal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPrewittHorizontalActionPerformed(evt);
            }
        });
        jMenu2.add(jMIPrewittHorizontal);

        jMIPrewittVertical.setText("Prewitt Vertical");
        jMIPrewittVertical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPrewittVerticalActionPerformed(evt);
            }
        });
        jMenu2.add(jMIPrewittVertical);

        jMISwirl.setText("Swirl");
        jMISwirl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISwirlActionPerformed(evt);
            }
        });
        jMenu2.add(jMISwirl);

        jMIErosao.setText("Erosão");
        jMIErosao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIErosaoActionPerformed(evt);
            }
        });
        jMenu2.add(jMIErosao);

        jMISobrepor.setText("Sobrepor");
        jMISobrepor.setEnabled(false);
        jMISobrepor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISobreporActionPerformed(evt);
            }
        });
        jMenu2.add(jMISobrepor);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIOpenImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIOpenImageActionPerformed

        
        BufferedImage bufferedImage = BufferedImageController.load("BMP, JPG, PNG & GIF Images", new String[]{"bmp", "jpg", "png", "gif"});     
        if(bufferedImage == null)
            return;
        loadMainImage(bufferedImage);
         
    }//GEN-LAST:event_jMIOpenImageActionPerformed

    
    
    
    
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
		ImageIO.write(mainImage,"jpg",new File(path));
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
        BufferedImage newImage = BufferedImageController.negativeEffect(mainImage);
        setMainImage(newImage);

    }//GEN-LAST:event_jMNegativoActionPerformed

    private void jMIEscalaCinzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIEscalaCinzaActionPerformed
        // TODO add your handling code here:
        
        BufferedImage newImage = BufferedImageController.grayScaleEffect(mainImage);
        setMainImage(newImage);
    }//GEN-LAST:event_jMIEscalaCinzaActionPerformed

    private void jMIAmpliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAmpliarActionPerformed

        
        int height = mainImage.getHeight() ;
        int width = mainImage.getWidth();
        int type = mainImage.getType();
        // Ampliar * 2
        BufferedImage imagemAux = new BufferedImage(width*2, height*2, type);
        
        int pixel;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) { 	
                
                //int rgb = mainImage.getRGB(i, j); 	
		pixel = mainImage.getRGB(i, j);
                
                imagemAux.setRGB(i * 2, j * 2, pixel);
                imagemAux.setRGB(i * 2, j * 2 + 1, pixel);
                imagemAux.setRGB(i * 2 + 1, j * 2, pixel);
                imagemAux.setRGB(i * 2 + 1, j * 2 + 1, pixel);
                
	    }
        }
        
        setMainImage(imagemAux);
        
    }//GEN-LAST:event_jMIAmpliarActionPerformed

    private void jMIReducaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIReducaoActionPerformed

        int height = mainImage.getHeight();
        int width = mainImage.getWidth();
        int type = mainImage.getType();
        // Ampliar * 2
        BufferedImage imagemAux = new BufferedImage((width + 1)/2, (height + 1)/2, type);
        

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) { 	
                imagemAux.setRGB(i/2, j/2, mainImage.getRGB(i, j));
	    }
        }
        setMainImage(imagemAux);
        //this.imageUpdate(imagemAux, ALLBITS, 0, 0, width*2, height*2);
    }//GEN-LAST:event_jMIReducaoActionPerformed

    private void jMISepiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISepiaActionPerformed

        
        int width = mainImage.getWidth();
	int height = mainImage.getHeight();
        
	for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) { 	
                
                //int rgb = mainImage.getRGB(i, j); 	
		Color cor = new Color(mainImage.getRGB(i, j));
                
                cor = calcSepiaRGB(cor);
                
		mainImage.setRGB(i, j, cor.getRGB());
	    }
        }
        setMainImage(mainImage);
  //      this.imageUpdate(mainImage, ALLBITS, 0, 0, width, height);
        
    }//GEN-LAST:event_jMISepiaActionPerformed

    private void jMIEspelhoHorizontalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIEspelhoHorizontalActionPerformed
        // TODO add your handling code here:
        
        int width = mainImage.getWidth();
	int height = mainImage.getHeight();
        int pixel;
	for (int i = 0; i < width/2; i++) {
            for (int j = 0; j < height; j++) { 	
                
                pixel = mainImage.getRGB(i, j);
                mainImage.setRGB(i, j, mainImage.getRGB(width-i-1, j));
                mainImage.setRGB(width-i-1, j, pixel);
	    }
        }
        //this.imageUpdate(mainImage, ALLBITS, 0, 0, width, height);
        setMainImage(mainImage);
        
    }//GEN-LAST:event_jMIEspelhoHorizontalActionPerformed

    private void jMIEspelhoVerticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIEspelhoVerticalActionPerformed
        // TODO add your handling code here:
        
        int width = mainImage.getWidth();
	int height = mainImage.getHeight();
        int pixel;
	for (int i = 0; i < width; i++) {
            for (int j = 0; j < height/2; j++) { 	
                
                pixel = mainImage.getRGB(i, j);
                mainImage.setRGB(i, j, mainImage.getRGB(i, height-j-1));
                mainImage.setRGB(i, height-j-1, pixel);
	    }
        }
        //this.imageUpdate(mainImage, ALLBITS, 0, 0, width, height);
        setMainImage(mainImage);
    }//GEN-LAST:event_jMIEspelhoVerticalActionPerformed

    private void jMIRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRedActionPerformed
        
        int width = mainImage.getWidth();
	int height = mainImage.getHeight();
	for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) { 	
                
		Color cor = new Color(mainImage.getRGB(i, j));
                
                //int alpha = 255 - cor.getAlpha();
                int r = cor.getRed();
                int g = 0;
                int b = 0;
                
                
                Color color = new Color(r, g, b);
		mainImage.setRGB(i, j, color.getRGB());
	    }
        }
        //this.imageUpdate(mainImage, ALLBITS, 0, 0, width, height);
        setMainImage(mainImage);
    }//GEN-LAST:event_jMIRedActionPerformed

    private void jMIGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIGreenActionPerformed
        int width = mainImage.getWidth();
	int height = mainImage.getHeight();
	for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) { 	
                
		Color cor = new Color(mainImage.getRGB(i, j));
                
                //int alpha = 255 - cor.getAlpha();
                int r = 0;
                int g = cor.getGreen();
                int b = 0;
                
                
                Color color = new Color(r, g, b);
		mainImage.setRGB(i, j, color.getRGB());
	    }
        }
        //this.imageUpdate(mainImage, ALLBITS, 0, 0, width, height);
        setMainImage(mainImage);
    }//GEN-LAST:event_jMIGreenActionPerformed

    private void jMIBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIBlueActionPerformed
        int width = mainImage.getWidth();
	int height = mainImage.getHeight();
	for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) { 	
                
		Color cor = new Color(mainImage.getRGB(i, j));
                
                //int alpha = 255 - cor.getAlpha();
                int r = 0;
                int g = 0;
                int b = cor.getBlue();
                
                
                Color color = new Color(r, g, b);
		mainImage.setRGB(i, j, color.getRGB());
	    }
        }
        
        setMainImage(mainImage);
        //this.imageUpdate(mainImage, ALLBITS, 0, 0, width, height);
    }//GEN-LAST:event_jMIBlueActionPerformed

    private void jMIResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIResetActionPerformed
        
        this.mainImage = BufferedImageController.clone(this.mainImageOriginal);
        setMainImage(mainImage);
    }//GEN-LAST:event_jMIResetActionPerformed

    private void jLImageMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLImageMousePressed
        X1 = evt.getX();
        Y1 = evt.getY();
        
    }//GEN-LAST:event_jLImageMousePressed

    private void jLImageMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLImageMouseReleased
        // TODO add your handling code here:
        X2 = evt.getX();
        Y2 = evt.getY();
    }//GEN-LAST:event_jLImageMouseReleased

    private void jMIRetanguloRecorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRetanguloRecorteActionPerformed
        // TODO add your handling code here:
        
        int x = X2-X1;
        int y = Y2-Y1;
        
        if(x <= 0) {
            
        }
        
        //setMainImage(imagemAux);
        
    }//GEN-LAST:event_jMIRetanguloRecorteActionPerformed

    private void jMIRotDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRotDirActionPerformed
        
        
        rotateImage("right");
        
    }//GEN-LAST:event_jMIRotDirActionPerformed

    private void rotateImage(String direction) {
        
        int height = mainImage.getWidth();
        int width = mainImage.getHeight();
        int type = mainImage.getType();
        // Ampliar * 2
        BufferedImage imagemAux = new BufferedImage(width, height, type);
        
        int pixel;
        
        //double rotatioDegree = Math.toRadians (90);
        switch (direction) {
            case "right":
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        
                        //int rgb = mainImage.getRGB(i, j);
                        pixel = mainImage.getRGB(j, i);
                        
                        
                        //imagemAux.setRGB(i, j, mainImage.getRGB(j, i) );
                        imagemAux.setRGB(width - i - 1, j, pixel );
                        
                    }
                }   break;
            case "left":
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        
                        //int rgb = mainImage.getRGB(i, j);
                        pixel = mainImage.getRGB(j, i);
                        
                        
                        //imagemAux.setRGB(i, j, mainImage.getRGB(j, i) );
                        imagemAux.setRGB(i, height-j-1, pixel );
                        
                    }
                }   break;
            default:
                return;
        }
        
        setMainImage(imagemAux);
    }
    
    private void jMIGamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIGamaActionPerformed
        // TODO add your handling code here:
        
        BufferedImageController.gammaEffect(mainImage);
        
        setMainImage(mainImage);
        
    }//GEN-LAST:event_jMIGamaActionPerformed

    private void jMISIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISIActionPerformed
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
                  this.imagemSobrepor = ImageIO.read(new File(path));
                  //ImageIcon icon = new ImageIcon(mainImage);
                  System.out.println("Arquivo aberto com sucesso!");
                  
                  jMISobrepor.setEnabled(true);
                  
                  
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
                    setSize(mainImage.getWidth()+25, mainImage.getHeight()+70);
                    this.mainImageBackup =  BufferedImageController.clone(mainImage);
                  */

	    }
	    catch(IOException e){
		System.out.println("Erro IO Exception! Verifique se o arquivo especificado existe e tente novamente.");
	    }
	    catch(Exception e){
		System.out.println("Erro Exception! " + e.getMessage());
	    }                   
        } 
        //jMISobrepor.setEnabled(true);
        
        
    }//GEN-LAST:event_jMISIActionPerformed

    private void jMIRotEsqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRotEsqActionPerformed
        // TODO add your handling code here
        rotateImage("left");
    }//GEN-LAST:event_jMIRotEsqActionPerformed

    private void jSAlphaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSAlphaStateChanged
        // TODO add your handling code here:
        
        JSlider s = (JSlider)evt.getSource();
        int index = s.getValue();
       
        alpha =  index/100.0;
        jLAlphaIndex.setText(index + "%");
        
        sobrepor();
        
    }//GEN-LAST:event_jSAlphaStateChanged

    private void jMISobreporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISobreporActionPerformed
        // TODO add your handling code here:
        
        this.mainImageUndo = BufferedImageController.clone(this.mainImage);
        this.jSAlpha.setEnabled(true);
        //sobrepor();
    }//GEN-LAST:event_jMISobreporActionPerformed

    private void jMIAbrirPGMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAbrirPGMActionPerformed
        // TODO add your handling code here:
        
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PGM Images", "pgm");
        chooser.setCurrentDirectory(new File("lucasfernandes//images"));
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Abrir Imagem PGM");
        int op = chooser.showOpenDialog(this);
        if(op == JFileChooser.APPROVE_OPTION){  
            File arq = chooser.getSelectedFile();  
            String path = arq.toString(); 
            //System.out.println(path);
            
             createPGM_P2(path);
                  
        }
    }//GEN-LAST:event_jMIAbrirPGMActionPerformed

    private void jMISalvarPGMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISalvarPGMActionPerformed
        // TODO add your handling code here:
        
        if(this.mainImage.getType() != BufferedImageController.getPGMTYPE())
        {
            System.out.println("A imagem atual não está no formato PGM.");
        }
        
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PGM Images", "pgm");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Salvar Imagem PGM");
        int op = chooser.showSaveDialog(this);
        if(op == JFileChooser.APPROVE_OPTION){  
            File arq = chooser.getSelectedFile();  
            String path = arq.toString();  
            
            savePGM_P2(path);
            System.out.println("Arquivo salvo com sucesso!");
        }
    }//GEN-LAST:event_jMISalvarPGMActionPerformed

    private void jMIFiltroGaussiano3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIFiltroGaussiano3ActionPerformed
        // TODO add your handling code here:
        
        int height = mainImage.getHeight();
        int width = mainImage.getWidth();
        int type = mainImage.getType();
        // Ampliar * 2
        BufferedImage imagemAux = new BufferedImage(width, height, type);
        
        float data[] = {    1.0f/9.0f, 1.0f/9.0f, 1.0f/9.0f,
                            1.0f/9.0f, 1.0f/9.0f, 1.0f/9.0f, 
                            1.0f/9.0f, 1.0f/9.0f, 1.0f/9.0f };
    
        Kernel kernel = new Kernel(3, 3, data);
        ConvolveOp convolve = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        convolve.filter(mainImage, imagemAux);
        
        setMainImage(imagemAux);
    }//GEN-LAST:event_jMIFiltroGaussiano3ActionPerformed

    private void jMIFiltroMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIFiltroMediaActionPerformed
        
        int height = mainImage.getHeight();
        int width = mainImage.getWidth();
        int type = mainImage.getType();
        // Ampliar * 2
        BufferedImage imagemAux = new BufferedImage(width, height, type);
        
        float data[] = {    0.0625f,     0.125f,     0.0625f,
                            0.125f,      0.25f,      0.125f, 
                            0.0625f,     0.125f,     0.0625f };
    
        Kernel kernel = new Kernel(3, 3, data);
        ConvolveOp convolve = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        convolve.filter(mainImage, imagemAux);
        
        setMainImage(imagemAux);

        
    }//GEN-LAST:event_jMIFiltroMediaActionPerformed

    private void jMIFiltroGaussiano5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIFiltroGaussiano5ActionPerformed
        
        int height = mainImage.getHeight();
        int width = mainImage.getWidth();
        int type = mainImage.getType();
        // Ampliar * 2
        BufferedImage imagemAux = new BufferedImage(width, height, type);
        
        float data[] = {    1.0f/273.0f, 4.0f/273.0f,   7.0f/273.0f,    4.0f/273.0f,   1.0f/273.0f, 
                            4.0f/273.0f, 16.0f/273.0f,  26.0f/273.0f,   16.0f/273.0f,  4.0f/273.0f,
                            7.0f/273.0f, 26.0f/273.0f,  41.0f/273.0f,   26.0f/273.0f,  7.0f/273.0f,
                            4.0f/273.0f, 16.0f/273.0f,  26.0f/273.0f,   16f/273.0f,    4.0f/273.0f,
                            1.0f/273.0f, 4.0f/273.0f,   7.0f/273.0f,    4.0f/273.0f,   1.0f/273.0f
                        };
    
        Kernel kernel = new Kernel(5, 5, data);
        ConvolveOp convolve = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        convolve.filter(mainImage, imagemAux);
        
        setMainImage(imagemAux);
        
    }//GEN-LAST:event_jMIFiltroGaussiano5ActionPerformed

    private void jMISharpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISharpenActionPerformed
        // TODO add your handling code here:
        
        int height = mainImage.getHeight();
        int width = mainImage.getWidth();
        int type = mainImage.getType();
        // Ampliar * 2
        BufferedImage imagemAux = new BufferedImage(width, height, type);
        
        float data[] = {    -1.0f, -1.0f, -1.0f,
                            -1.0f, 9.0f, -1.0f,
                            -1.0f, -1.0f, -1.0f};
    
        Kernel kernel = new Kernel(3, 3, data);
        ConvolveOp convolve = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        convolve.filter(mainImage, imagemAux);
        
        setMainImage(imagemAux);
    }//GEN-LAST:event_jMISharpenActionPerformed

    private void jMILaplacianoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMILaplacianoActionPerformed
        // TODO add your handling code here:
        
        int height = mainImage.getHeight();
        int width = mainImage.getWidth();
        int type = mainImage.getType();
        // Ampliar * 2
        BufferedImage imagemAux = new BufferedImage(width, height, type);
        
        float data[] = {    0.0f, -1.0f, 0.0f,
                            -1.0f, 4.0f, -1.0f,
                            0.0f, -1.0f, 0.0f};
    
        Kernel kernel = new Kernel(3, 3, data);
        ConvolveOp convolve = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        convolve.filter(mainImage, imagemAux);
        
        setMainImage(imagemAux);
    }//GEN-LAST:event_jMILaplacianoActionPerformed

    private void jMISaltAndPepperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISaltAndPepperActionPerformed
        
        double percentage = Double.parseDouble( 
                JOptionPane.showInputDialog(null, "Digite a porcentagem de ruído", "Ruído Sal e Pimenta", INFORMATION_MESSAGE) 
        );
        
        
        BufferedImage newImage = BufferedImageController.setSaltAndPepperNoise(mainImage, percentage/100);
        setMainImage(newImage);

    }//GEN-LAST:event_jMISaltAndPepperActionPerformed

    private void jMIMedianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIMedianaActionPerformed
        // TODO add your handling code here:
        
        BufferedImage newImage = BufferedImageController.medianFilterEffect(mainImage);
        setMainImage(newImage);
        
        
    }//GEN-LAST:event_jMIMedianaActionPerformed

    private void jMIPrewittHorizontalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrewittHorizontalActionPerformed
        // TODO add your handling code here:
        
        int height = mainImage.getHeight();
        int width = mainImage.getWidth();
        int type = mainImage.getType();
        // Ampliar * 2
        BufferedImage imagemAux = new BufferedImage(width, height, type);
        
        
        float data[] = {    
                        -1, - 1, -1,
                        0, 0, 0,
                        1, 1, 1
        };
        /*
        float data[] = {    
                        -1, 0, 1,
                        -1, 0, 1,
                        -1, 0, 1
        };
        */
    
        Kernel kernel = new Kernel(3, 3, data);
        ConvolveOp convolve = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        convolve.filter(mainImage, imagemAux);
        
        setMainImage(imagemAux);
    }//GEN-LAST:event_jMIPrewittHorizontalActionPerformed

    private void jMISwirlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISwirlActionPerformed
        // TODO add your handling code here:
        
        int angle  = 512;
        
        BufferedImage newImage = BufferedImageController.swirlEffect(mainImage, angle);
        setMainImage(newImage);
    }//GEN-LAST:event_jMISwirlActionPerformed

    private void jMIPrewittVerticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrewittVerticalActionPerformed
        // TODO add your handling code here:
        
        int height = mainImage.getHeight();
        int width = mainImage.getWidth();
        int type = mainImage.getType();
        // Ampliar * 2
        BufferedImage imagemAux = new BufferedImage(width, height, type);
        
       int oi[][] = { {0}, {1} };
        
        float data[] = {    
                        -1, 0, 1,
                        -1, 0, 1,
                        -1, 0, 1
        };
    
        Kernel kernel = new Kernel(3, 3, data);
        ConvolveOp convolve = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        convolve.filter(mainImage, imagemAux);
        
        setMainImage(imagemAux);
        
    }//GEN-LAST:event_jMIPrewittVerticalActionPerformed

    private void jMIErosaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIErosaoActionPerformed

        BufferedImage newImage = BufferedImageController.erode(mainImage);
        setMainImage(newImage);
    }//GEN-LAST:event_jMIErosaoActionPerformed
    
    
    
    private void savePGM_P2(String path)  {
        
        
        //PrintWriter out = new PrintWriter("filename.txt");
        try(PrintWriter writer = new PrintWriter(path, "UTF-8")) {
            //String pgmFile = "";
            // Tipo do arquivo
            writer.println("P2");
            // Título
            writer.println("# My PGM P2 File");
            // Tamanho da Imagem
            int width = mainImage.getWidth();
            int height = mainImage.getHeight();
            
            writer.println(width + " " + height);
            
            // Tom máximo de cinze valor d
            int currentMaxVal = 0;
            
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) { 	

                    Color cor = new Color(mainImage.getRGB(i, j));

                    if(cor.getRed() > currentMaxVal)
                    {
                        currentMaxVal = cor.getRed();
                        //System.out.println("x- " + j + " y- "+ i);
                    }
                }
            }
            // Escreve cinza máximo - precisa convertar do cinza máximo atual para o cinza máximo original
            //writer.println(currentMaxVal);
            //System.out.println(actualGrayPGM);
            writer.println(actualGrayPGM);
            
            // Escrever os pixels
            
            int countElementLine = 0;
            
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) { 	

                    Color cor = new Color(mainImage.getRGB(x, y));
                    
                    int actualGrayShade = convertGray(cor.getBlue(), actualGrayPGM, currentMaxVal);
                    
                    writer.print(actualGrayShade);
                    
                    countElementLine++;
                    // Se tem 70 elementos
                    if(countElementLine >= 70) {
                        // Insera uma nova linha do arquivo se não for a última linha da imagem
                        
                        writer.println("\n");
                        countElementLine = 0;
                    }
                    else // caso não seja um final de linha, insere espaço
                        writer.print(" ");
                    
                }
            }
            
            
        } catch (UnsupportedEncodingException | FileNotFoundException ex) {
            Logger.getLogger(guiImageOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void createPGM_P2(String path){ 
        
        //InputStream file = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
        
        //br = new BufferedReader(new FileReader("C:\\testing.txt"));
        /*
        
            RenderedImage rending= JAI.create("fileload",path);
            BufferedImage imageAux = new RenderedImageAdapter(rending).getAsBufferedImage();
            //System.out.println(imageAux.getType());
            if (flag == 0) {
                        //Container contentPane = getContentPane();
                        jPImage.setLayout(new GridLayout());
                        jPImage.add(new JScrollPane(jLabel1));
                        flag = 1;
                    }
                    setMainImage(imageAux);
                    this.mainImageOriginal =  BufferedImageController.clone(imageAux);
                    this.mainImageUndo = BufferedImageController.clone(imageAux);
                    setMainImage(imageAux);
        
        */
        
        BufferedReader data;
        try{
            data = new BufferedReader(new FileReader(path));
            
        }
        catch(FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado " + ex.getMessage());
            return;
        }
       
        try {
                // Deve conter P2
                String fileID = data.readLine();
                //System.out.println(fileID);
                
                if(!fileID.equalsIgnoreCase("P2")){
                    System.out.println("Somente arquivo .PGM no formato P2 são aceitos!");
                    return;
                }
                
                String nextlLine = data.readLine(); // Ignora a linha do título
                
                while(nextlLine.startsWith("#")){
                    System.out.println(nextlLine);
                    nextlLine = data.readLine();
                }
                
                String size = nextlLine; // Contém a largura e a altura da imagem
                //System.out.println("size " + size);
                
                Scanner scanner = new Scanner(size);
                int width = scanner.nextInt();
                int height = scanner.nextInt();
                //System.out.println(width + height);
                
            
                String maxGray = data.readLine();// Contém o valor máximo de cinza
                //System.out.println(maxGray);
                
                scanner = new Scanner(maxGray);
                int maxVal = scanner.nextInt();
                
                actualGrayPGM = maxVal;
                
                BufferedImage imageAux = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
                
                
                // Linha atual
                String currentLine;
                String scanCurrentLine[];
                
                
                // Contam a altura e a largura da imagem
                // Arquivos P2 possuem no máximo 70 caracteres por linha
                int flagX = 0;
                // flagCount
                int flagY = 0;
                // pixel atual
                
                int pixel;
                
                // contas quantos elemento tem
                int countElement = 0;
                        
                while(countElement < width * height) {
                    
                    
                    //Lê a próxima linha
                    currentLine = data.readLine();
                    scanCurrentLine = currentLine.split(" ");
                    
                
                    // Elementos da lista
                     // Lê um elemento
                    for(String element: scanCurrentLine) {
                        
                        if(!element.matches("[0-9]+"))
                            continue;
                        
                        // Captura o pixel atual - clarificando o código - 255 é o máximo do RGB
                        pixel = convertGray(Integer.parseInt(element), maxVal, 255); 
                        if(pixel > 255)
                            System.out.print(pixel + " X " + flagX + " Y " + flagY + " element = " + element);

                        int R = pixel;
                        int G = pixel;
                        int B = pixel;
                        
                        Color color = new Color(R, G, B);
                        
                        imageAux.setRGB(flagY, flagX, color.getRGB());
                        
                        // Percorre a largura
                        flagY++; 
                        // Elemento adicionado
                        countElement++;
                         // Se percorreu uma linha inteiro
                        if(flagY == width) {
                            //System.out.println("");
                            //System.out.println("flagX "+ (flagX) + " flagY " + flagY);
                            flagX++;
                            flagY = 0;
                        }
                    }
                }
                
                setMainImage(imageAux);
                this.mainImageOriginal =  BufferedImageController.clone(imageAux);
                this.mainImageUndo = BufferedImageController.clone(imageAux);
                System.out.println("type " + mainImage.getType());
                setMainImage(imageAux);
                        
                //BufferedImage imagemAux = new BufferedImage(width, height, type);
	    
            }
	    catch(IOException e){
		System.out.println("Erro IO Exception! Verifique se o arquivo especificado existe e tente novamente.");
	    }
            catch(ArrayIndexOutOfBoundsException ex) {
                System.out.println("Fora do tamanho: " + ex.getMessage());
            }
                
    
    }
   
    // Regra de três para converter
    private int convertGray(int pixel, int currentMaxVal, int actualGray) {
        // Pixel está para maxVal
        // assim como X está para actualGray
        return (pixel * actualGray) / currentMaxVal;
    }
    
    private void sobrepor() {
        //C = c1*(1-α) + c2*α;
        
        //this.mainImage = BufferedImageController.clone(mainImageUndo);
        BufferedImage imagemCopy = BufferedImageController.clone((BufferedImage) mainImageUndo);
        
        int width = imagemCopy.getWidth();
	int height = imagemCopy.getHeight();
        int type = imagemCopy.getType();
        
        if(this.imagemSobrepor.getHeight() != height || this.imagemSobrepor.getWidth() != width){
            JOptionPane.showMessageDialog(null, "Imagens possuem tamanhos diferentes", "Erro!", ERROR_MESSAGE);
            this.jSAlpha.setEnabled(false);
            jMISobrepor.setEnabled(false);
            return;
        }
        
        BufferedImage imagemAux = new BufferedImage(width, height, type);
        
        
	for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) { 	
                
		Color corI1 = new Color(imagemCopy.getRGB(i, j));
                Color corIS = new Color(imagemSobrepor.getRGB(i, j));
                int R = (int) (corI1.getRed()   * (1 - alpha) + corIS.getRed()      * alpha );
                int G = (int) (corI1.getGreen() * (1 - alpha) + corIS.getGreen()    * alpha );
                int B = (int) (corI1.getBlue()  * (1 - alpha) + corIS.getBlue()     * alpha );
                

                Color color = new Color(R, G, B);

                imagemAux.setRGB(i, j, color.getRGB());
	    }
        }
        //this.imageUpdate(mainImage, ALLBITS, 0, 0, width, height);
        setMainImage(imagemAux);
        
        
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new guiImageOperations().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLAlphaIndex;
    private javax.swing.JLabel jLImage;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMIAbrirPGM;
    private javax.swing.JMenuItem jMIAmpliar;
    private javax.swing.JMenuItem jMIBlue;
    private javax.swing.JMenuItem jMIErosao;
    private javax.swing.JMenuItem jMIEscalaCinza;
    private javax.swing.JMenuItem jMIEspelhoHorizontal;
    private javax.swing.JMenuItem jMIEspelhoVertical;
    private javax.swing.JMenuItem jMIFiltroGaussiano3;
    private javax.swing.JMenuItem jMIFiltroGaussiano5;
    private javax.swing.JMenuItem jMIFiltroMedia;
    private javax.swing.JMenuItem jMIGama;
    private javax.swing.JMenuItem jMIGreen;
    private javax.swing.JMenuItem jMILaplaciano;
    private javax.swing.JMenuItem jMIMediana;
    private javax.swing.JMenuItem jMIOpenImage;
    private javax.swing.JMenuItem jMIPrewittHorizontal;
    private javax.swing.JMenuItem jMIPrewittVertical;
    private javax.swing.JMenuItem jMIRed;
    private javax.swing.JMenuItem jMIReducao;
    private javax.swing.JMenuItem jMIReset;
    private javax.swing.JMenuItem jMIRetanguloRecorte;
    private javax.swing.JMenuItem jMIRotDir;
    private javax.swing.JMenuItem jMIRotEsq;
    private javax.swing.JMenuItem jMISI;
    private javax.swing.JMenuItem jMISaltAndPepper;
    private javax.swing.JMenuItem jMISalvarPGM;
    private javax.swing.JMenuItem jMISepia;
    private javax.swing.JMenuItem jMISharpen;
    private javax.swing.JMenuItem jMISobrepor;
    private javax.swing.JMenuItem jMISwirl;
    private javax.swing.JMenuItem jMNegativo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPImage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSlider jSAlpha;
    // End of variables declaration//GEN-END:variables

    
}
