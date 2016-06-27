/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

public class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(nums, null);
        return res;
    }
    
    private void helper(int[] nums, List<Integer> list) {
        if(list != null && list.size() == nums.length) {
            List<Integer> copy = new ArrayList<Integer>();
            for(Integer i: list) {
                copy.add(nums[i]);
            }
            res.add(copy);
            return;
        }
        list = (list != null)? list : new ArrayList<Integer>(); 
        int size = list.size();
        int last = -1;
        for(int i=0; i<nums.length; i++) {
            if(list.contains(i)) {
                continue;
            }
            if(last == -1) {
                last = i;
            } else {
                while(i< nums.length && (nums[i] == nums[last] || list.contains(i)))i++;
            }
            if(i == nums.length) break;
            last = i;
            list.add(i);
            helper(nums, list);
            list.remove(size);
        }
    }
    
}
