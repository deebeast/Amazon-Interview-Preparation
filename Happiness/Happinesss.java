
import java.util.Scanner;

/**
 *
 * @author deepak
 */
public class Happinesss {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Test Cases:");
        int t = scan.nextInt();
        int k, size;
        while(t-- > 0){
            System.out.println("k:");
            k = scan.nextInt();
            System.out.println("size:");
            size = scan.nextInt();
            int[] arr = new int[size];
            for(int i = 0; i < size; i++){
                arr[i] = scan.nextInt();
            }
            System.out.println("output: " + lily(arr, k));
        }
    }

    private static int lily(int[] arr, int k) {
        int indexOfkDifference = indexOfkDifference(arr, k);
        if(indexOfkDifference == -1) return arr.length;
        boolean includeLast = (indexOfkDifference == arr.length - 1);
        return 1 + indexOfkDifference/2 + ((indexOfkDifference%2 == 0)?0:1);
    }
    private static int indexOfkDifference(int[] arr, int k) {
        int min = arr[0];
        int max = arr[0];
        int indexOfkDifference = arr.length - 1;
        for(int i = 1; i < arr.length; i++){
            
            if(arr[i] < min) min = arr[i];
            if(arr[i] > max) max = arr[i];
            if(Math.abs(arr[i] - min) >= k){
                indexOfkDifference = i;
                break;
            }
            else if(Math.abs(max - min) >= k){
                indexOfkDifference = i;
                return i;
            }
        }
        if(Math.abs(arr[indexOfkDifference] - min) < k ) return  -1;
        return indexOfkDifference;
    }
    
}
