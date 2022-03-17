
/*
Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. 
If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.

 

Example 1:

Input: n = 12
Output: 21
Example 2:

Input: n = 21
Output: -1
 

Constraints:

1 <= n <= 231 - 1
*/


class Solution {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        char[] na = s.toCharArray();
        int l = na.length;
        int index = -1;
        for(int i = l-2; i>=0; i--) {
            if (na[i+1] > na[i]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return -1;
        }
        int target = index+1;
        for (int j = index+1; j < l; j++) {
            if (na[index] < na[j]) {
                target = j;
            } else {
                break;
            }
        }
        //swap
        char tmp = na[target];
        na[target] = na[index];
        na[index] = tmp;
        // reverse
        int i = index+1;
        int j = l-1;
        while (i < j) {
            tmp = na[i];
            na[i] = na[j];
            na[j] = tmp;
            i++;
            j--;
        }
        try {
            return Integer.parseInt(new String(na));
        } catch(Exception e) {
            return -1;
        }       
    }
}
