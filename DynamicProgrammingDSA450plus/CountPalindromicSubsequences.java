package DynamicProgrammingDSA450plus;

public class CountPalindromicSubsequences {
	public static int pallindromic(String s , int n) {
		int[][] dp = new int[n+1][n+1];
		for(int g=0;g<n;g++) {
	    for(int i=0,j=g;j<n;i++,j++) {
	    	if(g==0) dp[i][j] = 1;
	    	
	    	else if(g==1) dp[i][j] = s.charAt(i)==s.charAt(j)?3:2;
	    	
	    	else {
	    		if(s.charAt(i)==s.charAt(j)) {
	    			dp[i][j] = 1+ dp[i+1][j]+dp[i][j-1];
	    		}
	    		else {
	    			dp[i][j] = dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
	    		}
	    	}
	    }
		}
		return dp[0][n-1];
	}
	public static void main(String[] args) {
		String s = "geeksforgeeks";
		int n = s.length();
		System.out.println(pallindromic(s,n));
	}
}
