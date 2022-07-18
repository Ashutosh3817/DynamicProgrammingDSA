package DynamicProgrammingDSA450plus;

public class LongestCommonSubsequenceOfThreeStrings {
	public static int longestCommon(String s1,String s2,String s3,int n1,int n2,int n3) {
		int[][][] dp = new int[n1+1][n2+1][n3+1];
		for(int i=0;i<=n1;i++) {
			for(int j=0;j<=n2;j++) {
				for(int k=0;k<=n3;k++){
					if(i==0||j==0||k==0) dp[i][j][k]=0;
				}
			}
		}
		for(int i=1;i<=n1;i++) {
			for(int j=1;j<=n2;j++) {
				for(int k=1;k<=n3;k++) {
					if(s1.charAt(i-1)==s2.charAt(j-1) && s2.charAt(j-1)==s3.charAt(k-1)) {
						dp[i][j][k] = 1 + dp[i-1][j-1][k-1];
					}
					else {
						dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
					}
				}
			}
		}
		return dp[n1][n2][n3];
	}
	public static void main(String[] args) {
		String s1 = "geeksforgeeks";
		String s2 = "geeksfor";
		String s3 = "geeks";
		System.out.println(longestCommon(s1,s2,s3,s1.length(),s2.length(),s3.length()));
	}
}
