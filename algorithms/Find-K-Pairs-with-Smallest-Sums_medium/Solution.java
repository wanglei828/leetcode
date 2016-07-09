/*
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 

Return: [1,3],[2,3]

All possible pairs are returned from the sequence:
[1,3],[2,3]
*/

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return res;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] index = new int[n1];
        while(k>0) {
            int cur = -1;
            int min = Integer.MAX_VALUE;
            for(int i=0; i<n1; i++) {
                if(index[i] >= n2) continue;
                if(nums1[i]+nums2[index[i]] < min) {
                    min = nums1[i]+nums2[index[i]];
                    cur = i;
                }
            }
            if(cur == -1) break;
            int[] tmp = new int[2];
            tmp[0] = nums1[cur];
            tmp[1] = nums2[index[cur]];
            res.add(tmp);
            index[cur]++;
            k--;
        }
        return res;
    }
}
