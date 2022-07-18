package DynamicProgrammingDSA450plus;

//TC => O(n^3)
public class PalindromePartitioningProblem {
	public static int minPalindromeCut(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];
		for(int g=0;g<s.length();g++) {
			for(int i=0,j=g;j<dp.length;i++,j++) {
				if(g==0) {
					dp[i][j] = false;
				}
				else if(g==1) {
					dp[i][j] = s.charAt(i)==s.charAt(j);
				}
				else {
					if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true) {
						dp[i][j] = true;
					}
					else {
						dp[i][j] = false;
					}
				}
			}
		}
		int[][] strg = new int[s.length()][s.length()];
		for(int g=0;g<s.length();g++) {
			for(int i=0,j=g;j<dp.length;j++,i++) {
				if(g==0) {
					strg[i][j]=0;
				}
				else if(g==1) {
					if(s.charAt(i)==s.charAt(j)) strg[i][j] = 0 ;
					else strg[i][j]=1;
				}
				else {
					if(dp[i][j]) {
						strg[i][j]=0;
					}
					else {
						int min = Integer.MAX_VALUE;
						for(int k=i;k<j;k++) {
							int left = strg[i][k];
							System.out.println(left + "left");
							int right = strg[k+1][j];
							System.out.println(right + "right");
							if(left+right+1<min) {
								min = left + right + 1;
							}
						}
						strg[i][j] = min;
					}
				}
			}
		}
		return strg[0][s.length()-1];
	}
	public static void main(String[] args) {
		String s = "abccbc";
		System.out.println(minPalindromeCut(s));
	}
}
