package DynamicProgrammingDSA450plus;

import java.util.LinkedList;
import java.util.List;
//First In First Out Approach
public class LetterCombinationsOfAPhoneNumber {
	public static List<String> letterCombinations(String digits){
		LinkedList<String> output_arr = new LinkedList<String>();
		if(digits.length()==0) return output_arr;
		output_arr.add("");
		String[] char_map = new String[] {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		for(int i=0;i<digits.length();i++) {
			int index = Character.getNumericValue(digits.charAt(i));//for converting into int
			
			while(output_arr.peek().length()==i) {
				String permutation = output_arr.remove();
				System.out.println(permutation);
				for(char c : char_map[index].toCharArray()) {
					output_arr.add(permutation + c);
				}
			}
		}
		return output_arr;
	}
	public static void main(String[] args) {
		String digits = "23";
		System.out.println(letterCombinations(digits));
	}
}    