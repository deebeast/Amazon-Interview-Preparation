import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author deepak
 */
public class SecondLargest {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Test Cases");
        int T = Integer.parseInt(br.readLine());
        int size;
        while(T-- > 0){
            System.out.println("Size:");
            size = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int largest = Math.max(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            int secondLargest = Math.min(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            for (int i = 2; i < input.length; i++) {
                int current = Integer.parseInt(input[i]);
                if( current > secondLargest)
                    if(current > largest){
                        secondLargest = largest;
                        largest = current;
                    } else {
                        secondLargest = current;
                    }
            }
            System.out.println(secondLargest);
        }
    }
    
}
