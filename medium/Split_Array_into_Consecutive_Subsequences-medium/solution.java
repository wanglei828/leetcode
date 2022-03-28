/*

Given an array nums sorted in ascending order, return true if and only if 
you can split it into 1 or more subsequences such that 
each subsequence consists of consecutive integers and has length at least 3.

 

Example 1:

Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3
3, 4, 5

Example 2:

Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3, 4, 5
3, 4, 5

Example 3:

Input: [1,2,3,4,4,5]
Output: False
 

Constraints:

1 <= nums.length <= 10000

*/

class Solution {
    public boolean isPossible(int[] nums) {
        if(nums == null || nums.length < 3) return false;
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: nums) {
            if(freq.containsKey(num)) {
                freq.put(num, freq.get(num) + 1);
            } else {
                freq.put(num, 1);
            }
        }
        Map<Integer, Integer> cur = new HashMap<>();
        for(int num: nums) {
            if(freq.get(num) == 0) continue;
            if(cur.containsKey(num-1) && cur.get(num-1) > 0) {
                freq.put(num, freq.get(num) - 1);
                if(cur.containsKey(num)) {
                    cur.put(num, cur.get(num)+1);
                } else {
                    cur.put(num, 1);
                }
                cur.put(num-1, cur.get(num-1)-1);
            } else {
                if(freq.containsKey(num+1) && freq.get(num+1) > 0 && freq.containsKey(num+2) && freq.get(num+2) > 0) {
                    if(cur.containsKey(num+2)) {
                        cur.put(num+2, cur.get(num+2)+1);
                    } else {
                        cur.put(num+2, 1);
                    }
                    freq.put(num, freq.get(num)-1);
                    freq.put(num+1, freq.get(num+1)-1);
                    freq.put(num+2, freq.get(num+2)-1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
