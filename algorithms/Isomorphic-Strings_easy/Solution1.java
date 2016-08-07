public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        String ks = convert(s);
        String kt = convert(t);
        return ks.equals(kt);
    }
    
    private String convert(String str) {
        if("".equals(str)) return "";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int tag = 0, n = str.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            char c = str.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, tag++);
            }
            sb.append(map.get(c));
            sb.append("#");
        }
        return sb.toString();
    }
}
