// Assignment 3 - Question 3 CombinationSums
import java.util.*;

public class LetterCombinationPhoneNumbers {
	char[][] values = new char[][]{
			{'a', 'b', 'c'},
			{'d', 'e', 'f'},
			{'g', 'h', 'i'},
			{'j', 'k', 'l'},
			{'m', 'n', 'o'},
			{'p', 'q', 'r', 's'},
			{'t', 'u', 'v'},
			{'w', 'x', 'y', 'z'}
	};
	
	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0) return new ArrayList<>();
		Set<String> set = new HashSet<>();
		int n= 1;
		for (int i = 0; i < digits.length(); i++) {
			int len = values[digits.charAt(i) - '0' - 2].length;
			n*= len;
		}
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		while (set.size() < n) {
			for (int i = 0; i < digits.length(); i++) {
				char[] temp = values[digits.charAt(i) - '0' - 2];
				int idx = random.nextInt(temp.length);
				sb.append(temp[idx]);
			}
			set.add(sb.toString());
			sb.setLength(0);
		}
		return new ArrayList<>(set);
	}
	
}

