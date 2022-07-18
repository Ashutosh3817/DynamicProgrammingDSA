package DynamicProgrammingDSA450plus;

public class MaximizeProfitByBuyingAndSellingStocksAtMostKTimesOptimizedApproach {
	public static int maximizeProfit(int[] arr,int n  , int k) {
		int[][] dp = new int[k+1][n];
		for(int t=1;t<=k;t++) {
			int max = Integer.MIN_VALUE;
			for(int d=1;d<n;d++) {
				if(dp[t-1][d-1] - arr[d-1]> max) {
					max = dp[t-1][d-1] - arr[d-1];
				}
				if(max + arr[d] > dp[t][d-1]) {
					dp[t][d] = max + arr[d];
				}
				else {
					dp[t][d] = dp[t][d-1];
				}
			}
		}
		return dp[k][n-1];
	}
    public static void main(String[] args) {
    	int[] arr = {9,6,7,6,3,8};
    	int n = arr.length;
    	int k =3;
    	System.out.println(maximizeProfit(arr,n,k));
    }
	
}
