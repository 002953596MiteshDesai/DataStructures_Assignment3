// Assignment 3 - Question 1 CombinationSums
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		LinkedList<Integer> combResult = new LinkedList<Integer>();
		
		int current = 0;
		combinationSum(combResult, current, candidates, target, output);
		return output;
	}
	
	private static void combinationSum(LinkedList<Integer> combResult, int current, int[] candidates, int target, List<List<Integer>> output){
		if (target == 0){
			output.add(new ArrayList<Integer>(combResult));
			return;
		} else if (target < 0){
			return;
		}
		
		for(int i = current; i < candidates.length; i++){
			combResult.add(candidates[i]);
			combinationSum(combResult, i, candidates, target - candidates[i], output);
			combResult.removeLast();
		}
	}
	
	
	
}
