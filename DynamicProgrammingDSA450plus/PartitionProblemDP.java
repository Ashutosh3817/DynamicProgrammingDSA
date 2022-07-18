package DynamicProgrammingDSA450plus;

public class PartitionProblemDP {
	  static int equalPartition(int n, int nums[])
	    {
	        int sum = 0;
	        for(int a :  nums) sum += a;
	         
	        if(sum % 2 != 0) return 0;      // return false if odd sum
	        
	        return subsetSum( nums,n, sum/2);
	    }
	    private static int subsetSum(int[] nums, int n, int sum){
	        int dp[][] = new int[n+1][sum+1];
	        
	        for(int i =0 ; i< sum+1 ; ++i) dp[0][i] = 0;
	        for(int i = 0; i< n+1 ; ++i)   dp[i][0] = 1;
	        
	        for(int i = 1; i< n+1 ; i++){
	            for( int j = 1;  j < sum+1 ; j++){
	                if(nums[i-1] <= j)
	                        dp[i][j] = Math.max( dp[i-1][j-nums[i-1]], dp[i-1][j] );
	                else dp[i][j] = dp[i-1][j];
	            }
	        }
	        return dp[n][sum];
	    }
	
	public static void main(String[] args) {
		int arr[] = {1,5,11,5};
		int n = arr.length;
		System.out.println(equalPartition(n,arr));
	}
}
