import java.util.Scanner;

class zeroMatrix {
  public static void main(String[] args) {
    int[][] matrix = new int[3][3];
    matrix = input(matrix);
    System.out.println("Old Matrix :");
    print(matrix);
    matrix = setZeroes(matrix);
    System.out.println("New Matrix :");
    print(matrix);
  }
  static void print(int[][] matrix) {
    for(int i = 0; i < matrix.length; i++) {
      for(int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  static int[][] input(int[][] matrix) {
    Scanner scan = new Scanner(System.in);
    for(int i = 0; i < matrix.length; i++) {
      for(int j = 0; j < matrix[0].length; j++) {
        matrix[i][j] = scan.nextInt();
      }
    }
    return matrix;
  }

  static int[][] setZeroes(int[][] matrix) {
    boolean rowHasZero = false;
    boolean colHasZero = false;

    //Check if first row has zero

    for(int j = 0; j < matrix[0].length; j++) {
      if(matrix[0][j] == 0) {
        rowHasZero = true;
        break;
      }
    }

    //check if first column has zero
    for(int i = 0; i < matrix.length; i++) {
      if(matrix[i][0] == 0) {
        colHasZero = true;
        break;
      }
    }

    //check for zero in the rest of the array
    for(int i = 1; i < matrix.length; i++) {
      for(int j = 1; j < matrix[0].length; j++) {
        if(matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    //nullify rows based on values in first column
    for(int i  = 1; i < matrix.length; i++) {
      if(matrix[i][0] == 0) matrix = nullifyRow(matrix, i );
    }
    //nullify columns based on values in first rowHasZero
    for(int j = 1; j < matrix[0].length; j++) {
      if(matrix[0][j] == 0) matrix = nullifyColumn(matrix, j);
    }
    if(rowHasZero) matrix = nullifyRow(matrix, 0);
    if(colHasZero) matrix = nullifyColumn(matrix, 0);
    
    return matrix;
  }



  static int[][] nullifyRow(int[][] matrix, int row) {
    for(int j = 0; j < matrix[0].length; j++) {
      matrix[row][j] = 0;
    }
    return matrix;
  }
  static int[][] nullifyColumn(int[][] matrix, int col) {
    for(int i = 0; i < matrix.length; i++) {
      matrix[i][col] = 0;
    }
    return matrix;
  }
}
