/*
Given two arrays of length m and n with digits 0-9 representing two numbers. 
Create the maximum number of length k <= m + n from digits of the two. 
The relative order of the digits from the same array must be preserved. 
Return an array of the k digits. You should try to optimize your time and space complexity.

Example 1:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
return [9, 8, 6, 5, 3]

Example 2:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
return [6, 7, 6, 0, 4]

Example 3:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
return [9, 8, 9]
*/

public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(nums1 == null || nums1.length == 0) return getsub(nums2, k);
        if(nums2 == null || nums2.length == 0) return getsub(nums1, k);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[k];
        for(int i=Math.max(k-n2, 0); i<=Math.min(k, n1); i++) {
            int[] res1 = getsub(nums1, i);
            int[] res2 = getsub(nums2, k-i);
            int[] cur = merge(res1, res2, k);
            if(greater(cur, 0, res, 0)) {
                res = cur;
            }
        }
        return res;
    }
    
    private boolean greater(int[] nums1, int s1, int[] nums2, int s2) {
        int n1 = nums1.length, n2 = nums2.length;
        while(s1 < n1 && s2 < n2) {
            if(nums1[s1] < nums2[s2]) {
                return false;
            } else if(nums1[s1] > nums2[s2]) {
                return true;
            } else {
                s1++;
                s2++;
            }
        }
        return (s2 == n2)? true: false;
    }

    private int[] merge(int[] nums1, int[] nums2, int n) {
        int i=0, j=0, k=0;
        int[] res = new int[n];
        String str1 = Arrays.toString(nums1);
        String str2 = Arrays.toString(nums2);
        while(i<nums1.length && j<nums2.length) {
            if(greater(nums1, i, nums2, j)) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }
        while(i<nums1.length) {
            res[k++] = nums1[i++];
        }
        while(j<nums2.length) {
            res[k++] = nums2[j++];
        }
        return res;
    }
    
    private int[] getsub(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) return new int[0];
        if(k == nums.length) return nums;
     	int[] res = new int[k];
    	int n = nums.length;
    	for(int i=n-k; i<n; i++) {
    		res[i+k-n] = nums[i];
    	}
    	for(int i=n-k-1; i>=0; i--) {
    		int cur = nums[i];
    		for(int j=0; j<k; j++) {
    			if(cur < res[j]) {
    				break;
    			} else {
    				int tmp = res[j];
    				res[j] = cur;
    				cur = tmp;
    			}
    		}
    	}
    	return res;       
    }
}
