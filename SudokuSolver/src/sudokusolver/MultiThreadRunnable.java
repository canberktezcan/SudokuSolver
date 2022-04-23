/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusolver;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Canberk
 */
public class MultiThreadRunnable implements Runnable {

    private static final int GRID_SIZE = 9;
    private int[][] board;
    private int[][] board2;
    private int[][] samurai;
    private int sudokuNumber;

    public MultiThreadRunnable(int[][] board, int[][] board2, int sudokuNumber) {
        this.board = board;
        this.board2 = board2;
        this.sudokuNumber = sudokuNumber;
    }

    public MultiThreadRunnable(int[][] board, int sudokuNumber) {
        this.board = board;
        this.sudokuNumber = sudokuNumber;

    }

    @Override
    public void run() {
        
        System.out.println(Thread.currentThread().getName() + "AND ITS WORKING...");
        if (board2 != null) {
            if (solveBoardikili(board, board2, sudokuNumber)) {

                System.out.println("cozuldu");

                printboard(board);
                //  printsamurai(samurai);

            } else {
                System.out.println("no");
            }
        } else {
            if (solveBoard(board)) {
                System.out.println("cozuldu");

                printboard(board);
                //printsamurai(samurai);
            } else {
                System.out.println("no");
            }
        }
    }
  private static void printboard(int[][] board) {
  
        System.out.println();
        for (int row = 0; row <GRID_SIZE ; row++) {
            if(row %3 == 0 && row !=0){
                System.out.println("-----------");
            }
            for (int column = 0; column < GRID_SIZE; column++) {
                if(column % 3 == 0 && column != 0){
                    System.out.print("|");
                }
                System.out.print(board[row][column]);
            }
            System.out.println();
        }

    }
    private static void printsamurai (int [][] samurai){
        
         System.out.println();
        for (int row = 0; row <21 ; row++) {
            if(row %3 == 0 && row !=0){
                System.out.println("-----------");
            }
            for (int column = 0; column < 21; column++) {
                if(column % 3 == 0 && column != 0){
                    System.out.print("|");
                }
                System.out.print(samurai[row][column]);
            }
            System.out.println();
        }

        
        
    }

    private static boolean isNumberInRow(int[][] board, int number, int row){
        for (int i = 0; i < GRID_SIZE ; i++){
            if (board[row][i] == number){
                return true;
            }
        }
        return false;
    }


    private static boolean isNumberInColumn(int[][] board, int number, int column){
        for (int i = 0; i < GRID_SIZE ; i++){
            if (board[i][column] == number){
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] board, int number, int row , int column){
       int localBoxRow = row - row % 3;
       int localBoxColumn = column - column % 3;

        for (int i = localBoxRow; i <localBoxRow + 3 ; i++) {
            for (int j = localBoxColumn; j <localBoxColumn + 3 ; j++) {
                if(board[i][j] == number){
                    return true;
                }
            }
        }
        return  false;
    }


    private static  boolean isValidPlacement(int [][] board, int number , int row , int column){

        return  !isNumberInRow(board,number,row) &&
                !isNumberInColumn(board,number,column) &&
                !isNumberInBox(board,number,row,column);
    }

    private static boolean solveBoard(int board[][]){

        
            for (int row = 0; row <GRID_SIZE;row++){
            for (int column = 0; column < GRID_SIZE; column++) {
                if(board[row][column] == 0){
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if(isValidPlacement(board,numberToTry,row,column)){
                            board[row][column] = numberToTry;
                           // samurai[row+6][column+6] = numberToTry;

                            if(solveBoard(board)){
                                
                                return  true;
                            }
                            else {
                                board[row][column] = 0;
                                //samurai[row+6][column+6] = 0;
                            }
                        }
                    }
                    return  false;
                }
            }
        }
           // System.out.println("thread number is :"+sudokuNumber);
        return true ;
        

    }
    
    
    
    
     private static boolean solveBoardikili(int board[][], int board2[][], int sudokuNumber) {
        if (sudokuNumber == 1) {

            for (int row = 8; row >=0 ;row--) {
                for (int column = 8; column >= 0; column--) {
                    if (board[row][column] == 0) {
                        if (row >= 6 && column >= 6) {

                            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                if (isValidPlacement(board, numberToTry, row, column) && isValidPlacement(board2, numberToTry, row - 6, column - 6)) {

                                    board[row][column] = numberToTry;
                                    board2[row - 6][column - 6] = numberToTry;
                                   //samurai[row][column] = numberToTry;

                                    if (solveBoardikili(board, board2, sudokuNumber)) {
                                        return true;
                                    } else {
                                        board[row][column] = 0;
                                        board2[row-6][column-6] = 0;
                                   //     samurai[row][column] = 0;
                                    }
                                }
                            }
                            return false;


                        } else {
                            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                if (isValidPlacement(board, numberToTry, row, column)) {
                                    board[row][column] = numberToTry;
                                   // samurai[row][column] = numberToTry;

                                    if (solveBoardikili(board, board2, sudokuNumber)) {                                       
                                        return true;
                                    } else {
                                        board[row][column] = 0;
                                        //samurai[row][column] = 0;
                                        


                                    }
                                }
                            }

                            return false;
                        }
                    }
                }
            }
             try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MultiThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("thread number is :"+sudokuNumber);
            return true;

        }
        else if(sudokuNumber == 2){
            
              for (int row = 8; row >=0; row--) {
                for (int column = 0; column < GRID_SIZE; column++) {
                    if (board[row][column] == 0) {
                        if (row >= 6 && column <= 2) {

                            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                if (isValidPlacement(board, numberToTry, row, column) && isValidPlacement(board2, numberToTry,row - 6 ,column + 6 )) {

                                    board[row][column] = numberToTry;
                                    board2[row-6][column+6] = numberToTry;
                                   // samurai[row][column+12] = numberToTry;

                                    if (solveBoardikili(board, board2, sudokuNumber)) {
                                        return true;
                                    } else {
                                        board[row][column] = 0;
                                        board2[row-6][column+6] = 0;
                                         //samurai[row][column+12] = 0;
                                    }
                                }
                            }
                            return false;


                        } else {
                            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                if (isValidPlacement(board, numberToTry, row, column)) {
                                    board[row][column] = numberToTry;
                                    // samurai[row][column+12] = numberToTry;

                                    if (solveBoardikili(board, board2, sudokuNumber)) {                                       
                                        return true;
                                    } else {
                                        board[row][column] = 0;
                                        
                                        


                                    }
                                }
                            }

                            return false;
                        }
                    }
                }
            }
               try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MultiThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("thread number is :"+sudokuNumber);
            return true;                   
        }
        switch (sudokuNumber) {
            case 3:
                for (int row = 0; row <GRID_SIZE; row++) {
                    for (int column = 0; column<GRID_SIZE; column++) {
                        if (board[row][column] == 0) {
                            if (row <= 2 && column >= 6) {
                                
                                for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                    if (isValidPlacement(board, numberToTry, row, column) && isValidPlacement(board2, numberToTry, row + 6, column - 6)) {
                                        
                                        board[row][column] = numberToTry;
                                        board2[row + 6][column - 6] = numberToTry;
                                        //  samurai[row+12][column] = numberToTry;
                                        
                                        if (solveBoardikili(board, board2, sudokuNumber)) {
                                            
                                            return true;
                                        } else {
                                            board[row][column] = 0;
                                            board2[row+6][column-6] = 0;
                                            //samurai[row+12][column] =  0;
                                        }
                                    }
                                }
                                return false;
                                
                                
                            } else {
                                for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                    if (isValidPlacement(board, numberToTry, row, column)) {
                                        board[row][column] = numberToTry;
                                        //samurai[row+12][column] =  numberToTry;
                                        
                                        if (solveBoardikili(board, board2, sudokuNumber)) {
                                            
                                            return true;
                                        } else {
                                            board[row][column] = 0;
                                            // samurai[row+12][column] = 0;
                                        }
                                    }
                                }
                                return false;
                            }
                        }
                    }
                }
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MultiThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                System.out.println("thread number is :"+sudokuNumber);
                return true;
            case 4:
                for (int row = 0; row <GRID_SIZE; row++) {
                    for (int column = 0; column < GRID_SIZE; column++) {
                        if (board[row][column] == 0) {
                            if (row <= 2 && column <= 2) {
                                
                                for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                    if (isValidPlacement(board, numberToTry, row, column) && isValidPlacement(board2, numberToTry, row + 6, column + 6)) {
                                        
                                        board[row][column] = numberToTry;
                                        board2[row + 6][column + 6] = numberToTry;
                                        //  samurai[row+12][column+12] = numberToTry;
                                        
                                        if (solveBoardikili(board, board2, sudokuNumber)) {
                                            
                                            return true;
                                        } else {
                                            board[row][column] = 0;
                                            board2[row+6][column+6] = 0;
                                            //   samurai[row+12][column+12] = 0;
                                        }
                                    }
                                }
                                return false;
                                
                                
                            } else {
                                for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                    if (isValidPlacement(board, numberToTry, row, column)) {
                                        board[row][column] = numberToTry;
                                        //  samurai[row+12][column+12] = numberToTry;
                                        if (solveBoardikili(board, board2, sudokuNumber)) {
                                            
                                            return true;
                                        } else {
                                            board[row][column] = 0;
                                            // samurai[row+12][column+12] = 0;
                                        }
                                    }
                                }
                                return false;
                            }
                        }
                    }
                }
                 try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MultiThread.class.getName()).log(Level.SEVERE, null, ex);
            }
                System.out.println("thread number is :"+sudokuNumber);
                return true;
            case 5:
                for (int row = 0; row <GRID_SIZE; row++) {
                    for (int column = 0; column < GRID_SIZE; column++) {
                        if (board[row][column] == 0) {
                            if (row <= 2 && column <= 2) {
                                
                                for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                    if (isValidPlacement(board, numberToTry, row, column) && isValidPlacement(board2, numberToTry, row + 6, column + 6)) {
                                        
                                        board[row][column] = numberToTry;
                                        board2[row + 6][column + 6] = numberToTry;
                                        // samurai[row+6][column+6] = numberToTry;
                                        
                                        if (solveBoardikili(board, board2, sudokuNumber)) {
                                            
                                            return true;
                                        } else {
                                            board[row][column] = 0;
                                            board2[row+6][column+6] = 0;
                                            //samurai[row+6][column+6] = 0;
                                        }
                                    }
                                }
                                return false;
                                
                                
                            } else {
                                for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                    if (isValidPlacement(board, numberToTry, row, column)) {
                                        board[row][column] = numberToTry;
                                        
                                        if (solveBoardikili(board, board2, sudokuNumber)) {
                                            
                                            return true;
                                        } else {
                                            board[row][column] = 0;
                                            // samurai[row+6][column+6] = 0;
                                        }
                                    }
                                }
                                return false;
                            }
                        }
                    }
                }
                 try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MultiThread.class.getName()).log(Level.SEVERE, null, ex);
            }
                System.out.println("thread number is :"+sudokuNumber);
                return true;
            default:
                return false;
        }
        
   }

}
