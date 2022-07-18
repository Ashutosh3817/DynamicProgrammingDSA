package DynamicProgrammingDSA450plus;

public class CoinChangeCombinations {
	public static int coin(int[] arr,int n,int amt) {
		int[] dp = new int[amt+1];
		dp[0] = 1 ; 
		for(int i=0;i<arr.length;i++) {
			for(int j = arr[i] ;j<dp.length;j++) {
				dp[j] += dp[j-arr[i]];
			}
		}
		return dp[amt];
	}
	public static void main(String[] args) {
		int[] coins = {2,3,5};
		int n = coins.length;
		int m = 7 ;
		System.out.println(coin(coins,n,m));
	}
}
