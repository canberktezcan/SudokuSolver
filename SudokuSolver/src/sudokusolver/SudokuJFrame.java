/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusolver;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class SudokuJFrame extends javax.swing.JFrame {
     public   int[][] matris1 = new int [9][9];
     public   int[][] matris2 = new int [9][9];
     public   int[][] matris3 = new int [9][9];
     public   int[][] matris4 = new int [9][9];
     public   int[][] matris5 = new int [9][9];
 
    public SudokuJFrame(int[][] matris1,int[][] matris2,int[][] matris3,int[][] matris4,int[][] matris5) {
        this.matris1=matris1;
        this.matris2=matris2;
        this.matris3=matris3;
        this.matris4=matris4;
        this.matris5=matris5;
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 918, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 627, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paint (Graphics g) {
    super.paint(g);
    Graphics2D g2d =(Graphics2D) g;
    g2d.translate(50, 35);
    for(int x=0; x<9;x++) {
			for(int y=0;y<9;y++) {
                        g2d.setColor(Color.white);//mat1
			g2d.fillRect(30+(y*30), 30+(x*30), 30,30);                
                        g2d.setColor(Color.BLACK);
                        g2d.drawRect(30+(y*30), 30+(x*30), 30, 30);
                        
                        g2d.setColor(Color.white);//mat2 
			g2d.fillRect(390+(y*30), 30+(x*30), 30,30);               
                        g2d.setColor(Color.BLACK);
                        g2d.drawRect(390+(y*30), 30+(x*30), 30, 30);
                        
                        g2d.setColor(Color.white);//mat3
			g2d.fillRect(210+(y*30), 210+(x*30), 30,30);                
                        g2d.setColor(Color.BLACK);
                        g2d.drawRect(210+(y*30), 210+(x*30), 30, 30); 

                        g2d.setColor(Color.white);//mat4
			g2d.fillRect(30+(y*30), 390+(x*30), 30,30);  
                        g2d.setColor(Color.BLACK);
                        g2d.drawRect(30+(y*30), 390+(x*30), 30, 30);
                        
                        g2d.setColor(Color.white);//mat5 
                        g2d.fillRect(390+(y*30), 390+(x*30), 30,30);
                        g2d.setColor(Color.BLACK);
                        g2d.drawRect(390+(y*30), 390+(x*30), 30, 30);
			}
		}  
    for(int k=0;k<9;k++){
    for(int l=0;l<9;l++){
        if(this.matris1[l][k]!=0){
      g.setColor(Color.BLACK);
         g.drawString(String.valueOf(this.matris1[l][k]), 40+(k*30), 50+(l*30)); 
        }
    if(this.matris2[l][k]!=0){
      g.setColor(Color.BLACK);
         g.drawString(String.valueOf(this.matris2[l][k]), 400+(k*30), 50+(l*30)); 
        }
    
    if(this.matris3[l][k]!=0){
      g.setColor(Color.BLACK);
         g.drawString(String.valueOf(this.matris3[l][k]), 220+(k*30), 230+(l*30)); 
        }
    if(this.matris4[l][k]!=0){
      g.setColor(Color.BLACK);
         g.drawString(String.valueOf(this.matris4[l][k]), 40+(k*30), 410+(l*30)); 
        }
    if(this.matris5[l][k]!=0){
      g.setColor(Color.BLACK);
         g.drawString(String.valueOf(this.matris5[l][k]), 400+(k*30), 410+(l*30)); 
        }
    
    
    
    }
   
    
    }
     
    // Variables declaration - do not modify                     
    // End of variables declaration                   
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
