/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].
*/

public class Solution {
    List<String> res = new ArrayList<String>();
    public List<String> findStrobogrammatic(int n) {
        if(n == 0) return res;
        char[] arr = new char[n];
        helper(arr, 0, n);
        return res;
    }
    
    private void helper(char[] arr, int start, int n) {
        int half = (n%2 == 0)? n/2 : n/2+1;
        if(start == half) {
            res.add(new String(arr));
            return;
        }
        char[] set = {'0', '1', '8', '6', '9'};
        int j = (start == 0)? 1 : 0;
        if(n%2 == 0 || start < half-1) {
            for(; j<set.length; j++) {
                arr[start] = set[j];
                if(arr[start] == '6') {
                    arr[n-1-start] = '9';
                } else if(arr[start] == '9') {
                    arr[n-1-start] = '6';
                } else {
                    arr[n-1-start] = arr[start];
                }
                helper(arr, start+1, n);
            }
        } else {
            for(j=0; j<3; j++) {
                arr[start] = set[j];
                helper(arr, start+1, n);
            }
        }
    }
}
