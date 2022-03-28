/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. 
If the number of spaces on a line do not divide evenly between words, 
the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

click to show corner cases.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
*/

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        if(words == null || words.length == 0) return res;
        int n = words.length;
        int s=0, e=0;
        while(s<n){
            int len = -1;
            e = s;
            while(e<n && len+words[e].length()+1<= maxWidth) {
                len += words[e].length() + 1;
                e++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(words[s]);
            if(e != s+1 && e != n) {
                int spaces = (maxWidth - len)/(e-s-1) + 1;
                int extra =  (maxWidth - len)%(e-s-1);
                for(int i=s+1; i<e; i++) {
                    for(int k=0; k<spaces; k++) {
                        sb.append(" ");
                    }
                    if(extra >0) {
                        sb.append(" ");
                        extra--;
                    }
                    sb.append(words[i]);
                }
            } else {
                int spaces = maxWidth - len;
                for(int i=s+1; i<e; i++) {
                    sb.append(" ");
                    sb.append(words[i]);
                }
                for(int i=0; i<spaces; i++) {
                    sb.append(" ");
                }
            }
            res.add(sb.toString());
            s = e;
        }
        return res;
    }
}
