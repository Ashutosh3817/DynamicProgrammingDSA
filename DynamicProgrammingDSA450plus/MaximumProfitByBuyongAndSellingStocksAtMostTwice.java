package DynamicProgrammingDSA450plus;

import java.util.ArrayList;

public class MaximumProfitByBuyongAndSellingStocksAtMostTwice {
	public static int buyAndSellStock(int[] arr,int n ) {
		//mpist = > maximum profit if sold today
		//leastsf => least so far
		int mpist = 0 ;
		int leastsf = arr[0];
		int[] dpl = new int[n];//dpl => dpleft
		for(int i=1;i<n;i++) {
			if(arr[i]<leastsf) {
				leastsf = arr[i];
			}
			mpist = arr[i] - leastsf;
			if(mpist>dpl[i-1]) {
				System.out.println(dpl[i-1]);
				dpl[i] = mpist;
			}
			else {
				dpl[i] = dpl[i-1];
			}
		}
		int mpibt = 0 ;
		int maxat = arr[n-1];
		int dpr[] = new int[n];
		for(int i=arr.length-2;i>=0;i--) {
			if(arr[i]>maxat) {
				maxat = arr[i];
			}
			mpibt = maxat - arr[i];
			if(mpibt > dpr[i+1]) {
				dpr[i] = mpibt;
			}
			else {
				dpr[i] = dpr[i+1];
			}
		}
		int op = 0 ;//op=> overall profit
		for(int i=0;i<n;i++) {
			if(dpl[i] + dpr[i]>op) {
				op = dpl[i] + dpr[i];
			}
		}
		return op;
	}
	public static void main(String[] args) {
		int[] arr = {10,22,5,75,65,80};
		int n = arr.length;
		System.out.println(buyAndSellStock(arr,n));
	}
}
