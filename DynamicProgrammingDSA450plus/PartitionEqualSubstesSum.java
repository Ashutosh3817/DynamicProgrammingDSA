package DynamicProgrammingDSA450plus;

public class PartitionEqualSubstesSum {
	public static boolean isPartition(int[] arr,int n,int k) {
		boolean[] vis = new boolean[n];
		int target = 0;
		for(int i:arr) target += i;
		if(target%k!=0) return false;
	    if(n<k) return false;
	    return partition(0,0,0,target,k,vis,arr);
	}
	public static boolean partition(int i ,int sum,int count,int target,int k ,boolean[] vis , int[] a) {
		 if(sum>target/k) return false;
		 
		if(count==k) return true;
		for(int j=0;j<a.length;j++) {
			if(vis[j]==false) {
				vis[j] = true;
				sum +=a[j];
				int tempSum = sum;
				if(sum==target/k) {
					tempSum = 0;
					count +=1;
				}
				if(partition(j,sum,count,target,k,vis,a)) return true;
				if(sum>target/k) {
					count--;
					sum-=a[i];
					vis[j]=false;
				}
				
			}
			
		}
		return true;
	}
	public static void main(String[] args) {
		int[] arr = {10,5,5};
		System.out.println(isPartition(arr,arr.length,2));
	}
}
