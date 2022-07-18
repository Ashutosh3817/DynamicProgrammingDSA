package DynamicProgrammingDSA450plus;

public class GoldMineProblem {
	//Miners can move up right , diagonally down and up towards the right 
	public static int gold(int[][] arr,int n,int m) {
		 int[][] dp = new int[n][m];
		 for(int j=arr[0].length-1;j>=0;j--) {
			 for(int i=arr.length-1;i>=0;i--) {
				 if(j==arr[0].length-1) {
					 dp[i][j] = arr[i][j];
				 }
				 else if(i==0) {
					 dp[i][j] = arr[i][j]+ Math.max(dp[i][j+1], dp[i+1][j+1]);
					 
				 }
				 else if(i==arr.length-1){
					 dp[i][j] = arr[i][j]+Math.max(dp[i][j+1], dp[i-1][j+1]);
				 }
				 else {
					 dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], Math.max(dp[i-1][j+1], dp[i+1][j+1]));
					 
				 }
			 }
		 }
		 int max=dp[0][0];
		 for(int i=1;i<dp.length;i++) {
			 if(dp[i][0]>max) {
				 max = dp[i][0];
			 }
		 }
		 return max;
	}
	
	public static void main(String[] args) {
		int[][] arr = {{1,3,1,5},
	                  {2,2,4,1},
				       {5,0,2,3},
		                {0,6,1,2}};
		int n = arr.length;
		int m = arr[0].length;
        System.out.println(gold(arr,n,m));
	}

}	