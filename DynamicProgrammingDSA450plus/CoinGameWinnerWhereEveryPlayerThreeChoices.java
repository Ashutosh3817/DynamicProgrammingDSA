package DynamicProgrammingDSA450plus;

public class CoinGameWinnerWhereEveryPlayerThreeChoices {
	public static boolean findWinner(int n , int x, int y) {
		boolean[] dp = new boolean[n+1];
		dp[0] = false;
		dp[1] =true;
		for(int i=2;i<=n;i++) {
			if(i-1>=0 && dp[i-1]==false) dp[i] = true;
			else if(i-x>=0 && dp[i-x]==false) dp[i] = true;
			else if(i-y>=0 && dp[i-y]==false) dp[i] = true;
		    
			else dp[i] = false;
			
		}
		return dp[n];
	}
	public static void main(String[] args) {
		int n = 5 ; 
		int x = 4 ;	
		int y=3;
		if(findWinner(n,x,y)) System.out.println("A wins");
		else System.out.println("B wins");
	}
}
