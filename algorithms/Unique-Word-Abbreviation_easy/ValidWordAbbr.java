/*
An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
*/

public class ValidWordAbbr {

    Map<String, Integer> abbr = new HashMap<String, Integer>();
    Set<String> set = new HashSet<String>();
    public ValidWordAbbr(String[] dictionary) {
        if(dictionary == null || dictionary.length == 0) return;
        for(int i=0; i<dictionary.length; i++) {
            String s = dictionary[i];
            if(set.contains(s)) continue;
            set.add(s);
            String sabbr = getAbbr(s);
            if(abbr.containsKey(sabbr)) {
                abbr.put(sabbr, abbr.get(sabbr)+1);
            } else {
                abbr.put(sabbr, 1);
            }
        }
    }
    private String getAbbr(String s) {
        if(s.length() <=2) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.length()-2);
        sb.append(s.charAt(s.length()-1));
        return sb.toString();
    }

    public boolean isUnique(String word) {
        String wabbr = getAbbr(word);
        return !abbr.containsKey(wabbr) || (set.contains(word) && abbr.get(wabbr) == 1);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");

