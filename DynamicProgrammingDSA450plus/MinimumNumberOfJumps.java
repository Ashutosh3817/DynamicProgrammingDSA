package DynamicProgrammingDSA450plus;

public class MinimumNumberOfJumps {
	public static int minimum(int[] arr , int n) {
		if(arr.length<=1) return 0;
		if(arr[0]==0) return -1;
		if(arr[0]>=n-1) return 1;
		int maxReach = arr[0];
		int step = arr[0];
		int jump=1;
		for(int i=1;i<n;i++) {
			if(i==n-1) return jump;
			maxReach = Math.max(maxReach, arr[i]+i);
			step--;
			if(step==0) {
				jump++;
				if(i>=maxReach) return -1;
				step = maxReach - i ;
		
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		//int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} ;
		int[] arr = {2,1,0,3};
		int n= arr.length;
		System.out.println(minimum(arr,n));
	}
}
