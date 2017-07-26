import java.util.*;

class pair{
	int bundle;
	int cost;
	double perUnit;
	public pair(int b, int c , double p){
		bundle = b;
		cost = c;
		perUnit = p;
	}
}

class CustomSort implements Comparator<pair> {
	public int compare(pair p1, pair p2){
		if(p2.perUnit > p1.perUnit) return 1;
		else return -1;
	}
}

class Test{
	static int calculate(int[] bundle, int[] cost, int balance){
		pair[] pp = new pair[bundle.length];
		for(int i = 0; i < pp.length; i++){
			pp[i] = new pair(bundle[i], cost[i], bundle[i]/(double)cost[i]);
		}
		Arrays.sort(pp, new CustomSort());
		for(int i = 0; i < pp.length; i++){
			System.out.println("bundle cost perUnit");
			System.out.println(pp[i].bundle + "     " + pp[i].cost + "     " + pp[i].perUnit);
		}
		int bal = balance;
		int result = 0;
		for(int i = 0; i < pp.length; i++ ){
			result += bal / pp[i].cost * pp[i].bundle;
			bal = bal % pp[i].cost;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] bundle = new int[] { 60, 100, 120 };
		int[] cost = new int[] { 10, 20, 30 };
		int balance = 50;
		System.out.println("output = " + calculate(bundle, cost, balance));

	}
}
