package DynamicProgrammingDSA450plus;

public class MaximizeProfitByBuyingAndSellingStocksAShareAtMostKTimesO3 {
	public static int maxProfit(int[] arr,int n,int k) {
		int dp[][] = new int[k+1][n];
		for(int t=1;t<=k;t++) {//t=> transactions
			for(int d=1;d<n;d++) {
				int max = dp[t][d-1];
				for(int pd=0;pd<d;pd++) {//pd => pastday
					int ptilltm1 = dp[t-1][pd];//ptilltm1=> profit till t minus 1 transaction
					int ptth  = arr[d] - arr[pd]; //ptth => profit till Tth transaction
					if(ptth+ptilltm1 > max) {
						max = ptth + ptilltm1;
					}
				}
				dp[t][d] = max;
			}
		}
		return dp[k][n-1];
	}
	public static void main(String[] args) {
		int[] arr = {9,6,7,6,3,8};
		int n = arr.length;
		int k = 3;
		System.out.println(maxProfit(arr,n,k));
	}
}
