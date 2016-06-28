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
        helper(0, nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(List<Integer> list : res) {
            List<Integer> newList = new ArrayList<Integer>();
            for(Integer i:list) {
                newList.add(nums[i]);
            }
            result.add(newList);
        }
        return result;
    }
    private void helper(int index, int[] nums) {
        if(index == nums.length) {
            List<Integer> list = new ArrayList<Integer>();
            res.add(list);
            return;
        }
        helper(index+1, nums);
        int size = res.size();
        for(int i=0; i<size; i++) {
            List<Integer> list = res.get(i);
            if(index == nums.length-1 || nums[index] != nums[index+1]) {
                List<Integer> copy = new ArrayList<Integer>();
                copy.add(index);
                for(Integer k:list) {
                    copy.add(k);
                }
                res.add(copy);
            } else {
                if(list.contains(index+1)) {
                    List<Integer> copy = new ArrayList<Integer>();
                    copy.add(index);
                    for(Integer k:list) {
                        copy.add(k);
                    }
                    res.add(copy);
                }
            }
        }
    }
}
