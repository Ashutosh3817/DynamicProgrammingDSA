package DynamicProgrammingDSA450plus;

public class EggDroppingProblem {
	public static int eggDrop(int n,int k) {
		int[][] dp = new int[n+1][k+1];//n=> no of eggs //k=> no of floors
		for(int i=1;i<=n;i++) {//e=> eggs
			for(int j=1;j<=k;j++) {//f=>floor
				if(i==1) {
					dp[i][j] = j ;
				}
				else if(j==1) {
					dp[i][j]=1;
				}
				else {
					int min = Integer.MAX_VALUE;
					for(int myj=j-1,pj=0;myj>=0;myj--,pj++){//myj=>my row ka j
						int val1 = dp[i][myj];//egg survives
						int val2 = dp[i-1][pj];//egg breaks
						int val = Math.max(val1, val2);
						min = Math.min(val, min);
					}
					dp[i][j] = min+1;
				}
				
			}
		}
		return dp[n][k];
	}
	public static void main(String[] args) {
		int n=3;
		int k=7;
		System.out.println(eggDrop(n,k));	
	}
}
