/*
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
*/

class Solution {
    public int findMaxLength(int[] nums) {
        Stack<Integer> st = new Stack<>();
        HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (st.isEmpty() || st.peek() == nums[i]) {
                st.push(nums[i]);
            } else {
                st.pop();
            }
            if (st.isEmpty()) {
                res = Math.max(res, i+1);
            } else {
                Pair<Integer, Integer> cur = null;
                if (st.peek() == 0) {
                    cur = new Pair<>(st.size(), 0);
                } else {
                    cur = new Pair<>(0, st.size());
                }
                if (map.containsKey(cur)) {
                    res = Math.max(res, i - map.get(cur));
                } else {
                    map.put(cur, i);
                }
            }
        }
        return res;
    }
}
