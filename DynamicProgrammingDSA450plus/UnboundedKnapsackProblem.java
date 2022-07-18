package DynamicProgrammingDSA450plus;

public class UnboundedKnapsackProblem {
	public static int knapsack(int n ,int[] wts,int vals[],int cap) {
		int[] dp = new int[cap+1];
		dp[0] = 0 ;
		for(int bagc=1;bagc<=cap;bagc++) {
			 int max=0;
			 for(int i=0;i<n;i++) {
				
				 if(wts[i]<=bagc) {
					 int rbagc = bagc - wts[i];//remaining bag capacity
					 int rbagv = dp[rbagc];
					 int tbagv = rbagv + vals[i];//total bag capacity
					 if(tbagv>max)max = tbagv;
				 }
			 }
		
		
			 dp[bagc] = max;
				}
		return dp[cap];
		}
	public static void main(String[] args) {
		int n=5;
		int[] wts= {2,5,1,3,4};
		int[] vals = {15,14,10,45,30};
		int cap = 7 ;
		System.out.println(knapsack(n,wts,vals,cap));
	}
}
