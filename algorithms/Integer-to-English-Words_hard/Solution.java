/*
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
*/

public class Solution {
    static Map<Integer, String> map = new HashMap<Integer, String>();
    static Map<Integer, String> digit = new HashMap<Integer, String>();
    static Map<Integer, String> tens = new HashMap<Integer, String>();
    static Map<Integer, String> teens = new HashMap<Integer, String>();
    static {
        map.put(1, "Thousand");
        map.put(2, "Million");
        map.put(3, "Billion");
        digit.put(1, "One");
        digit.put(2, "Two");
        digit.put(3, "Three");
        digit.put(4, "Four");
        digit.put(5, "Five");
        digit.put(6, "Six");
        digit.put(7, "Seven");
        digit.put(8, "Eight");
        digit.put(9, "Nine"); 
        tens.put(2, "Twenty");
        tens.put(3, "Thirty");
        tens.put(4, "Forty");
        tens.put(5, "Fifty");
        tens.put(6, "Sixty");
        tens.put(7, "Seventy");
        tens.put(8, "Eighty");
        tens.put(9, "Ninety");
        teens.put(10, "Ten");
        teens.put(11, "Eleven");
        teens.put(12, "Twelve");
        teens.put(13, "Thirteen");
        teens.put(14, "Fourteen");
        teens.put(15, "Fifteen");
        teens.put(16, "Sixteen");
        teens.put(17, "Seventeen");
        teens.put(18, "Eighteen");
        teens.put(19, "Nineteen");
    };
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int level = 0;
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            int tmp = num%1000;
            num = num/1000;
            convert(tmp, sb, level);
            level++;
        }
        return sb.toString();
    }
    
    private void convert(int num, StringBuilder sb, int level) {
        if(num == 0) return;
        if(level != 0) {
            if(sb.length()>0) {
                sb.insert(0, " ");
            }
            sb.insert(0, map.get(level));
        }
        StringBuilder str = new StringBuilder();
        if(num/100 > 0) {
            int tmp = num/100;
            str.append(digit.get(tmp));
            str.append(" Hundred");
            num = num%100;
        }
        if(teens.containsKey(num)) {
            if(str.length() != 0) {
                str.append(" ");
            }
            str.append(teens.get(num));
        } else {
            int tmp = num/10;
            if(tmp > 0) {
                if(str.length() != 0) {
                    str.append(" ");
                }
	            str.append(tens.get(tmp));
            }
            num = num%10;
            if(num != 0) {
                if(str.length() != 0) {
                    str.append(" ");
                }
                str.append(digit.get(num));
            }
        }
        if(sb.length() != 0) {
            sb.insert(0, " ");
        }
        sb.insert(0, str.toString());
    }
}
