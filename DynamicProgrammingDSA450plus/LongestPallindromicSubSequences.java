package DynamicProgrammingDSA450plus;

public class LongestPallindromicSubSequences {
	public static void longest(String str,int n ) {
		int i=0;
		char[] s1 = str.toCharArray();
		int h = n-1;
		while(i<=h) {
			char temp = s1[h];
			s1[h] = s1[i];
			s1[i] = temp;
			i++;
			h--;
		}
		String str2 = String.valueOf(s1);
		System.out.println(str2);
		palindromic(str,str2,str.length(),str2.length());
	}
	public static void palindromic(String s1,String s2,int n,int m ) {
		int[][] dp = new int[n+1][m+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				if(i==0 || j==0) dp[i][j] =0;
				else {
					if(s1.charAt(i-1)!=s2.charAt(j-1)) {
						int left = dp[i][j-1];
						int up = dp[i-1][j];
						dp[i][j] = Math.max(left, up);
					}
					else {
						dp[i][j] = 1+ dp[i-1][j-1];
					}
				}
			}
		}
		System.out.println(dp[dp.length-1][dp[0].length-1]);
	}
	public static void main(String[] args) {
	//	String s1 = "bbabcbcab";
		String s1 = "bbbab";
		longest(s1,s1.length());
	}
}
