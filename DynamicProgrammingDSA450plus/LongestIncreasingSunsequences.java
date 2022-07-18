package DynamicProgrammingDSA450plus;

public class LongestIncreasingSunsequences {
	public int lengthofLIS(int[] nums) {
		if(nums==null || nums.length==0) return 0 ;
		
		int[] dp = new int[nums.length];
		int max = 1;
		for(int i=0;i<dp.length;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(nums[i]>nums[j]) {
				dp[i] = Math.max(dp[i], dp[j]+1);
				max= Math.max(dp[i],max);
				

			}
		}
	}
		System.out.println(max);
		return max;
	}
	public static void main(String[] args) {
	//	int[] nums = {10,9,2,5,3,7,101,18};
		int[] nums = {1,3,2,4};
		System.out.println(nums);
	}
}
