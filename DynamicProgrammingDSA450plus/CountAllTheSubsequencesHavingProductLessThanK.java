package DynamicProgrammingDSA450plus;

public class CountAllTheSubsequencesHavingProductLessThanK {
	public static int count(int[] arr , int n,int k) {
		int[][] dp = new int[k+1][n+1];
		for(int i=0;i<k;i++) {
			for(int j=0;j<n;j++) {
				if(i==0||j==0) {
					dp[i][j] = 0 ; 
				}
			}
		}
		for(int i=1;i<=k;i++) {
			for(int j=1;j<=n;j++) {
				dp[i][j] = dp[i][j-1];
				if(arr[j-1]<=i && arr[j-1]>0) {
//					System.out.println(dp[i/arr[j-1]][j-1]);
					dp[i][j] = dp[i][j] + dp[i/arr[j-1]][j-1] + 1;
					System.out.println(dp[i][j]);
				}
			}
		}
		return dp[k][n];
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		int n = arr.length;
		int k = 11;
		System.out.println(count(arr,n,k));
	}
	
}
