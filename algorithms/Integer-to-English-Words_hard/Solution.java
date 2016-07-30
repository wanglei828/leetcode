/*
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
*/

public class Solution {
    private String[] less20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] thousands = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int level = 0;
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            if(num%1000 > 0) {
                String str = convert(num%1000);
                sb.insert(0, thousands[level]);
                if(level != 0) {
                    sb.insert(0, " ");
                }
                sb.insert(0, str);
            }
            num /= 1000;
            level++;
        }
        return sb.toString().trim();
    }
    
    private String convert(int num) {
        if(num == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        if(num < 20) {
            sb.append(less20[num]);
        } else if(num < 100) {
            sb.append(tens[num/10]);
            sb.append(convert(num%10));
        } else {
            sb.append(less20[num/100]);
            sb.append(" Hundred");
            sb.append(convert(num%100));
        }
        return sb.toString();
    }
}
