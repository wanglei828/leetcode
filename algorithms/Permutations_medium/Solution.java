/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

public class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return res;
        List<Integer> list = new ArrayList<Integer>();
        helper(list, nums);
        return res;
    }
    private void helper(List<Integer> list, int[] nums){
        if(list.size()==nums.length) {
            List<Integer> copy = new ArrayList<Integer>();
            for(Integer i:list) {
                copy.add(nums[i]);
            }
            res.add(copy);
            return;
        }
        int size = list.size();
        for(int i=0; i<nums.length; i++) {
            if(list.contains(i)) continue;
            list.add(i);
            helper(list, nums);
            list.remove(size);
        }
    }
}
