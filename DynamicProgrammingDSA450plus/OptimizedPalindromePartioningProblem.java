package DynamicProgrammingDSA450plus;

public class OptimizedPalindromePartioningProblem {
	public static int palindromeCut(String s,int n) {
		boolean[][] dp = new boolean[n][n];
		for(int g=0;g<n;g++) {
			for(int i=0,j=g;j<dp.length;j++,i++) {
				if(g==0) dp[i][j] = true;
				else if(g==1) dp[i][j] = s.charAt(i)==s.charAt(j);
				else {
					if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true) {
						dp[i][j] = true;
					}
					else dp[i][j] = false;
				}
			}
		}
		int[] strg = new int[n];
		strg[0] = 0 ;
		for(int j=1;j<n;j++) {
			  int min = Integer.MAX_VALUE;
		        if(dp[0][j]) {
		               strg[j]=0;
		           }
		        else {
		        	for(int i=j;i>=1;i--) {
		        		if(dp[i][j]) {
		        			if(strg[i-1]<min) {
		        				min = strg[i-1];
		        			}
		        		}
		        	}
		        }
		        strg[j] = min+1;
		}
		return strg[strg.length-1];
	}
	public static void main(String[] args) {
		String s = "abccbc";
		int n =s.length();
		System.out.println(palindromeCut(s,n));
	}
}
