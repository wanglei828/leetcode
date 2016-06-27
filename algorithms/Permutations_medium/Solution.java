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
        helper(null, nums);
        return res;
    }
    private void helper(List<Integer> list, int[] nums){
        if(list != null && list.size()==nums.length) {
            List<Integer> copy = new ArrayList<Integer>();
            for(Integer i:list) {
                copy.add(i);
            }
            res.add(copy);
            return;
        }
        list = (list == null)? new ArrayList<Integer>() : list;
        int size = list.size();
        for(int i=0; i<nums.length; i++) {
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(list, nums);
            list.remove(size);
        }
    }
}
