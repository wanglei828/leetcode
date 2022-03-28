/*

A string S represents a list of words.

Each letter in the word has 1 or more options.  If there is one option, the letter is represented as is.  
If there is more than one option, then curly braces delimit the options.  
For example, "{a,b,c}" represents options ["a", "b", "c"].

For example, "{a,b,c}d{e,f}" represents the list ["ade", "adf", "bde", "bdf", "cde", "cdf"].

Return all words that can be formed in this manner, in lexicographical order.

 

Example 1:

Input: "{a,b}c{d,e}f"
Output: ["acdf","acef","bcdf","bcef"]
Example 2:

Input: "abcd"
Output: ["abcd"]
 

Note:

1 <= S.length <= 50
There are no nested curly brackets.
All characters inside a pair of consecutive opening and ending curly brackets are different.

*/

class Solution {
    public String[] expand(String S) {
        List<StringBuilder> list = new ArrayList<>();
        int n = S.length();
        for(int i=0; i<n; i++) {
            char c = S.charAt(i);
            if(c != '{') {
                if(list.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(c);
                    list.add(sb);
                } else {
                    for(StringBuilder sb: list) {
                        sb.append(c);
                    }
                }
            } else {
                int j = i;
                while(S.charAt(j) != '}') j++;
                String sub = S.substring(i+1, j);
                String[] sarr = sub.split(",");
                if(list.isEmpty()) {
                    for(String s: sarr) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(s);
                        list.add(sb);
                    }
                } else {
                    int size = list.size();
                    for(int k=1; k<sarr.length; k++) {
                        for(int m=0; m<size; m++) {
                            StringBuilder newsb = new StringBuilder(list.get(m));
                            newsb.append(sarr[k]);
                            list.add(newsb);
                        }
                    }
                    for(int k=0; k<size; k++) {
                        StringBuilder sb = list.get(k);
                        sb.append(sarr[0]);
                    }
                }
                i = j;
            }
        }
        String[] res = new String[list.size()];
        for(int i=0; i<res.length; i++) {
            res[i] = list.get(i).toString();
        }
        Arrays.sort(res);
        return res;
    }
}
