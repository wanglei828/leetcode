/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        if(denominator == 1) return String.valueOf(numerator);
        if(denominator == -1) return String.valueOf(0-(long)numerator);
        long numLong = Math.abs((long)numerator);
        long denLong = Math.abs((long)denominator);
        long front = numLong/denLong;
        long res = numLong%denLong;
        StringBuilder sb = new StringBuilder();
        if(numerator < 0 && denominator > 0 || numerator>0 && denominator<0) {
            sb.append("-");
        }
        sb.append(String.valueOf(front));
        if(res != 0) {
            sb.append(".");
            sb.append(get(res, denLong));
        }
        return sb.toString();
    }
    
    private String get(long res, long den) {
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(!map.containsKey(res)) {
            map.put(res, i);
            long tmp = res*10;
            res = tmp%den;
            long result = tmp/den;
            sb.append(String.valueOf(result));
            if(res == 0) {
                return sb.toString();
            }
            i++;
        }         
        i = map.get(res);
        sb.insert(i, "(");
        sb.append(")");
        return sb.toString();
    }
}
