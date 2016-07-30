/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
*/

public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0 ) return false;
        char[] c = num.toCharArray();
        int h = 0, t = c.length-1;
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('0', '0');
        map.put('1','1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        while(h<=t) {
            if(h < t && (!map.containsKey(c[h]) || map.get(c[h]) != c[t])) {
                return false;
            } else if(h == t && c[h] != '0' && c[h] != '1' && c[h] != '8'){
                return false;
            }
            h++;
            t--;
        }
        return true;
    }
}
