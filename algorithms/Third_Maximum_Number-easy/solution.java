/*

Given a non-empty array of integers, return the third maximum number in this array. 
If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.

*/

class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int k=3;
        while(k > 0) {
            int max = Integer.MIN_VALUE;
            boolean flag = false;
            for(int i=0; i<nums.length; i++) {
                int cur = nums[i];
                if(set.contains(cur)) continue;
                if(max <= cur) {
                    max = cur;
                    flag = true;
                }
            }
            if(flag) set.add(max);
            k--;
        }
        if(set.size() == 3) {
            int min = Integer.MAX_VALUE;
            for(Integer i: set) {
                if(min >= i) {
                    min = i;
                }
            }
            return min;
        } else {
            int max = Integer.MIN_VALUE;
            for(Integer i: set) {
                if(max <= i) {
                    max = i;
                }
            }
            return max;
        }
    }
}
