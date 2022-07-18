package DynamicProgrammingDSA450plus;

public class LongestCommonSubsequences {
	public static int subsequences(String str1 , String str2) {
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				if(i==0) {
					dp[i][j]=0;
				}
				else if(j==0) {
					dp[i][j] = 0 ; 
				}
				else {
					if(str1.charAt(i-1)!=str2.charAt(j-1)) {
						int up = dp[i-1][j];
						int left = dp[i][j-1];
						dp[i][j] = Math.max(up, left);
					}
					else {
						dp[i][j] = 1 + dp[i-1][j-1];
					}
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
	public static void main(String[] args) {
	     String s1 = "ABCDGH";
		String s2 = "ACDGHR";
	//	String s1 = "adac";
		//String s2 = "adadac";
		System.out.println(subsequences(s1,s2));
	}
}
