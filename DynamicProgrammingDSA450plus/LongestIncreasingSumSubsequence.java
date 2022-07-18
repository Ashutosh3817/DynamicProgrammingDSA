package DynamicProgrammingDSA450plus;

public class LongestIncreasingSumSubsequence {
	public static void longestInt(int[] arr,int n) {
		int dp[] = new int[n];
		
		int omax = Integer.MIN_VALUE;
		for(int i=0;i<dp.length;i++) {
			Integer max = null;
			for(int j=0;j<i;j++) {
				if(arr[j]<=arr[i]) {
					if(max==null) 
						max=dp[j];
					
					if(dp[j]>max)
						max = dp[j];
					
				}
			}
			if(max==null) 
				dp[i] = arr[i];
			
			else 
				dp[i] = max + arr[i];
			
			if(dp[i]>omax) 
				omax = dp[i];
			
			System.out.println(omax);
		}

	}
	public static void main(String[] args) {
		//int[] arr = {1, 101, 2, 3, 100};
		int[] arr = {10,22,9,33,21,50,41,60,80,1};
		longestInt(arr,arr.length);
		}
	
}
