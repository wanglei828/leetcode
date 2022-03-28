/*
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

public class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return res;
        helper(nums, 0, new ArrayList<Integer>());
        return res;
    }
    private void helper(int[] nums, int index, List<Integer> list) {
        res.add(list);
        for(int i=index; i<nums.length; i++) {
            List<Integer> copy = new ArrayList<Integer>(list);
            copy.add(nums[i]);
            helper(nums, i+1, copy);
        }
    }
}
