import java.util.Scanner;

/**
 *
 * @author deepak
 */
class BleakNumber{
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int t = scan.nextInt();
      while(t-- > 0) {
        int num = scan.nextInt();
        System.out.println(isBleak(num)?"YES":"NO");
      }
    }

    private static boolean isBleak(int num) {
        for(int i = num - (int)(Math.ceil(Math.log(num)/Math.log(2))); i < num; i++)
            if(i + Integer.bitCount(i) == num){
                return false;
            }
                
        return true;
    }
}