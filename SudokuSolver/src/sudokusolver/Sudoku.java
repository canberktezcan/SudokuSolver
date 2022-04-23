/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusolver;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Sudoku  extends Thread{
   

  // Grid size
  private static final int SIZE = 9;
  // Box size
  private static final int BOX_SIZE = 3;
  private static final int EMPTY_CELL = 0;
  // 4 constraints : cell, line, column, boxes
  private static final int CONSTRAINTS = 4;
  // Values for each cells
  private static final int MIN_VALUE = 1;
  private static final int MAX_VALUE = SIZE;
  // Starting index for cover matrix
  private static final int COVER_START_INDEX = 1;

    private static int FirstFactorial(int num) {
      int  sum=1;
    for(int i = num;i>0;i--){

        sum =sum*i;

    }


    return sum;  
        
    }

  private int[][] grid;
  private int[][] gridSolved;

  private static int [][] board = {
      {8, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 3, 6, 0, 0, 0, 0, 0},
      {0, 7, 0, 0, 9, 0, 2, 0, 0},
      {0, 5, 0, 0, 0, 7, 0, 0, 0},
      {0, 0, 0, 0, 4, 5, 7, 0, 0},
      {0, 0, 0, 1, 0, 0, 0, 3, 0},
      {0, 0, 1, 0, 0, 0, 0, 6, 8},
      {0, 0, 8, 5, 0, 0, 0, 1, 0},
      {0, 9, 0, 0, 0, 0, 4, 0, 0}
  };
  
 private static int [][] solust = {
            {0, 0, 5, 7, 0, 0, 0, 2, 0},
            {4, 9, 0, 0, 6, 0, 0, 1, 0},
            {0, 0, 7, 0, 0, 4, 9, 0, 6},
            {0, 0, 6, 0, 0, 0, 0, 0, 8},
            {0, 7, 0, 0, 0, 0, 0, 9, 0},
            {2, 0, 0, 0, 0, 0, 3, 0, 0},
            {5, 0, 8, 9, 0, 0, 7, 0, 0},
            {0, 1, 0, 0, 3, 0, 0, 8, 5},
            {0, 2, 0, 0, 0, 5, 6, 0, 0},};
   static     int[][] sagust = {
            {0, 0, 9, 6, 0, 0, 0, 2, 0},
            {1, 4, 0, 0, 5, 0, 0, 3, 0},
            {0, 0, 2, 0, 0, 1, 7, 0, 8},
            {0, 0, 3, 0, 0, 0, 0, 0, 2},
            {0, 5, 0, 0, 0, 0, 0, 6, 0},
            {4, 0, 0, 0, 0, 0, 5, 0, 0},
            {6, 0, 5, 8, 0, 0, 2, 0, 0},
            {0, 1, 0, 0, 7, 0, 0, 8, 6},
            {0, 2, 0, 0, 0, 4, 3, 0, 0},};

   private static int[][] orta = {
            {7, 0, 0, 0, 0, 0, 6, 0, 5},
            {0, 8, 5, 0, 0, 0, 0, 1, 0},
            {6, 0, 0, 0, 1, 0, 0, 2, 0},
            {0, 0, 0, 4, 0, 6, 0, 0, 0},
            {0, 0, 6, 0, 5, 0, 2, 0, 0},
            {0, 0, 0, 2, 0, 8, 0, 0, 0},
            {0, 2, 0, 0, 3, 0, 0, 0, 8},
            {0, 5, 0, 0, 0, 0, 9, 6, 0},
            {9, 0, 3, 0, 0, 0, 0, 0, 2},};
   static int[][] solalt = {
            {0, 0, 8, 5, 0, 0, 0, 2, 0},
            {6, 2, 0, 0, 4, 0, 0, 5, 0},
            {0, 0, 7, 0, 0, 8, 9, 0, 3},
            {0, 0, 6, 0, 0, 0, 0, 0, 2},
            {0, 5, 0, 0, 0, 0, 0, 4, 0},
            {8, 0, 0, 0, 0, 0, 3, 0, 0},
            {1, 0, 5, 9, 0, 0, 2, 0, 0},
            {0, 3, 0, 0, 6, 0, 0, 7, 1},
            {0, 6, 0, 0, 0, 3, 5, 0, 0},};

        static int[][] sagalt = {
            {0, 0, 8, 9, 0, 0, 0, 6, 0},
            {9, 6, 0, 0, 2, 0, 0, 5, 0},
            {0, 0, 2, 0, 0, 8, 1, 0, 9},
            {0, 0, 1, 0, 0, 0, 0, 0, 6},
            {0, 8, 0, 0, 0, 0, 0, 2, 0},
            {7, 0, 0, 0, 0, 0, 5, 0, 0},
            {2, 0, 6, 7, 0, 0, 4, 0, 0},
            {0, 3, 0, 0, 9, 0, 0, 7, 8},
            {0, 9, 0, 0, 0, 4, 2, 0, 0},};

           
  private static int [][] board2 = {
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
            {1, 3, 0, 0, 4, 0, 0, 6, 2, 0, 0, 0, 8, 3, 0, 0, 7, 0, 0, 9, 5},
  };
  
  
  public Sudoku(int[][] grid) {
    this.grid = new int[SIZE][SIZE];

    for (int i = 0; i < SIZE; i++)
      for (int j = 0; j < SIZE; j++)
        this.grid[i][j] = grid[i][j];
  }
  
  
  
    public static void main(String[] args) throws InterruptedException {

//              Sudoku t1 = new Sudoku(solust);
//              Sudoku t2 = new Sudoku(sagust);
//              Sudoku t3 = new Sudoku(solalt);
//              Sudoku t4 = new Sudoku(sagalt);
//              Sudoku t5 = new Sudoku(orta);
//              
//                 
//            
//              t1.start();
//              System.out.println("-------------------");
//               t2.start();
//               System.out.println("-------------------");
//              t3.start();
//              System.out.println("-------------------");
//              t4.start();;
//              System.out.println("-------------------");
//              t5.start();
//          
         

Scanner s = new Scanner(System.in);
    int num=4;
    int value=0;
    
    value = FirstFactorial(num); 
    //=FirstFactorial(num);
    System.out.print(value);


       
    }
    @Override
    public void run() {
        try { 
            System.out.println("Uzun işlem sonucu-- "+Thread.currentThread().getName() );
            // Burada uzun bir işlem yapılıyor.
           Thread.sleep(1000);
            solve();
           
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
    }

// ...

  // Index in the cover matrix
  private int indexInCoverMatrix(int row, int column, int num) {
    return (row - 1) * SIZE * SIZE + (column - 1) * SIZE + (num - 1);
  }

  // Building of an empty cover matrix
  private int[][] createCoverMatrix() {
    int[][] coverMatrix = new int[SIZE * SIZE * MAX_VALUE][SIZE * SIZE * CONSTRAINTS];

    int header = 0;
    header = createCellConstraints(coverMatrix, header);
    header = createRowConstraints(coverMatrix, header);
    header = createColumnConstraints(coverMatrix, header);
    createBoxConstraints(coverMatrix, header);

    return coverMatrix;
  }

  private int createBoxConstraints(int[][] matrix, int header) {
    for (int row = COVER_START_INDEX; row <= SIZE; row += BOX_SIZE) {
      for (int column = COVER_START_INDEX; column <= SIZE; column += BOX_SIZE) {
        for (int n = COVER_START_INDEX; n <= SIZE; n++, header++) {
          for (int rowDelta = 0; rowDelta < BOX_SIZE; rowDelta++) {
            for (int columnDelta = 0; columnDelta < BOX_SIZE; columnDelta++) {
              int index = indexInCoverMatrix(row + rowDelta, column + columnDelta, n);
              matrix[index][header] = 1;
            }
          }
        }
      }
    }
	
    return header;
  }

  private int createColumnConstraints(int[][] matrix, int header) {
    for (int column = COVER_START_INDEX; column <= SIZE; column++) {
      for (int n = COVER_START_INDEX; n <= SIZE; n++, header++) {
        for (int row = COVER_START_INDEX; row <= SIZE; row++) {
          int index = indexInCoverMatrix(row, column, n);
          matrix[index][header] = 1;
        }
      }
    }
	
    return header;
  }

  private int createRowConstraints(int[][] matrix, int header) {
    for (int row = COVER_START_INDEX; row <= SIZE; row++) {
      for (int n = COVER_START_INDEX; n <= SIZE; n++, header++) {
        for (int column = COVER_START_INDEX; column <= SIZE; column++) {
          int index = indexInCoverMatrix(row, column, n);
            matrix[index][header] = 1;
        }
      }
    }
	
    return header;
  }

  private int createCellConstraints(int[][] matrix, int header) {
    for (int row = COVER_START_INDEX; row <= SIZE; row++) {
      for (int column = COVER_START_INDEX; column <= SIZE; column++, header++) {
        for (int n = COVER_START_INDEX; n <= SIZE; n++) {
          int index = indexInCoverMatrix(row, column, n);
          matrix[index][header] = 1;
        }
      }
    }

    return header;
  }

  // Converting Sudoku grid as a cover matrix
  private int[][] convertInCoverMatrix(int[][] grid) {
    int[][] coverMatrix = createCoverMatrix();

    // Taking into account the values already entered in Sudoku's grid instance
    for (int row = COVER_START_INDEX; row <= SIZE; row++) {
      for (int column = COVER_START_INDEX; column <= SIZE; column++) {
        int n = grid[row - 1][column - 1];

        if (n != EMPTY_CELL) {
          for (int num = MIN_VALUE; num <= MAX_VALUE; num++) {
            if (num != n) {
              Arrays.fill(coverMatrix[indexInCoverMatrix(row, column, num)], 0);
            }
          }
        }
      }
    }

    return coverMatrix;
  }

private int[][] convertDLXListToGrid(List<DancingNode> answer) {
  int[][] result = new int[SIZE][SIZE];

  for (DancingNode n : answer) {
    DancingNode rcNode = n;
    int min = Integer.parseInt(rcNode.column.name);

    for (DancingNode tmp = n.right; tmp != n; tmp = tmp.right) {
      int val = Integer.parseInt(tmp.column.name);

      if (val < min) {
        min = val;
        rcNode = tmp;
      }
    }

    // we get line and column
    int ans1 = Integer.parseInt(rcNode.column.name);
    int ans2 = Integer.parseInt(rcNode.right.column.name);
    int r = ans1 / SIZE;
    int c = ans1 % SIZE;
    // and the affected value
    int num = (ans2 % SIZE) + 1;
    // we affect that on the result grid
    result[r][c] = num;
  }
  
  return result;
}


public void solve() {
    
    int[][] cover = convertInCoverMatrix(grid);
    //printCoverMatrix(cover);
    DLX dlx = new DLX(cover);
    dlx.solve();
    gridSolved = convertDLXListToGrid(dlx.result);
	displaySolution(gridSolved);
  }



public void displaySolution(int[][] result) {
     int size = result.length;
        for (int[] aResult : result) {
            StringBuilder ret = new StringBuilder();
            for (int j = 0; j < size; j++) {
                ret.append(aResult[j]).append(" ");
            }
            System.out.println(ret);
        }
        System.out.println();

    }










}

