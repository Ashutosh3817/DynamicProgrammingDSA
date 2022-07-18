package DynamicProgrammingDSA450plus;

public class SmallestSumContiguousArray {
	public static long smallest(int[] arr,int n) {
		long min_end_here = 0 ;
		long min_so_far = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			min_end_here += arr[i];
			if(min_end_here<min_so_far) min_so_far = min_end_here;
			if(min_end_here>0) min_end_here = 0 ;
			
		}
		return min_so_far;
	}
	public static void main(String[] args) {
		//int[] arr = {3, -4, 2, -3, -1, 7, -5};
		int[] arr = {2, 6, 8, 1, 4};
		int n = arr.length;
		System.out.println(smallest(arr,n));
	}
}
