package DynamicProgrammingDSA450plus;

public class LongestPalindromicSubstring {
	public static String palindromic(String s) {
		int n = s.length();
		int maxLength=1;
		int start=0;
		int low , high;
		for(int i=1;i<n;i++) {
			    low=i-1;
			    high = i;
			  //even length of palindrome
			while(low>=0 && high<n && s.charAt(low)==s.charAt(high)) {
				if(high-low+1>maxLength) {
					start = low;
					maxLength = high-low+1;
				}
				low--;
				high++;
			}
			//odd length of palindrome
			low=i-1;
			high=i+1;
			while(low>=0&&high<n && s.charAt(low)==s.charAt(high)) {
				if(high-low+1>maxLength) {
					start = low;
					maxLength = high-low+1;
					
				}
				low--;
				high++;
			}
		}
		return s.substring(start,start+maxLength);
	}
	public static void main(String[] args) {
		String s = "babad";
		System.out.println(palindromic(s));
	}
}
