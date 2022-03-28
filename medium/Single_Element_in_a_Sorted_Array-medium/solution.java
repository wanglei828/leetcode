/*

You are given a sorted array consisting of only integers where every element appears exactly twice, 
except for one element which appears exactly once. Find this single element that appears only once.

Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10
 
Note: Your solution should run in O(log n) time and O(1) space.

*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int h = 0, t = nums.length-1;
        while(h<=t) {
            int m = h+ (t-h)/2;
            if(m == h || m == t) break;
            if((m-h)%2 == 0) {
                if(nums[m] == nums[m-1]) {
                    t = m - 2;
                } else if(nums[m] == nums[m+1]) {
                    h = m + 2;
                } else {
                    return nums[m];
                }
                    
            } else {
                 if(nums[m] == nums[m-1]) {
                    h = m + 1;
                } else if(nums[m] == nums[m+1]) {
                    t = m - 1;
                } else {
                    return nums[m];
                }               
            }
        }
        return nums[h];
    }
}
