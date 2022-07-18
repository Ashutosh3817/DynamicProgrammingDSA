package DynamicProgrammingDSA450plus;

public class InterleavedString {
	public static boolean isInterleave(String a,String b,String c) {
		int m = a.length();
		int n = b.length();
		boolean[][] dp = new boolean[m+1][n+1];
		if(c.length()!=(m+n)) return false;
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 && j==0) {
					dp[i][j] = true;
				}
				else if(i==0) {
					if(b.charAt(j-1)==c.charAt(j-1)) {
						dp[i][j] = dp[i][j-1];
					}
					else {
						dp[i][j] = false;
					}
				}
				else if(j==0) {
					if(a.charAt(i-1)==c.charAt(i-1)) {
						dp[i][j] = dp[i-1][j];
					}
				}
				else if(a.charAt(i-1)==c.charAt(i+j-1) && b.charAt(j-1)!=c.charAt(i+j-1)) {
					dp[i][j] = dp[i-1][j];
				}
				else if(a.charAt(i-1)!=c.charAt(i+j-1) && b.charAt(j-1)==c.charAt(i+j-1)) {
					dp[i][j] = dp[i][j-1]; 
				}
				else if(a.charAt(i-1)==c.charAt(i+j-1) && b.charAt(j-1)==c.charAt(i+j-1)) {
					dp[i][j] = (dp[i-1][j] || dp[i][j-1]);
				}
			}
		}
		return dp[m][n];
	}
	public static void main(String[]  args) {
		String a = "XY";
		String b = "X";
		String c = "XXY";
		System.out.println(isInterleave(a,b,c));
	}
}
