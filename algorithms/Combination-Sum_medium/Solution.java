/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/

public class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(candidates, 0, target, null);
        return res;
    }
    
    private void helper(int[] nums, int start, int target, List<Integer> list) {
        if(target == 0 && list != null) {
            List<Integer> copy = new ArrayList<Integer>();
            for(Integer item: list) {
                copy.add(item);
            }
            res.add(copy);
            return;
        }
        list = (list != null)? list: new ArrayList<Integer>();
        int size = list.size();
        for(int i=start; i< nums.length; i++) {
            if(target < nums[i]) break;
            list.add(nums[i]);
            helper(nums, i, target-nums[i], list);
            list.remove(size);
        }
    }
}
