/*
Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
    private static String M[] = {"","M","MM","MMM"};
    private static String C[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    private static String X[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    private static String I[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int div = 1000;
        return sb.append(M[num/1000]).append(C[num%1000/100]).append(X[num%1000%100/10]).append(I[num%1000%100%10]).toString();
    }
}
