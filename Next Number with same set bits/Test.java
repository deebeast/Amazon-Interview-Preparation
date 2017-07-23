import java.util.Scanner;

class Test{
	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
		int x =  scan.nextInt();
		System.out.println(func(x));
	}
	static int func(int x){
		System.out.println(" x = "+Integer.toBinaryString(x));
		System.out.println("-x = " + Integer.toBinaryString(-x));
		int smallest = x & -x;
		System.out.println("smallest = "+ Integer.toBinaryString(smallest));
		int ripple = x + smallest;
		System.out.println("ripple = " + Integer.toBinaryString(ripple));
		int ones = x ^ ripple;
		System.out.println("ones = "+Integer.toBinaryString(ones));
		ones = (ones >> 2) / smallest;
		System.out.println("ones = "+Integer.toBinaryString(ones));
		return ripple | ones;
	}
}