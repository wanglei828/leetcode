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
    List<String> res = new ArrayList<String>();
    public List<String> fullJustify(String[] words, int maxWidth) {
        helper(words, maxWidth, 0);
        return res;
    }
    
    private void helper(String[] words, int max, int s) {
        if(words == null) return;
        if(s == words.length) return;
        int e = s;
        int sum =0;
        for(int i=s; i<words.length; i++) {
            if(i != s) {
                sum += 1; // at least one space between each word.
            }
            sum += words[i].length();
            if(sum > max) {
                e = i-1;
                sum -=words[i].length();
                sum--; //extra space
                break;
            }
            if(i == words.length-1) {
                e = i;
            }
        }
        int spaces = max - sum;
        StringBuilder sb = new StringBuilder();
        if(e == s) {
            sb.append(words[s]);
            for(int i=0; i<spaces; i++) {
                sb.append(" ");
            }
        } else {
            int cnt = e - s;
            int ave = spaces/cnt;
            int ext = spaces%cnt;
            for(int i=s; i<=e; i++) {
                if(i !=s ) {
                    sb.append(" "); //default space
                    if(e != words.length-1) {// if not last line.
                        for(int j=0; j<ave; j++) {
                            sb.append(" ");
                        }
                        if(ext > 0) {
                            sb.append(" ");
                            ext--;
                        }
                    }
                }
                sb.append(words[i]);
            }
            if(e == words.length-1) {// last line
                for(int i=0; i<spaces; i++) {
                    sb.append(" ");
                }
            }
        }
        res.add(sb.toString());
        helper(words, max, e+1);
    }
}
