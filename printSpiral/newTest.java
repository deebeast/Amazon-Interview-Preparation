import java.util.Scanner;

class newTest{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int rows = scan.nextInt();
		int cols = scan.nextInt();
		int[][] array = new int[rows][cols];
		int count = 1;
		for(int i = 0; i < rows; i++){
			for(int j = 0 ; j < cols; j++){
				array[i][j] = count++; 
			}
		}
		for(int i = 0; i < rows; i++){
			for(int j = 0 ; j < cols; j++){
				System.out.print(array[i][j] + "	"); 
			}
			System.out.println();
		}
		System.out.println();

		printSpiral(array);
		
	}
	static void printSpiral(int[][] array){
		int start = 0, end = 0;
		int rows = array.length;
		int cols = array[0].length;
		int layer = 1;
		while(start < rows && end < cols){
			System.out.println("Layer " + layer++);
			for(int i = end; i < cols; i++){
				System.out.print(array[start][i] + " ");
			}
			start++;
			for(int i = start; i < rows; i++){
				System.out.print(array[i][cols - 1] + " ");
			}
			cols--;
			if(start < rows){
				for(int i = cols - 1; i >= end; i--){
					System.out.print(array[rows - 1][i] + " ");
				}
				rows--;
			}
			if(end < cols){
				for(int i = rows - 1; i >= start; i--){
					System.out.print(array[i][end] + " ");
				}
				end++;
			}
			System.out.println();
		}
	}
}
