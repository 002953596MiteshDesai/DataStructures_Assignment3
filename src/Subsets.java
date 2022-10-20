// Assignment 3 - Question 6 Subsets
import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		
		if(nums.length <= 0 ){
			return null;
		}
		
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		int[] result = new int[nums.length];
		int current = 0 ;
		subsets(result, current, nums, output);
		return output;
	}
	
	
	private static void subsets(int[] result, int current, int[] nums,List<List<Integer>> output ){
		
		if(current == result.length){
			printSubsets(result, nums, output);
			return;
		}
		
		for(int i = 0 ; i < 2; i ++){
			result[current] = i;
			subsets(result, current +1, nums, output);
		}
		
	}
	
	private static void printSubsets(int[] result, int[] nums, List<List<Integer>> output){
		List<Integer> miniOutput = new ArrayList<Integer>();
		
		
		for(int i = 0 ; i < result.length; i ++){
			if(result[i] == 1){
				
				miniOutput.add(nums[i]);
			}
		}
		
		output.add(miniOutput);
	}
	
	
}
