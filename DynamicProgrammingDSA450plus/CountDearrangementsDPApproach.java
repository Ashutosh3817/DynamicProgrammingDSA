package DynamicProgrammingDSA450plus;

public class CountDearrangementsDPApproach {
	public static int countDer(int n) {
		int[] dp = new int[n+1];
		dp[1] = 0 ;
		dp[2] =1;
		for(int i=3;i<=n;i++) {
			dp[i] = (i-1) * (dp[i-1]+dp[i-2]);
		}
		return dp[n];
	}
	public static void main(String[] args) {
		int n= 4 ;
		System.out.println(countDer(n));
	}
}
