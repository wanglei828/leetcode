/*
You are given a string text of words that are placed among some number of spaces. 
Each word consists of one or more lowercase English letters and are separated by at least one space. 
It's guaranteed that text contains at least one word.

Rearrange the spaces so that there is an equal number of spaces between every pair of adjacent words and that number is maximized. 
If you cannot redistribute all the spaces equally, place the extra spaces at the end, meaning the returned string should be the same length as text.

Return the string after rearranging the spaces.

 

Example 1:

Input: text = "  this   is  a sentence "
Output: "this   is   a   sentence"
Explanation: There are a total of 9 spaces and 4 words. We can evenly divide the 9 spaces between the words: 9 / (4-1) = 3 spaces.
Example 2:

Input: text = " practice   makes   perfect"
Output: "practice   makes   perfect "
Explanation: There are a total of 7 spaces and 3 words. 7 / (3-1) = 3 spaces plus 1 extra space. We place this extra space at the end of the string.
 

Constraints:

1 <= text.length <= 100
text consists of lowercase English letters and ' '.
text contains at least one word.
*/

class Solution {
    public String reorderSpaces(String text) {
        int cnt = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '\s') {
                cnt++;
            }
        }
        if (cnt == 0) return text;
        String[] arr = text.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        int size = arr.length;
        if (size == 1) {
            sb.append(arr[0]);
            for (int i = 0; i < cnt; i++) {
                sb.append(" ");
            }
        } else {
            int inspace = cnt / (size - 1);
            int extra = cnt % (size - 1);
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
                if (i != arr.length - 1) {
                    for (int j = 0; j < inspace; j++) {
                        sb.append(" ");
                    }
                }
            }
            for (int i = 0; i < extra; i ++) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
