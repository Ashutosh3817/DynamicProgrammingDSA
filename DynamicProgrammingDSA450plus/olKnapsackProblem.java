package DynamicProgrammingDSA450plus;

public class olKnapsackProblem {
	public static int knapsack(int[]wt,int[] val,int n,int cap) {
		int[][] dp = new int[n+1][cap+1];
	    for(int i=0; i<n+1; i++)  //Intialisation(Base Condition)
	       {
	           for(int j=0; j<cap+1;j++)
	           {
	               if(i==0 || j==0)
	               {
	                   dp[i][j] = 0;
	               }
	           }
	       }
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				
				
				if(j>=wt[i-1]) {
					int rCap = j - wt[i-1];
					if(dp[i-1][rCap]+ val[i-1]>dp[i-1][j]) {
						dp[i][j] = dp[i-1][rCap] + val[i-1];
					}else {
						dp[i][j] = dp[i-1][j]; //when i doesnot bat  // j balls par i team kitne maximum run score kr skti hai
					}
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][cap];
	}
	public static void main(String[] args) {
		int w = 7 ;
		int[] val = {15,14,10,45,30};
		int wt[] = {2,5,1,3,4};
		int n=5;
		System.out.println(knapsack(wt,val,n,w));
	}
}
