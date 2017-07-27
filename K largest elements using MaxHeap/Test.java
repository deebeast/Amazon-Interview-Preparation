import java.util.*;



class Test{
	
	class customSort implements Comparator<Integer>{
			@Override
			public int compare(Integer first, Integer second){
				if(second > first) return 1;
				return -1;
			}
	}
	
	void kLargest(Integer[] arr, int k){
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(1, new customSort());		
		maxHeap.addAll(Arrays.asList(arr));
		for(Iterator itr = maxHeap.iterator(); itr.hasNext() && (k-- > 0);){
			System.out.print(maxHeap.remove() + " ");
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		while(T-- > 0){
			int size = scan.nextInt();
			int k = scan.nextInt();
			Integer[] arr = new Integer[size];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(scan.next());
			}
			Test obj = new Test();
			obj.kLargest(arr,k);
		}
	}
}