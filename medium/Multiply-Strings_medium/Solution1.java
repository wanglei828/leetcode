public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) return null;
        int n1 = num1.length();
        int n2 = num2.length();
        int[] res = new int[n1+n2];
        for(int i=n1-1; i>=0; i--) {
            for(int j=n2-1; j>=0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i+j, p2 = i+j+1;
                int sum = mul + res[p2];
                res[p1] += sum/10;
                res[p2] = sum%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i : res) {
            if(i == 0 && sb.length() == 0) continue;
            sb.append(i);
        }
        return (sb.length() == 0)? "0" : sb.toString();
    }
}
