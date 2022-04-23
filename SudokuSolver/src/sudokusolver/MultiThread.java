package sudokusolver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiThread extends Thread {

    private static final int GRID_SIZE = 9;
    private int[][] board;
    private int[][] board2;
    private int[][] board3;
    private int[][] board4;
    private int[][] board5;
     int sudokuNumber;

    public MultiThread(int[][] board, int[][] board2, int sudokuNumber) {
        this.board = board;
        this.board2 = board2;
        this.sudokuNumber = sudokuNumber;
    }

    public MultiThread(int[][] board, int[][] board2, int[][] board3, int[][] board4, int[][] board5, int sudokuNumber) {
        this.board = board;
        this.board2 = board2;
        this.board3 = board3;
        this.board4 = board4;
        this.board5 = board5;
        this.sudokuNumber = sudokuNumber;

    }

    @Override
    public void run() {

        if (sudokuNumber == 3 || sudokuNumber ==33) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MultiThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (solveBoardBesli(board, board2, board3, board4, board5, sudokuNumber)) {

                System.out.println("cozuldu");

                printboard(board);

            } else {
                System.out.println("no - " + sudokuNumber);
            }
        } else if (sudokuNumber > 10) {

            if (solveBoardikili(board, board2, sudokuNumber)) {

                System.out.println("cozuldu");

                printboard(board);
                //  printsamurai(samurai);

            } else {
                System.out.println("no - " + sudokuNumber);
            }

        } else {

            if (solveBoardikili(board, board2, sudokuNumber)) {

                System.out.println("cozuldu");

                printboard(board);
                //  printsamurai(samurai);

            } else {
                System.out.println("no - " + sudokuNumber);
            }

        }
    }

    private static synchronized void printboard(int[][] board) {

        System.out.println();
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("-----------");
            }
            for (int column = 0; column < GRID_SIZE; column++) {
                if (column % 3 == 0 && column != 0) {
                    System.out.print("|");
                }
                System.out.print(board[row][column]);
            }
            System.out.println();
        }

    }

    private static boolean isNumberInRow(int[][] board, int number, int row) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInColumn(int[][] board, int number, int column) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] board, int number, int row, int column) {
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;

        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPlacement(int[][] board, int number, int row, int column) {

        return !isNumberInRow(board, number, row)
                && !isNumberInColumn(board, number, column)
                && !isNumberInBox(board, number, row, column);
    }

    private static boolean solveBoard(int board[][]) {

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                if (board[row][column] == 0) {
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if (isValidPlacement(board, numberToTry, row, column)) {
                            board[row][column] = numberToTry;
                            // samurai[row+6][column+6] = numberToTry;

                            if (solveBoard(board)) {
                                return true;
                            } else {
                                board[row][column] = 0;
                                //samurai[row+6][column+6] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        // System.out.println("thread number is :"+sudokuNumber);
        return true;

    }

    private static boolean solveBoardBesli(int board[][], int board2[][], int board3[][], int board4[][], int board5[][], int sudokuNumber) {
        if (sudokuNumber == 3) {
            for (int row = 0; row < GRID_SIZE; row++) {
                for (int column = 0; column < GRID_SIZE; column++) {
                    if (board[row][column] == 0) {

                        //ORTA İLE SOL ÜST ORTAK İSE 
                        if (row <= 2 && column <= 2) {

                            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                if (isValidPlacement(board, numberToTry, row, column) && (isValidPlacement(board2, numberToTry, row + 6, column + 6))) {

                                    board[row][column] = numberToTry;
                                    board2[row + 6][column + 6] = numberToTry;
                                    // samurai[row+6][column+6] = numberToTry;

                                    if (solveBoardBesli(board, board2, board3, board4, board5, sudokuNumber)) {

                                        return true;
                                    } else {
                                        board[row][column] = 0;
                                        board2[row + 6][column + 6] = 0;
                                        //samurai[row+6][column+6] = 0;
                                    }
                                }
                            }
                            return false;

                        } // ORTA İLE SAĞ ÜST ORTAK İSE 
                        else if (row <= 2 && column >= 6) {

                            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                if (isValidPlacement(board, numberToTry, row, column) && (isValidPlacement(board3, numberToTry, row + 6, column - 6))) {

                                    board[row][column] = numberToTry;
                                    board3[row + 6][column - 6] = numberToTry;
                                    //  samurai[row+12][column+12] = numberToTry;

                                    if (solveBoardBesli(board, board2, board3, board4, board5, sudokuNumber)) {

                                        return true;
                                    } else {
                                        board[row][column] = 0;
                                        board3[row + 6][column - 6] = 0;
                                        //   samurai[row+12][column+12] = 0;
                                    }
                                }
                            }
                            return false;
                        } // ORTA İLE SOL ALT ORTAK İSE
                        else if (row >= 6 && column <= 2) {

                            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                if (isValidPlacement(board, numberToTry, row, column) && (isValidPlacement(board4, numberToTry, row - 6, column + 6))) {

                                    board[row][column] = numberToTry;
                                    board4[row - 6][column + 6] = numberToTry;
                                    //  samurai[row+12][column] = numberToTry;

                                    if (solveBoardBesli(board, board2, board3, board4, board5, sudokuNumber)) {

                                        return true;
                                    } else {
                                        board[row][column] = 0;
                                        board4[row - 6][column + 6] = 0;
                                        //samurai[row+12][column] =  0;
                                    }
                                }
                            }
                            return false;

                        } // ORTA İLE SAĞ ALT ORTAK İSE
                        else if (row >= 6 && column >= 6) {

                            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                if (isValidPlacement(board, numberToTry, row, column) && (isValidPlacement(board5, numberToTry, row - 6, column - 6))) {

                                    board[row][column] = numberToTry;
                                    board5[row - 6][column - 6] = numberToTry;
                                    //  samurai[row+12][column+12] = numberToTry;

                                    if (solveBoardBesli(board, board2, board3, board4, board5, sudokuNumber)) {

                                        return true;
                                    } else {
                                        board[row][column] = 0;
                                        board5[row - 6][column - 6] = 0;
                                        //   samurai[row+12][column+12] = 0;
                                    }
                                }
                            }
                            return false;

                        } // ORTAK DEĞİLSE
                        else {
                            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                if (isValidPlacement(board, numberToTry, row, column)) {
                                    board[row][column] = numberToTry;

                                    if (solveBoardBesli(board, board2, board3, board4, board5, 3)) {

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

            System.out.println("thread number is :" + sudokuNumber);
            return true;
        } else { //sudokunumber == 33
            for (int row = 8; row >= 0; row--) {
                for (int column = 8; column >= 0; column--) {
                    if (board[row][column] == 0) {

                        //ORTA İLE SOL ÜST ORTAK İSE 
                        if (row <= 2 && column <= 2) {

                            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                if (isValidPlacement(board, numberToTry, row, column) && (isValidPlacement(board2, numberToTry, row + 6, column + 6))) {

                                    board[row][column] = numberToTry;
                                    board2[row + 6][column + 6] = numberToTry;
                                    // samurai[row+6][column+6] = numberToTry;

                                    if (solveBoardBesli(board, board2, board3, board4, board5, sudokuNumber)) {

                                        return true;
                                    } else {
                                        board[row][column] = 0;
                                        board2[row + 6][column + 6] = 0;
                                        //samurai[row+6][column+6] = 0;
                                    }
                                }
                            }
                            return false;

                        } // ORTA İLE SAĞ ÜST ORTAK İSE 
                        else if (row <= 2 && column >= 6) {

                            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                if (isValidPlacement(board, numberToTry, row, column) && (isValidPlacement(board3, numberToTry, row + 6, column - 6))) {

                                    board[row][column] = numberToTry;
                                    board3[row + 6][column - 6] = numberToTry;
                                    //  samurai[row+12][column+12] = numberToTry;

                                    if (solveBoardBesli(board, board2, board3, board4, board5, sudokuNumber)) {

                                        return true;
                                    } else {
                                        board[row][column] = 0;
                                        board3[row + 6][column - 6] = 0;
                                        //   samurai[row+12][column+12] = 0;
                                    }
                                }
                            }
                            return false;
                        } // ORTA İLE SOL ALT ORTAK İSE
                        else if (row >= 6 && column <= 2) {

                            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                if (isValidPlacement(board, numberToTry, row, column) && (isValidPlacement(board4, numberToTry, row - 6, column + 6))) {

                                    board[row][column] = numberToTry;
                                    board4[row - 6][column + 6] = numberToTry;
                                    //  samurai[row+12][column] = numberToTry;

                                    if (solveBoardBesli(board, board2, board3, board4, board5, sudokuNumber)) {

                                        return true;
                                    } else {
                                        board[row][column] = 0;
                                        board4[row - 6][column + 6] = 0;
                                        //samurai[row+12][column] =  0;
                                    }
                                }
                            }
                            return false;

                        } // ORTA İLE SAĞ ALT ORTAK İSE
                        else if (row >= 6 && column >= 6) {

                            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                if (isValidPlacement(board, numberToTry, row, column) && (isValidPlacement(board5, numberToTry, row - 6, column - 6))) {

                                    board[row][column] = numberToTry;
                                    board5[row - 6][column - 6] = numberToTry;
                                    //  samurai[row+12][column+12] = numberToTry;

                                    if (solveBoardBesli(board, board2, board3, board4, board5, sudokuNumber)) {

                                        return true;
                                    } else {
                                        board[row][column] = 0;
                                        board5[row - 6][column - 6] = 0;
                                        //   samurai[row+12][column+12] = 0;
                                    }
                                }
                            }
                            return false;

                        } // ORTAK DEĞİLSE
                        else {
                            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                if (isValidPlacement(board, numberToTry, row, column)) {
                                    board[row][column] = numberToTry;

                                    if (solveBoardBesli(board, board2, board3, board4, board5, 3)) {

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

            System.out.println("thread number is :" + sudokuNumber);
            return true;
        }

    }

    private static boolean solveBoardikili(int board[][], int board2[][], int sudokuNumber) {

        // ÇÖZÜM BURADA YAPILIYOR...
        if (sudokuNumber == 1) {

            for (int row = 0; row < GRID_SIZE; row++) {
                for (int column = 0; column < GRID_SIZE; column++) {
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
                                        board2[row - 6][column - 6] = 0;
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

            System.out.println("thread number is :" + sudokuNumber);
            return true;

        } else if (sudokuNumber == 2) {

            for (int row = 0; row < GRID_SIZE; row++) {
                for (int column = 0; column < GRID_SIZE; column++) {
                    if (board[row][column] == 0) {
                        if (row >= 6 && column <= 2) {

                            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                if (isValidPlacement(board, numberToTry, row, column) && isValidPlacement(board2, numberToTry, row - 6, column + 6)) {

                                    board[row][column] = numberToTry;
                                    board2[row - 6][column + 6] = numberToTry;
                                    // samurai[row][column+12] = numberToTry;

                                    if (solveBoardikili(board, board2, sudokuNumber)) {
                                        return true;
                                    } else {
                                        board[row][column] = 0;
                                        board2[row - 6][column + 6] = 0;
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

            System.out.println("thread number is :" + sudokuNumber);
            return true;
        } //        else if (sudokuNumber == 3) {
        //            for (int row = 0; row < GRID_SIZE; row++) {
        //                for (int column = 0; column < GRID_SIZE; column++) {
        //                    if (board[row][column] == 0) {
        //                        
        //                        //ORTA İLE SOL ÜST ORTAK İSE 
        //                        
        //                        if (row <= 2 && column <= 2) {
        //
        //                            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
        //                                if (isValidPlacement(board, numberToTry, row, column) && isValidPlacement(board2, numberToTry, row + 6, column + 6)) {
        //
        //                                    board[row][column] = numberToTry;
        //                                    board2[row + 6][column + 6] = numberToTry;
        //                                    // samurai[row+6][column+6] = numberToTry;
        //
        //                                    if (solveBoardikili(board, board2,sudokuNumber)) {
        //
        //                                        return true;
        //                                    } else {
        //                                        board[row][column] = 0;
        //                                        board2[row + 6][column + 6] = 0;
        //                                        //samurai[row+6][column+6] = 0;
        //                                    }
        //                                }
        //                            }
        //                            return false;
        //
        //                        }
        //                        
        //                        // ORTA İLE SAĞ ÜST ORTAK İSE 
        //                        
        //                        
        //                        else if(row <=2 && column >= 6 ){
        //                            
        //                            
        //                             for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
        //                                if (isValidPlacement(board, numberToTry, row, column) && isValidPlacement(board3, numberToTry, row + 6, column - 6)) {
        //
        //                                    board[row][column] = numberToTry;
        //                                    board2[row + 6][column - 6] = numberToTry;
        //                                    //  samurai[row+12][column+12] = numberToTry;
        //
        //                                    if (solveBoardikili(board, board3, sudokuNumber)) {
        //
        //                                        return true;
        //                                    } else {
        //                                        board[row][column] = 0;
        //                                        board2[row + 6][column - 6] = 0;
        //                                        //   samurai[row+12][column+12] = 0;
        //                                    }
        //                                }
        //                            }
        //                            return false;       
        //                        }
        //                          
        //                          // ORTA İLE SOL ALT ORTAK İSE
        //                          
        //                          
        //                        else  if (row >= 6 && column <= 2) {
        //
        //                            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
        //                                if (isValidPlacement(board, numberToTry, row, column) && isValidPlacement(board4, numberToTry, row - 6, column + 6)) {
        //
        //                                    board[row][column] = numberToTry;
        //                                    board2[row - 6][column + 6] = numberToTry;
        //                                    //  samurai[row+12][column] = numberToTry;
        //
        //                                    if (solveBoardikili(board, board4, sudokuNumber)) {
        //
        //                                        return true;
        //                                    } else {
        //                                        board[row][column] = 0;
        //                                        board2[row - 6][column + 6] = 0;
        //                                        //samurai[row+12][column] =  0;
        //                                    }
        //                                }
        //                            }
        //                            return false;
        //
        //                        }
        //                          
        //                        // ORTA İLE SAĞ ALT ORTAK İSE
        //                        
        //                        if (row >= 6 && column >= 6) {
        //
        //                            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
        //                                if (isValidPlacement(board, numberToTry, row, column) && isValidPlacement(board5, numberToTry, row - 6, column - 6)) {
        //
        //                                    board[row][column] = numberToTry;
        //                                    board2[row - 6][column - 6] = numberToTry;
        //                                    //  samurai[row+12][column+12] = numberToTry;
        //
        //                                    if (solveBoardikili(board, board5, sudokuNumber)) {
        //
        //                                        return true;
        //                                    } else {
        //                                        board[row][column] = 0;
        //                                        board2[row - 6][column - 6] = 0;
        //                                        //   samurai[row+12][column+12] = 0;
        //                                    }
        //                                }
        //                            }
        //                            return false;
        //
        //                        }
        //                        
        //                        
        //                        // ORTAK DEĞİLSE
        //                        
        //                        else {
        //                            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
        //                                if (isValidPlacement(board, numberToTry, row, column)) {
        //                                    board[row][column] = numberToTry;
        //
        //                                    if (solveBoard(board)) {
        //
        //                                        return true;
        //                                    } else {
        //                                        board[row][column] = 0;
        //                                        // samurai[row+6][column+6] = 0;
        //                                    }
        //                                }
        //                            }
        //                            return false;
        //                        }
        //                    }
        //                }
        //            }
        //
        //            System.out.println("thread number is :" + sudokuNumber);
        //            return true;
        //        }
        else if (sudokuNumber == 4) {
            for (int row = 0; row < GRID_SIZE; row++) {
                for (int column = 0; column < GRID_SIZE; column++) {
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
                                        board2[row + 6][column - 6] = 0;
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
            System.out.println("thread number is :" + sudokuNumber);
            return true;
        } else if (sudokuNumber == 5) {

            for (int row = 0; row < GRID_SIZE; row++) {
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
                                        board2[row + 6][column + 6] = 0;
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

            System.out.println("thread number is :" + sudokuNumber);
            return true;
        }

        if (sudokuNumber == 11) {

            for (int row = 8; row >= 0; row--) {
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
                                        board2[row - 6][column - 6] = 0;
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

            System.out.println("thread number is :" + sudokuNumber);
            return true;

        }

        if (sudokuNumber == 22) {

            for (int row = 8; row >= 0; row--) {
                for (int column = 8; column >= 0; column--) {
                    if (board[row][column] == 0) {
                        if (row >= 6 && column <= 2) {

                            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                                if (isValidPlacement(board, numberToTry, row, column) && isValidPlacement(board2, numberToTry, row - 6, column + 6)) {

                                    board[row][column] = numberToTry;
                                    board2[row - 6][column + 6] = numberToTry;
                                    // samurai[row][column+12] = numberToTry;

                                    if (solveBoardikili(board, board2, sudokuNumber)) {
                                        return true;
                                    } else {
                                        board[row][column] = 0;
                                        board2[row - 6][column + 6] = 0;
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

            System.out.println("thread number is :" + sudokuNumber);
            return true;

        }
        if (sudokuNumber == 44) {
            for (int row = 8; row >= 0; row--) {
                for (int column = 8; column >= 0; column--) {
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
                                        board2[row + 6][column - 6] = 0;
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
            System.out.println("thread number is :" + sudokuNumber);
            return true;
        }

        if (sudokuNumber == 55) {

            for (int row = 8; row >= 0; row--) {
                for (int column = 8; column >= 0; column--) {
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
                                        board2[row + 6][column + 6] = 0;
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

            System.out.println("thread number is :" + sudokuNumber);
            return true;

        } else {
            return false;
        }

    }

}
