/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length == 0) return res;
        Arrays.sort(nums);
        helper(0, nums, new ArrayList<Integer>());
        return res;
    }
    private void helper(int index, int[] nums, List<Integer> cur) {
        res.add(cur);
        for(int i=index; i<nums.length; i++) {
            if(i>index && nums[i] == nums[i-1]) continue;
            List<Integer> copy = new ArrayList<Integer>(cur);
            copy.add(nums[i]);
            helper(i+1, nums, copy);
        }
    }
}
