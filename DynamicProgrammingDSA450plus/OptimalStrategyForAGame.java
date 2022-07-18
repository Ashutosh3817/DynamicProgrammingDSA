package DynamicProgrammingDSA450plus;

public class OptimalStrategyForAGame {
	public static int  optimalStrategy(int[] arr) {
	int[][] dp = new int[arr.length][arr.length];
	//g=>gap (we use gap algorithm here)
	// like count palindromic subsequences
	for(int g=0;g<dp.length;g++) {
		for(int i=0,j=g;j<dp.length;i++,j++) {
			if(g==0) {
				//gap => 0 
				dp[i][j] = arr[i];
			}
			else if(g==1) {
				dp[i][j] = Math.max(arr[i], arr[j]);
			}
			else {
				int val1 = arr[i] + Math.min(dp[i+2][j],dp[i+1][j-1]); // ye mere sath ho rha hai to iss liye maine min mana hai	
				System.out.println(val1 + "!");
				//i =>i+1 , j //I take i
				
				// if i+1 -> i+2,j
				// or j -> i+1 , j-1
				// agar hum i lete hai tab j opponent ke liye rhega aur agar hum j lete hai ti i 
				//opponent ke liye rhega
				int val2 = arr[j] + Math.min(dp[i+1][j-1], dp[i][j-2]); 
				System.out.println(val2 + " j");
				//ye mere sath ho rha hai isliye min mantre hai
				// j -> i , j-1  // I take j
				
				//if j-1 ->i , j-2
				//or i+1 -> i+1 , j-1
				//similarly phle hume j le lia tha
				
				int val = Math.max(val1, val2); // isme hme khudh krna hai isliye hum max mante hai
				System.out.println(val);
				dp[i][j] = val;
			}
		}
	}
	
	return dp[0][arr.length-1];
	//print top right
}
public static void main(String[] args) {
	int[] arr = {20,30,2,10};
	System.out.println(optimalStrategy(arr));
}
}

