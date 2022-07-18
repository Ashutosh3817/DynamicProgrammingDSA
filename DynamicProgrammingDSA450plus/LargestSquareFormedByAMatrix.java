package DynamicProgrammingDSA450plus;

public class LargestSquareFormedByAMatrix {
	public static int largestSquare(int n,int m ,int[][] mat) {
		int[][] dp = new int[n][m];
		int ans = Integer.MIN_VALUE;
		for(int i=n-1;i>=0;i--) {
			for(int j=m-1;j>=0;j--) {
				if(i==n-1 && j==m-1) {
					dp[i][j] = mat[i][j];
				}
				else if(i==n-1) {
					dp[i][j] = mat[i][j];
				}
				else if(j==m-1) {
					dp[i][j] = mat[i][j];
				}
				else {
					if(mat[i][j]==0) dp[i][j]=0;
					else {
					int min = Math.min(dp[i+1][j],Math.min(dp[i][j+1],dp[i+1][j+1]));
					dp[i][j] = min+1;
					}
				}
				if(dp[i][j]>ans) {
					ans = dp[i][j];
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int n = 5;
		int m = 6;
		int[][] mat = {{0,1,0,1,0,1},
			{1,0,1,0,1,0},{0,1,1,1,1,0},{0,0,1,1,1,0},{1,1,1,1,1,1}};
		System.out.println(largestSquare(n,m,mat));
	}
}
