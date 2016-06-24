/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

public class Solution {
    public String addBinary(String a, String b) {
        if(a == null && b == null) return "";
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;
        int la = a.length();
        int lb = b.length();
        if(la > lb) return addBinary(b, a);
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = la-1;
        int j = lb-1;
        while(i>=0 && j>=0) {
            int sum = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            res.insert(0, sum%2);
            carry = sum/2;
            i--;
            j--;
        }
        while(j>=0) {
            int sum = b.charAt(j) - '0' + carry;
            res.insert(0, sum%2);
            carry = sum/2;
            j--;
        }
        if(carry == 1) {
            res.insert(0, carry);
        }
        return res.toString();
    }
}
