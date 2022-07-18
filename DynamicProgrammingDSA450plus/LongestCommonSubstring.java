package DynamicProgrammingDSA450plus;

public class LongestCommonSubstring {
	public static int longest(String s1,String s2,int n , int m) {
		int[][] dp = new int[n+1][m+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				if(i==0 || j==0) dp[i][j]=0;
				else {
					if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
					else dp[i][j]=0;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				if(dp[i][j]>max) max = dp[i][j];
			}
		}
		return max;
	}
	public static void main(String[] args) {
		String s1 = "ABCDGH";
		String s2 = "ACDGHR";
		int n = s1.length();
		int m = s2.length();
		System.out.println(longest(s1,s2,n,m));
	}
}
