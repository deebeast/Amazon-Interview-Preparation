import java.util.Scanner;

class Test{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int rows = scan.nextInt();
    int cols = scan.nextInt();
    int[][] array = new int[rows][cols];
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < cols; j++) {
        array[i][j] = scan.nextInt();
      }
    }
    System.out.println("Number of negative integers : " + negCount(array, rows, cols));
  }
  static int negCount(int[][] array, int rows, int cols){
    int count = 0;
    int i = 0;
    int j = cols - 1;
    while(i < rows && j >= 0){
      if(array[i][j] < 0){
        count += (j+1);
        i++;
      } else {
        j--;
      }
    }
    return count;
  }
}
