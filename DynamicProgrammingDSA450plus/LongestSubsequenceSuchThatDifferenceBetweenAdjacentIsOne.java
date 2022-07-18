package DynamicProgrammingDSA450plus;

public class LongestSubsequenceSuchThatDifferenceBetweenAdjacentIsOne {
	public static int longestInc(int[] arr , int n) {
		int[] dp = new int[n];
		int ans = 1;
		for(int i=0;i<n;i++)
			dp[i] = 1; 
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(Math.abs(arr[i]-arr[j])==1   && dp[i]<=dp[j]+1) 
					dp[i] = Math.max(dp[i],dp[j] + 1);
				
			}
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}
	public static void main(String[] args) {
//		int[] arr = {10,9,4,3,4,8,6};
		int[] arr = {100,4,200,1,3,2};
		int n = arr.length;
		System.out.println(longestInc(arr,n));
	}
}
