/*
Given a set of distinct positive integers, 
find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

nums: [1,2,3]

Result: [1,2] (of course, [1,3] will also be ok)
Example 2:

nums: [1,2,4,8]

Result: [1,2,4,8]
*/

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return res;
        int n = nums.length;
        int[] pre = new int[n];
        int[] premax = new int[n];
        Arrays.fill(premax, -1);
        Arrays.fill(pre, 1);
        Arrays.sort(nums);
        int max = 1;
        int cur = 0;
        for(int i=1; i<n; i++) {
            for(int j=i-1; j>=0; j--) {
                if(nums[i]%nums[j] == 0) {
                    if(pre[j]+1 > pre[i]) {
                        premax[i] = j;
                        pre[i] = pre[j] + 1;
                    }
                    if(max < pre[i]) {
                        cur = i;
                        max = pre[i];
                    }
                }
            }
        }
        if(max == 1) {
            res.add(nums[0]);
            return res;
        }
        while(cur != -1) {
            res.add(0, nums[cur]);
            cur = premax[cur];
        }
        return res;
    }
}
