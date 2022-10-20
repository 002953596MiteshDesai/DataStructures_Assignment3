// Assignment 3 - Question 7 GenParentheses

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> output = new ArrayList<String>();
		if(n <= 0 ){
			return null ;
		}
		int[] result = new int[n*2];
		int current = 0;
		generateParenthesis(result, current, output);
		return output;
	}
	
	private static void generateParenthesis(int[] result, int current, List<String> output){
		if(current == result.length){
			printParenthesis(result, output);
			return;
		}
		for(int i = 0 ; i < 2; i ++){
			result[current] = i;
			generateParenthesis(result, current + 1, output);
		}
	}
	
	private static void printParenthesis(int[] result, List<String> output){
		StringBuilder sb = new StringBuilder();
		for (int i: result) {
			sb.append( i == 0 ? "(" : ")");
		}
		if(isValidParenthesis(sb.toString())){
			//System.out.println(sb.toString());
			output.add(sb.toString());
		}
	}
	
	private static boolean isValidParenthesis(String str){
		Stack<Character> stack = new Stack<>();
		for (Character ch : str.toCharArray()) {
			if(ch == '('){
				stack.push(ch);
			}else{
				if(stack.empty()){
					return false;
				}
				stack.pop();
			}
		}
		return  stack.empty();
		
	}
	
}
