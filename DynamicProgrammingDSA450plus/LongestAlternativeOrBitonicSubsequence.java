package DynamicProgrammingDSA450plus;

public class LongestAlternativeOrBitonicSubsequence {
	public static int bitonic(int[] arr,int n) {
		//longest increasing subsequence
		int[] lis = new int[n];
		for(int i=0;i<n;i++) lis[i] =1;
		for(int i=0;i<arr.length;i++) {
			int max=0;
			for(int j=0;j<i;j++) {
				if(arr[i]>=arr[j]) {
					if(lis[j]>max) {
						max = lis[j];
					}
				}
			}
			lis[i] = max+1;
		}
		int[] lds = new int[n];
		for(int i=0;i<n;i++) lds[i] =1;
		for(int i=arr.length-1;i>=0;i--)  {
			int max=0;
			for(int j=arr.length-1;j>i;j--) {
				if(arr[j]<=arr[i]) {
					if(lds[j]>max) {
						max=lds[j];
					}
				}
			}
			lds[i]=max+1;
		}
		int omax=0;
		//overall maximum
		for(int i=0;i<arr.length;i++) {
			if(lis[i]+lds[i]-1>omax) {
				omax = lis[i]+lds[i]-1;
			}
		}
		return omax;
				
	}
	public static void main(String[] args) {
		//int[] arr = {10,22,9,33,21,50,41,60,80,3};
		int[] arr= {1,17,5,10,13,15,10,5,16,8};
		int n = arr.length;
		System.out.println(bitonic(arr,n));
	}
}
