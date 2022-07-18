package DynamicProgrammingDSA450plus;

public class countDerrangementsSpaceOptimizedApproach {
	public static int countDer(int n) {
		if(n==1||n==2) return n-1;
		int a=0;
		int b=1;
		for(int i=3;i<=n;i++) {
			int cur = (i-1) * (a+b);
			a=b;
			b=cur;
		}
		return b;
	}
	public static void main(String[] args) {
		int n=4;
		System.out.println(countDer(n));
	}
}
