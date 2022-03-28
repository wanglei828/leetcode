/*
Given an array of integers, find out whether there are two distinct indices i and j in the array such that 
the difference between nums[i] and nums[j] is at most t and 
the difference between i and j is at most k.
*/

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length <2) return false;
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(nums[0]);
        int n = nums.length;
        for(int i=1; i<n; i++) {
            if(set.size() > k) {
                set.remove(nums[i-k-1]);
                if(set.size() == 0) {
                    set.add(nums[i]);
                    continue;
                }
            }
            if(set.ceiling(nums[i]) != null && (long)set.ceiling(nums[i]) - (long)nums[i] <= (long)t) {
                return true;
            }
            if(set.floor(nums[i]) != null && (long)nums[i] - (long)set.floor(nums[i]) <= (long)t) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
