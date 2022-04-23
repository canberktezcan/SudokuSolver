package sudokusolver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SudokuSolver {

    private static final int GRID_SIZE = 9;
    int[][] matris1 = new int [9][9];
        int[][] matris2 = new int [9][9];
        int[][] matris3 = new int [9][9];
        int[][] matris4 = new int [9][9];
        int[][] matris5 = new int [9][9];

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
       File file = new File("txt.txt");

        FileReader fReader = new FileReader(file);
        
        String satir;
        String ifade;
    int i=0,j=0;
    int a;
        BufferedReader bReader = new BufferedReader(fReader);
        int[][] matris1 = new int [9][9];
        int[][] matris2 = new int [9][9];
        int[][] matris3 = new int [9][9];
        int[][] matris4 = new int [9][9];
        int[][] matris5 = new int [9][9];
        
        
        
        
        try{
        
             satir = bReader.readLine();
         int satirsayisi=1;
         while(satir!=null) {
             if(satirsayisi<7){
             ifade = satir.substring(0,9);
             for(j=0;j<9;j++){
               if(ifade.charAt(j) == '*'){
                a =0;
                    matris1[satirsayisi-1][j] = a;
                   
               
               }
               else{
               a = Character.getNumericValue(ifade.charAt(j));
                    matris1[satirsayisi-1][j] = a;
                    
               
               }
               
               }
             ifade = satir.substring(9,18);
             for(j=0;j<9;j++){
               if(ifade.charAt(j) == '*'){
                a =0;
                    matris2[satirsayisi-1][j] = a;
                   
               
               }
               else{
               a = Character.getNumericValue(ifade.charAt(j));
                    matris2[satirsayisi-1][j] = a;
                    
               
               }
               
               }
             
             }
             
             else if(satirsayisi>6 && satirsayisi<10){
             ifade = satir.substring(0,9);
             for(j=0;j<9;j++){
               if(ifade.charAt(j) == '*'){
                a =0;
                    matris1[satirsayisi-1][j] = a;
                   
               
               }
               else{
               a = Character.getNumericValue(ifade.charAt(j));
                    matris1[satirsayisi-1][j] = a;
                    
               
               }
               
               }
             ifade=satir.substring(6,15);
             for(j=0;j<9;j++){
               if(ifade.charAt(j) == '*'){
                a =0;
                    matris3[satirsayisi-7][j] = a;
                   
               
               }
               else{
               a = Character.getNumericValue(ifade.charAt(j));
                    matris3[satirsayisi-7][j] = a;
                    
               
               }
             }
                ifade = satir.substring(12,21);
             for(j=0;j<9;j++){
               if(ifade.charAt(j) == '*'){
                a =0;
                    matris2[satirsayisi-1][j] = a;
                   
               
               }
               else{
               a = Character.getNumericValue(ifade.charAt(j));
                    matris2[satirsayisi-1][j] = a;
                    
               
               }
               
               
               
             
             }
             
         } //satir 6 ile 10 arasındaysa parantezi
        
             else if(satirsayisi>9 && satirsayisi<13){
             ifade = satir.substring(0,9);
             for(j=0;j<9;j++){
               if(ifade.charAt(j) == '*'){
                a =0;
                    matris3[satirsayisi-7][j] = a;
                   
               
               }
               else{
               a = Character.getNumericValue(ifade.charAt(j));
                    matris3[satirsayisi-7][j] = a;
                    
               
               }
               
               }
             
             
             } //satir 9 la 13 arasındaysa parantezi
             
             if(satirsayisi>12 && satirsayisi < 16){
             
             ifade = satir.substring(0,9);
             for(j=0;j<9;j++){
               if(ifade.charAt(j) == '*'){
                a =0;
                    matris4[satirsayisi-13][j] = a;
                   
               
               }
               else{
               a = Character.getNumericValue(ifade.charAt(j));
                    matris4[satirsayisi-13][j] = a;
                    
               
               }
               
               }
             ifade=satir.substring(6,15);
             for(j=0;j<9;j++){
               if(ifade.charAt(j) == '*'){
                a =0;
                    matris3[satirsayisi-7][j] = a;
                   
               
               }
               else{
               a = Character.getNumericValue(ifade.charAt(j));
                    matris3[satirsayisi-7][j] = a;
                    
               
               }
             }
                ifade = satir.substring(12,21);
             for(j=0;j<9;j++){
               if(ifade.charAt(j) == '*'){
                a =0;
                    matris5[satirsayisi-13][j] = a;
                   
               
               }
               else{
               a = Character.getNumericValue(ifade.charAt(j));
                    matris5[satirsayisi-13][j] = a;
                    
               
               }
               
               
               
             
             }
                 
                 
                 
                 
                 
             } // satir 12 ile 16 arasındaysa parantezi
             
             if(satirsayisi>15 && satirsayisi<22){
             
             ifade = satir.substring(0,9);
             for(j=0;j<9;j++){
               if(ifade.charAt(j) == '*'){
                a =0;
                    matris4[satirsayisi-13][j] = a;
                   
               
               }
               else{
               a = Character.getNumericValue(ifade.charAt(j));
                    matris4[satirsayisi-13][j] = a;
                    
               
               }
               
               }
             ifade = satir.substring(9,18);
             for(j=0;j<9;j++){
               if(ifade.charAt(j) == '*'){
                a =0;
                    matris5[satirsayisi-13][j] = a;
                   
               
               }
               else{
               a = Character.getNumericValue(ifade.charAt(j));
                    matris5[satirsayisi-13][j] = a;
                    
               
               }
               
               }
             
             
             
             
             
             
             
             
             
             
             } //satirsayisi 15 le 21 arası parantezi
             
             
             satir = bReader.readLine();
             satirsayisi++;
             
         } //okuma whileı parantezi
            
            
         
         
            
        //tryın parantezi altta
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        
        int[][] solust = {
            {0, 0, 5, 7, 0, 0, 0, 2, 0},
            {4, 9, 0, 0, 6, 0, 0, 1, 0},
            {0, 0, 7, 0, 0, 4, 9, 0, 6},
            {0, 0, 6, 0, 0, 0, 0, 0, 8},
            {0, 7, 0, 0, 0, 0, 0, 9, 0},
            {2, 0, 0, 0, 0, 0, 3, 0, 0},
            {5, 0, 8, 9, 0, 0, 7, 0, 0},
            {0, 1, 0, 0, 3, 0, 0, 8, 5},
            {0, 2, 0, 0, 0, 5, 6, 0, 0},};
        int[][] sagust = {
            {0, 0, 9, 6, 0, 0, 0, 2, 0},
            {1, 4, 0, 0, 5, 0, 0, 3, 0},
            {0, 0, 2, 0, 0, 1, 7, 0, 8},
            {0, 0, 3, 0, 0, 0, 0, 0, 2},
            {0, 5, 0, 0, 0, 0, 0, 6, 0},
            {4, 0, 0, 0, 0, 0, 5, 0, 0},
            {6, 0, 5, 8, 0, 0, 2, 0, 0},
            {0, 1, 0, 0, 7, 0, 0, 8, 6},
            {0, 2, 0, 0, 0, 4, 3, 0, 0},};

        int[][] orta = {
            {7, 4, 1, 0, 0, 0, 6, 9, 5},
            {2, 8, 5, 0, 0, 0, 3, 1, 4},
            {6, 3, 9, 0, 1, 0, 8, 2, 7},
            {0, 0, 0, 4, 0, 6, 0, 0, 0},
            {0, 0, 6, 0, 5, 0, 2, 0, 0},
            {0, 0, 0, 2, 0, 8, 0, 0, 0},
            {4, 2, 7, 0, 3, 0, 1, 5, 8},
            {1, 5, 8, 0, 0, 0, 9, 6, 3},
            {9, 6, 3, 0, 0, 0, 4, 7, 2},};

        int[][] solalt = {
            {0, 0, 8, 5, 0, 0, 0, 2, 0},
            {6, 2, 0, 0, 4, 0, 0, 5, 0},
            {0, 0, 7, 0, 0, 8, 9, 0, 3},
            {0, 0, 6, 0, 0, 0, 0, 0, 2},
            {0, 5, 0, 0, 0, 0, 0, 4, 0},
            {8, 0, 0, 0, 0, 0, 3, 0, 0},
            {1, 0, 5, 9, 0, 0, 2, 0, 0},
            {0, 3, 0, 0, 6, 0, 0, 7, 1},
            {0, 6, 0, 0, 0, 3, 5, 0, 0},};

        int[][] sagalt = {
            {0, 0, 8, 9, 0, 0, 0, 6, 0},
            {9, 6, 0, 0, 2, 0, 0, 5, 0},
            {0, 0, 2, 0, 0, 8, 1, 0, 9},
            {0, 0, 1, 0, 0, 0, 0, 0, 6},
            {0, 8, 0, 0, 0, 0, 0, 2, 0},
            {7, 0, 0, 0, 0, 0, 5, 0, 0},
            {2, 0, 6, 7, 0, 0, 4, 0, 0},
            {0, 3, 0, 0, 9, 0, 0, 7, 8},
            {0, 9, 0, 0, 0, 4, 2, 0, 0},};

        
        
        
        
        int[][] solust2 = {
            {4, 1, 0, 0, 3, 0, 0, 5, 6},
            {6, 0, 9, 5, 0, 1, 7, 0, 2},
            {0, 5, 0, 0, 0, 0, 0, 8, 0},
            {0, 4, 0, 0, 0, 0, 0, 9, 0},
            {9, 0, 0, 0, 0, 0, 0, 0, 4},
            {0, 8, 0, 0, 0, 0, 0, 3, 0},
            {0, 7, 0, 0, 0, 0, 0, 6, 0},
            {2, 0, 4, 3, 0, 7, 8, 0, 5},
            {8, 9, 0, 0, 6, 0, 0, 2, 7},};
        int[][] sagust2 = {
            {6, 2, 0, 0, 9, 0, 0, 1, 7},
            {7, 0, 3, 5, 0, 1, 8, 0, 2},
            {0, 8, 0, 0, 0, 0, 0, 3, 0},
            {0, 6, 0, 0, 0, 0, 0, 7, 0},
            {2, 0, 0, 0, 0, 0, 0, 0, 4},
            {0, 1, 0, 0, 0, 0, 0, 8, 0},
            {0, 7, 0, 0, 0, 0, 0, 2, 0},
            {9, 0, 2, 7, 0, 8, 1, 0, 6},
            {8, 3, 0, 0, 5, 0, 0, 4, 9},};

        int[][] orta2 = {
            {0, 6, 0, 0, 0, 0, 0, 7, 0},
            {8, 0, 5, 0, 0, 0, 9, 0, 2},
            {0, 2, 7, 0, 0, 0, 8, 3, 0},
            {0, 0, 0, 4, 0, 3, 0, 0, 0},
            {0, 0, 0, 0, 7, 0, 0, 0, 0},
            {0, 0, 0, 2, 0, 9, 0, 0, 0},
            {0, 7, 4, 0, 0, 0, 2, 8, 0},
            {2, 0, 6, 0, 0, 0, 3, 0, 7},
            {0, 3, 0, 0, 0, 0, 0, 6, 0},};

        int[][] solalt2 = {
            {8, 9, 0, 0, 3, 0, 0, 7, 4},
            {3, 0, 4, 5, 0, 8, 2, 0, 6},
            {0, 6, 0, 0, 0, 0, 0, 3, 0},
            {0, 5, 0, 0, 0, 0, 0, 4, 0},
            {6, 0, 0, 0, 0, 0, 0, 0, 5},
            {0, 8, 0, 0, 0, 0, 0, 2, 0},
            {0, 2, 0, 0, 0, 0, 0, 5, 0},
            {5, 0, 9, 6, 0, 2, 7, 0, 3},
            {1, 3, 0, 0, 4, 0, 0, 6, 2},};

        int[][] sagalt2 = {
            {2, 8, 0, 0, 9, 0, 0, 4, 6},
            {3, 0, 7, 6, 0, 4, 9, 0, 2},
            {0, 6, 0, 0, 0, 0, 0, 5, 0},
            {0, 5, 0, 0, 0, 0, 0, 7, 0},
            {6, 0, 0, 0, 0, 0, 0, 0, 3},
            {0, 4, 0, 0, 0, 0, 0, 1, 0},
            {0, 2, 0, 0, 0, 0, 0, 6, 0},
            {7, 0, 6, 8, 0, 5, 2, 0, 4},
            {8, 3, 0, 0, 7, 0, 0, 9, 5},};

        int[][] samurai = {
            {4, 1, 0, 0, 3, 0, 0, 5, 6, 0, 0, 0, 6, 2, 0, 0, 9, 0, 0, 1, 7},
            {6, 0, 9, 5, 0, 1, 7, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 5, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 3, 0},
            {0, 4, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 7, 0},
            {9, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 4},
            {0, 8, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 8, 0},
            {0, 7, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 2, 0},
            {2, 0, 4, 3, 0, 7, 8, 0, 5, 0, 0, 0, 9, 0, 2, 7, 0, 8, 1, 0, 6},
            {8, 9, 0, 0, 6, 0, 0, 2, 7, 0, 0, 0, 8, 3, 0, 0, 5, 0, 0, 4, 9},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4, 0, 0, 0, 2, 8, 0, 0, 0, 0, 0, 0, 0},
            {8, 9, 0, 0, 3, 0, 0, 7, 4, 0, 0, 0, 2, 8, 0, 0, 9, 0, 0, 4, 6},
            {3, 0, 4, 5, 0, 8, 2, 0, 6, 0, 0, 0, 3, 0, 7, 6, 0, 4, 9, 0, 2},
            {0, 6, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 5, 0},
            {0, 5, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 7, 0},
            {6, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 3},
            {0, 8, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 1, 0},
            {0, 2, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 6, 0},
            {5, 0, 9, 6, 0, 2, 7, 0, 3, 0, 0, 0, 7, 0, 6, 8, 0, 5, 2, 0, 4},
            {1, 3, 0, 0, 4, 0, 0, 6, 2, 0, 0, 0, 8, 3, 0, 0, 7, 0, 0, 9, 5},};

       
        MultiThread t1 = new MultiThread(matris1, matris3, 1);
        MultiThread t2 = new MultiThread(matris2, matris3, 2);

        MultiThread t4 = new MultiThread(matris4, matris3, 4);

        MultiThread t5 = new MultiThread(matris5, matris3, 5);

        MultiThread t3 = new MultiThread(matris3,matris1,matris2,matris4,matris5,3);

        
        
        MultiThread t11 = new MultiThread(matris1, matris3, 11);
        MultiThread t22 = new MultiThread(matris2, matris3, 22);

        MultiThread t44 = new MultiThread(matris4, matris3, 44);

        MultiThread t55 = new MultiThread(matris5, matris3, 55);

        MultiThread t33 = new MultiThread(matris3,matris1,matris2,matris4,matris5,33);

        
        
        
      t1.setPriority(10);
      t2.setPriority(10);
      t4.setPriority(10);
      t5.setPriority(10);
      t3.setPriority(1);
      
      t11.setPriority(10);
      t22.setPriority(10);
      t44.setPriority(10);
      t55.setPriority(10);
      t33.setPriority(1);
      
      
//      
     
      new Thread(new Runnable() {
        public void run(){
               
              //  t1.start();
//                t11.start();
//                
//               // t2.start(); 
//                t22.start();
//                
//               // t4.start(); 
//                t44.start(); 
//                
//             //   t5.start();  
//                t55.start();
//                
              //  t3.start();  
                t33.start();
 
            }
         }).start();
      

      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SudokuSolver.class.getName()).log(Level.SEVERE, null, ex);
                }
                new SudokuJFrame(matris1,matris2,matris3,matris4,matris5).setVisible(true);
                
            }
        });
        
        
        
//         t1.join();
//       t2.join();
//       t3.join();
//       t4.join();
//        t5.join();

//         MultiThreadRunnable run1 = new MultiThreadRunnable(solust, orta,1);
//         Thread thread = new Thread(run1);    
//         thread.start();
//         
//         
//        MultiThreadRunnable run2 = new MultiThreadRunnable(sagust, orta,2);
//         Thread thread2 = new Thread(run2);    
//         thread2.start();
//         
//          MultiThreadRunnable run3 = new MultiThreadRunnable(solalt, orta,3);
//         Thread thread3 = new Thread(run3);    
//         thread3.start();
//         
//         
//        MultiThreadRunnable run4 = new MultiThreadRunnable(sagalt, orta,4);
//         Thread thread4 = new Thread(run4);    
//         thread4.start();
//         
//         
//         
//        MultiThreadRunnable run5 = new MultiThreadRunnable(orta,solust,5);
//         Thread thread5 = new Thread(run5);    
//         thread5.start();
//        
//        
// t1.join();
        // t2.join();
        //
//         t3.join();     
//         
        //
//        
        //t1.setPriority(10);t2.setPriority(9);t3.setPriority(8);t4.setPriority(7);
        //t1.join();
        //t2.join();
        //
        //t4.join();
        // 
        /*
       
       
       // t1.join();
        
       // t2.join();
         t3.start();
         //t3.join();
         t4.start();
        // t4.join();
       // 
       /* t2.join();
        t3.start();
        t3.join();
        
        t4.join();
        t5.start();
        t21.start();*/
    }

}

