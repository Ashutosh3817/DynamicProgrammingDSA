package DynamicProgrammingDSA450plus;

public class EditDistance {
	public static int edit(String str1,String str2) {
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp.length;j++) {
				if(i==0)
					dp[i][j]=j;
				else if(j==0)
					dp[i][j] = i ; 
				else {
					if(str1.charAt(i-1)==str2.charAt(j-1)) {
						dp[i][j] = dp[i-1][j-1];
					}
					else {
						int insert = 1 + dp[i][j-1];
						int delete = 1 + dp[i-1][j];
						int replace = 1 + dp[i-1][j-1];
						dp[i][j] = Math.min(insert,Math.min(delete, replace));
					}
					
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
	public static void main(String[] args) {
		String s1 = "abcmo";
		String s2 = "adcne";
		System.out.println(edit(s1,s2));
	}
}
