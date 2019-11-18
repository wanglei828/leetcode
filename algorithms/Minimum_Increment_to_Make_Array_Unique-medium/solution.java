/*

Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.

Return the least number of moves to make every value in A unique.

 

Example 1:

Input: [1,2,2]
Output: 1
Explanation:  After 1 move, the array could be [1, 2, 3].
Example 2:

Input: [3,2,1,2,1,7]
Output: 6
Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 

Note:

0 <= A.length <= 40000
0 <= A[i] < 40000

*/

class Solution {
    public int minIncrementForUnique(int[] A) {
        int[] count = new int[40000];
        for(int a:A) {
            count[a]++;
        }
        int res = 0;
        int dupCount = 0, dupSum = 0;
        for(int i=0; i<40000; i++) {
            if(count[i] > 1) {
                dupCount += count[i]-1;
                dupSum += i*(count[i]-1);
            } else if(dupCount > 0 && count[i] == 0) {
                dupCount--;
                res += i;
            }
        }
        int next = 40000;
        while(dupCount > 0) {
            res += next;
            dupCount--;
            next++;
        }
        return res - dupSum;
    }
}
