package DynamicProgrammingDSA450plus;

public class AssemblyLineScheduling {
	public static int carAssembly(int[][] a,int[][] t,int[] e , int[] x) {
		int[] T1 = new int[4];
		int[] T2 = new int[4];
		T1[0] = e[0] + a[0][0];
		T2[0] = e[1] + a[0][1];
		
		for(int i=1;i<4;i++) {
			T1[i] = Math.min((T1[i-1]+ a[0][i]),(T2[i-1]+t[1][i]+a[0][i]));
			T2[i] = Math.min((T2[i-1]+a[1][i]),(T1[i-1]+t[0][i]+a[1][i]));
			
		}
		int res = Math.min((T1[3]+x[0]),(T2[3]+x[1]));
		return res;
	}
	public static void main(String[] args) {
		int a[][] = {{4,5,3,2},
		             {2,10,1,4}};
		int t[][] = {{0,7,4,5},
				     {0,9,2,8}};
		
		//e => entry
		int e[] = {10,12};
		//x=> exit
		int[] x = {18,7};
		System.out.println(carAssembly(a,t,e,x));
	}
}
