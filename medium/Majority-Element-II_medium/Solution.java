/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
The algorithm should run in linear time and in O(1) space.
*/

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return res;
        int c1=0, c2=0;
        int v1=0, v2=0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(c1 == 0 || c2 == 0) {
                if(c1 == 0 && c2 == 0) {
                    c1 = 1;
                    v1 = nums[i];
                } else if(c1 == 0 && c2 != 0) {
                    if(v2 == nums[i]) {
                        c2++;
                    } else {
                        c1 = 1;
                        v1 = nums[i];
                    }
                } else if(c1 != 0 && c2 == 0) {
                    if(v1 == nums[i]) {
                        c1++;
                    } else {
                        c2 = 1;
                        v2 = nums[i];
                    }
                }
            } else {
                if(nums[i] == v1) {
                    c1++;
                } else if(nums[i] == v2) {
                    c2++;
                } else {
                    c1--;
                    c2--;
                }
            }
        }
        if(c1 != 0) {
            c1 = 0;
            for(int i:nums) {
                if(i == v1) c1++;
            }
            if(c1 > n/3) res.add(v1);
        }
        if(c2 != 0) {
            c2 = 0;
            for(int i:nums) {
                if(i == v2) c2++;
            }
            if(c2 > n/3) res.add(v2);
        }
        return res;
    }
}
