/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if((len1+len2)%2 != 0) {
            return (double)findkth(nums1, nums2, 0, len1-1, 0, len2-1, (len1+len2)/2);
        } else {
            int first = findkth(nums1, nums2, 0, len1-1, 0, len2-1, (len1+len2)/2);
            int second = findkth(nums1, nums2, 0, len1-1, 0, len2-1, (len1+len2)/2 - 1);
            return ((double)first + (double)second)/2;
        }
        
    }
    
    private int findkth(int[] nums1, int[] nums2, int s1, int e1, int s2, int e2, int k) {
        int len1 = e1 - s1 + 1;
        int len2 = e2 - s2 + 1;
        
        if(len1 == 0) {
            return nums2[s2+k];
        }
        if(len2 == 0) {
            return nums1[s1+k];
        }
        if(k == 0) {
            return (nums1[s1] < nums2[s2])? nums1[s1] : nums2[s2];
        }
        
        int m1 = (k*len1)/(len1+len2);
        int m2 = k - m1 -1;
        
        m1 += s1;
        m2 += s2;
        if(nums1[m1] < nums2[m2]) {
            k = k - (m1 - s1 + 1);
            s1 = m1+1;
            e2 = m2;
        } else {
            k = k - (m2 - s2 +1);
            s2 = m2+1;
            e1 = m1;
        }
        return findkth(nums1, nums2, s1, e1, s2, e2, k);
    }
}
