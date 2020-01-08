/*
Given an array nums, there is a sliding window of size k 
which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
*/

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> q = new LinkedList<Integer>();
        q.add(nums[0]);
        for(int i=1; i<k; i++) {
            int tmp = nums[i];
            while(!q.isEmpty() && q.peekLast() < tmp) {
                q.pollLast();
            }
            q.add(tmp);
        }
        res[0] = q.peek();
        for(int i=k; i<n; i++) {
            int tmp = nums[i];
            if(nums[i-k] == q.peek()) {
                q.poll();
            }
            if(!q.isEmpty()) {
                while(!q.isEmpty() && q.peekLast() < tmp) {
                    q.pollLast();
                }
            }
            q.add(tmp);
            res[i-k+1] = q.peek();
        }
        return res;
    }
}
