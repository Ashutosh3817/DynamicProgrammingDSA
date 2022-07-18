package DynamicProgrammingDSA450plus;

public class PermutationCoefficient {
	public static int permutation(int n , int k ) {
		int p=1;
		for(int i=0;i<k;i++) {
			p *= (n-i);
		}
		return p ;
	}
	public static void main(String[] args) {
		int n = 10 ; 
		int k =2;
		System.out.println(permutation(n,k));
	}
}
