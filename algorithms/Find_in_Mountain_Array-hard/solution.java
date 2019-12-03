/*

You may recall that an array A is a mountain array if and only if:

A.length >= 3
There exists some i with 0 < i < A.length - 1 such that:
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.  
If such an index doesn't exist, return -1.

You can't access the mountain array directly.  
You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer.  
Also, any solutions that attempt to circumvent the judge will result in disqualification.

 

Example 1:

Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
Example 2:

Input: array = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.
 

Constraints:

3 <= mountain_arr.length() <= 10000
0 <= target <= 10^9
0 <= mountain_arr.get(index) <= 10^9

*/

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int m = findMid(mountainArr);
        int h =0, t = m;
        while(h<=t) {
            int mid = (h+t)/2;
            int cur = mountainArr.get(mid);
            if(cur == target) {
                return mid;
            } else if (cur < target) {
                h = mid + 1;
            } else {
                t = mid - 1;
            }
        }
        h = m+1;
        t = mountainArr.length()-1;
        while(h<=t) {
            int mid = (h+t)/2;
            int cur = mountainArr.get(mid);
            if(cur == target) {
                return mid;
            } else if (cur < target) {
                t = mid - 1;
            } else {
                h = mid + 1;
            }            
        }
        return -1;
    }
    
    private int findMid(MountainArray M) {
        int h = 0;
        int t = M.length();
        while(h<t) {
            int mid = (h+t+1)/2;
            if(M.get(mid-1) > M.get(mid)) {
                t = mid-1;
            } else {
                h = mid;
            }
        }
        return h;
    }
}
