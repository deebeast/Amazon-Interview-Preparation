import java.util.Scanner;

class Test0{

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int size = scan.nextInt();
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
      array[i] = scan.nextInt();
    }
    System.out.println(kadane(array, size));
  }

  static int kadane(int[] array, int size){

    int maxCurrent = array[0];
    int maxGlobal = array[0];
    int maxStart = 0;
    int maxEnd = 0;
    for(int i = 1; i < size; i++){
      int temp = maxCurrent + array[i];
      int start = 0;
      if(array[i] > temp){
        maxCurrent = array[i];
        start = i;
      } else {
        maxCurrent = temp;
      }
      if(maxCurrent > maxGlobal){
        maxGlobal = maxCurrent;
        maxStart = start;
        maxEnd = i;
      }
    }
    System.out.println("start = " + maxStart + " end = " + maxEnd);
    return maxGlobal;
  }
}
