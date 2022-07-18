package DynamicProgrammingDSA450plus;

public class KadanesAlgo {
	public static long kadanes(int[] arr,int n) {
		long max_so_far = Integer.MIN_VALUE;
		long max_end_here = 0 ; 
		for(int i=0;i<n;i++) {
			max_end_here += arr[i];
			if(max_end_here>max_so_far) max_so_far = max_end_here;
			if(max_end_here<0) max_end_here=0;
		}
		return max_so_far;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,-2,5};
		int n = arr.length;
		System.out.println(kadanes(arr,n));
	}
}