package DynamicProgrammingDSA450plus;

public class CountDearrangementsRecursiveApproach {
	public static int countDer(int n) {
		if(n==1) return 0;
		if(n==2) return 1;
		return (n-1)*(countDer(n-1)+countDer(n-2));
	}
	public static void main(String[] args) {
		int n = 3 ; 
		System.out.println(countDer(n));
	}
}
