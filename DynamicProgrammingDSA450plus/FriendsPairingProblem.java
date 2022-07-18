package DynamicProgrammingDSA450plus;

public class FriendsPairingProblem {
	public static long countFriendsPairings(int n) {
		int[] dp = new int[n+1];
		if(n==0) return 0;
		if(n==1) return 1;
		
		dp[1]=1;
		dp[2] = 2;
		for(int i=3;i<=n;i++) {
			dp[i] = (dp[i-1] + dp[i-2]*(i-1))%(1000000007);
		}
		//int count = dp[n]%(10^9+7);
		return dp[n]%(1000000007);
	}
	public static void main(String[] args) {
		int n=4;
		System.out.println(countFriendsPairings(n));
	}
}
