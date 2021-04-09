package Solutions;

import java.util.Scanner;

public class Eight_Queen_Problem {
    static Scanner myScanner;
    static int N = 8;

    public static void main(String[] args) {
        //myScanner = new Scanner(System.in);
        //N = myScanner.nextInt();
        //Building board with the value of N
        int[][] problemBoard = new int[N][N];
        //Call the solveBoard function with the initial board and column value=0
        if (solveBoard(problemBoard, 0)) {
            printSolutionBoard(problemBoard);
        } else {
            System.out.println("No solution for this problem.");
        }
    }

    //Function solveBoard is the prime function here. Does the backtracking to find the solution
    static boolean solveBoard(int problemBoard[][], int column) {
        if (column >= N) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            //Check by calling this function that it is safe to place here or not.
            if (isSafePlacement(problemBoard, i, column)) {
                //if it is safe, save the value of 1 in that index
                problemBoard[i][column] = 1;

                if (solveBoard(problemBoard, column + 1)) {
                    return true;
                }
                //if the placement is not safe set 0 in the board's that index
                problemBoard[i][column] = 0;
            }
        }
        return false;
    }

    //Placement function
    static boolean isSafePlacement(int problemBoard[][], int row, int column) {
        int i, j;

        //Check row on left side
        for (i = 0; i < column; i++) {
            if (problemBoard[row][i] == 1) {
                return false;
            }
        }
        //Check upper diagonal on left side
        for (i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (problemBoard[i][j] == 1) {
                return false;
            }
        }
        //Check lower diagonal on left side
        for (i = row, j = column; j >= 0 && i < N; i++, j--) {
            if (problemBoard[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    //print Solution matrix
    static void printSolutionBoard(int problemBoard[][]) {
        System.out.println("Solution Matrix:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + problemBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
}
