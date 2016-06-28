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
        helper(nums, 0);
        return res;
    }
    private void helper(int[] nums, int i) {
        if(i == nums.length) {
             res.add(new ArrayList<Integer>());
             return;
        }
        helper(nums, i+1);
        int size = res.size();
        for(int k=0; k<size; k++) {
            List<Integer> list = res.get(k);
            List<Integer> copy = new ArrayList<Integer>();
            copy.add(nums[i]);
            for(Integer j:list) {
                copy.add(j);
            }
            res.add(copy);
        }
    }
}
