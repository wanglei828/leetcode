/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/

public class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        int last = -1;
        list = (list != null)? list : (new ArrayList<Integer>());
        int size = list.size();
        for(int i=start; i<nums.length; i++) {
            if(last == -1) {
                last = i;
            }
            while(i<nums.length && i>start && nums[i] == nums[last]) i++;
            if(i == nums.length) break;
            if(target < nums[i]) break;
            list.add(nums[i]);
            last = i;
            helper(nums, i+1, target-nums[i], list);
            list.remove(size);
        }
    }
}
