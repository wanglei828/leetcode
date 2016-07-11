/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int i: nums) {
            set.add(i);
        }
        int max = 1;
        
        for(int i: nums) {
            if(!set.contains(i)) continue;
            set.remove(i);
            int left = i-1;
            int right = i+1;
            int count = 1;

            while(set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }
            while(set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            } 
            max = Math.max(max, count);
        }
        return max;
    }
}
