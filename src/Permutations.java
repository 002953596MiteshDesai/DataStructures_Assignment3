// Assignment 3 - Question 2 Permutations

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		LinkedList<Integer> currentSeq = new LinkedList<Integer>();
		
		int current = 0;
		ArrayList<Integer> nums_lst = new ArrayList<Integer>();
		for (int num : nums)
			nums_lst.add(num);
		
		int n = nums.length;
		genPermutations(nums_lst, n, current, output);
		
		return output;
	}
	
	public static void genPermutations(ArrayList<Integer> nums, int n, int current, List<List<Integer>> output){
		if (current == n) {
			output.add(new ArrayList<Integer>(nums));
		}
		
		for (int i = current; i < n; i++){
			Collections.swap(nums, current, i);
			genPermutations(nums, n, current+1, output);
			Collections.swap(nums, current, i);
		}
		
		
	}
}
