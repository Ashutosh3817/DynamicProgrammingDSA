package DynamicProgrammingDSA450plus;

public class BinomialCoefficientProblem {
	public static int nCr(int n,int r ) {
		int[][] dp = new int[n+1][r+1];
		int mod = 1000000007;
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<r+1;j++) {
				if(i==j || j==0)
					dp[i][j] =1 ; 
				else if(j>i) 
					dp[i][j]=0;
				
				else
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%mod;
			}
		}
		return dp[n][r];
	}
	public static void main(String[] args) {
		int n = 3;
		int r = 2;
		System.out.println(nCr(n,r));
	}
}
