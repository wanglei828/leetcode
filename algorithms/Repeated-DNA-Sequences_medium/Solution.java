/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for(int i = 0; i <= s.length() - 10; i++) {
            String substr = null;
            substr = s.substring(i, i+10);
            int v = transfer(substr);
            if(map.containsKey(v) && map.get(v)) {
                result.add(substr);
                map.put(v, false);
            } else if(!map.containsKey(v)) {
                map.put(v, true);
            }
        }
        return result;
    }
    
    private int transfer(String s) {
        int v = 0;
        for(int i = 0; i < s.length(); i++) {
            int tmp = 0;
            switch(s.charAt(i)) {
                case 'A': tmp = 0; break;
                case 'C': tmp = 1; break;
                case 'G': tmp = 2; break;
                case 'T': tmp = 3; break;
            }
            v <<= 2;
            v |= tmp;
        }
        return v;
    }
}
