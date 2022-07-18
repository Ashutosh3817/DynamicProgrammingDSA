package DynamicProgrammingDSA450plus;

public class PaintingTheFenceProblem {
	public static long paintFence(int n,int k) { 
		long last_two_same = k*1;
		
		long last_two_diff = k * (k-1);
		
		long total = last_two_same  +  last_two_diff;
		
		long mod = 1000000007;
		
		for(int i=3;i<=n;i++) {
			
			last_two_same  = (last_two_diff*1)%(1000000007);
			
			last_two_diff = (total*(k-1))%(1000000007);
			
			total = (last_two_same+last_two_diff)%(1000000007);
			
		}
		
		return total%(1000000007);
		
	}
	
	public static void main(String[] args) {
		int n=5;
		int k=3;
		System.out.println(paintFence(n,k));
	}
}
