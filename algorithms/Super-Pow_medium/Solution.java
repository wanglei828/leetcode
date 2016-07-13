/*
Your task is to calculate ab mod 1337 where a is a positive integer and 
b is an extremely large positive integer given in the form of an array.

Example1:

a = 2
b = [3]

Result: 8
Example2:

a = 2
b = [1,0]

Result: 1024
*/

import java.math.BigInteger;
public class Solution {
    long base = 1337;
    public int superPow(int a, int[] b) {
        long la = (long)a;
        long mod = la%base;
        long index = 1;
        Map<Long, Long> map = new HashMap<Long, Long>();
        Map<Long, Long> rmap = new HashMap<Long, Long>();
        while(!map.containsKey(mod)) {
            map.put(mod, index);
            rmap.put(index, mod);
            mod = la*mod%base;
            index++;
        }
        long start = map.get(mod);
        long loop = index - start;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<b.length; i++) {
            sb.append(b[i]);
        }
        BigInteger b0 = new BigInteger(sb.toString());
        if(b0.compareTo(BigInteger.valueOf(0)) == 0) return 1; 
        if(b0.compareTo(BigInteger.valueOf(start)) <= 0) {
            return rmap.get(b0.longValue()).intValue();
        } else {
            BigInteger b1 = b0.subtract(BigInteger.valueOf(start));
            long res = b1.mod(BigInteger.valueOf(loop)).add(BigInteger.valueOf(start)).longValue();
            return rmap.get(res).intValue();
        }
    }
}
