/*

Given an array A of integers, return the length of the longest arithmetic subsequence in A.

Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k] with 0 <= i_1 < i_2 < ... < i_k <= A.length - 1, and that a sequence B is arithmetic if B[i+1] - B[i] are all the same value (for 0 <= i < B.length - 1).

 

Example 1:

Input: [3,6,9,12]
Output: 4
Explanation: 
The whole array is an arithmetic sequence with steps of length = 3.
Example 2:

Input: [9,4,7,2,10]
Output: 3
Explanation: 
The longest arithmetic subsequence is [4,7,10].
Example 3:

Input: [20,1,15,3,10,5,8]
Output: 4
Explanation: 
The longest arithmetic subsequence is [20,15,10,5].

Note:

2 <= A.length <= 2000
0 <= A[i] <= 10000
*/

class Solution {
    public int longestArithSeqLength(int[] A) {
        int n = A.length, max = 2;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        map.put(n-1, new HashMap<Integer, Integer>());
        for(int i=n-2; i>=0; i--) {
            map.put(i, new HashMap<Integer, Integer>());
            for(int j=n-1; j>i; j--) {
                int gap = A[j] - A[i];
                int len = 2;
                if(map.get(j).containsKey(gap)) {
                    len = map.get(j).get(gap) + 1;
                }
                map.get(i).put(gap, len);
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
