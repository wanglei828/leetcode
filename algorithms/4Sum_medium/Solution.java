/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length<4) return res;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n-3; i++) {
            if(i !=0 && nums[i] == nums[i-1]) {
                continue;
            }
            for(int j=i+1; j<n-2; j++) {
                if(j != i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int h = j+1;
                int t = n-1;
                while(h<t) {
                    int sum = nums[i] + nums[j] + nums[h] + nums[t];
                    if(sum == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[h]);
                        list.add(nums[t]);
                        res.add(list);
                        h++;
                        t--;
                        while(h<t && nums[h] == nums[h-1]) h++;
                        while(h<t && nums[t] == nums[t+1]) t--;                        
                    } else if(sum < target) {
                        h++;
                        while(h<t && nums[h] == nums[h-1]) h++;
                    } else {
                        t--;
                        while(h<t && nums[t] == nums[t+1]) t--;
                    }
                }
            }
        }
        return res;
    }
}
