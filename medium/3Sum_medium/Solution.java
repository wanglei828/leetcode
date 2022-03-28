/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

public class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length <3) return res;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int h = i+1;
            int t = nums.length-1;
            while(h<t) {
                if(nums[i] + nums[h] + nums[t] == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[h]);
                    list.add(nums[t]);
                    res.add(list);
                    h++;
                    t--;
                    while(h<t && nums[h] == nums[h-1])h++;
                    while(h<t && nums[t] == nums[t+1])t--;
                } else if(nums[i] + nums[h] + nums[t] > 0) {
                    t--;
                } else {
                    h++;
                }

            }
        }
        return res;
    }
}
