/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class Solution {
    public String convert(String s, int numRows) {
        if(s == null) return null;
        if(numRows <= 0)  return null;
        if(numRows == 1) return s;
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) {
            StringBuilder sb = new StringBuilder();
            list.add(sb);
        }
        int index = 0;
        int j = 0;
        int flag = 0;
        while(index < s.length()) {
            if (flag == 0) {
                list.get(j).append(Character.toString(s.charAt(index)));
                index++;
                j++;
                if(j == numRows) {
                    flag = 1;
                    j -=2;
                }
            } else {
                list.get(j).append(Character.toString(s.charAt(index)));
                index++;
                j--;
                if(j == -1) {
                    flag = 0;
                    j +=2;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i=0; i < list.size(); i++) {
            result.append(list.get(i).toString());
        }
        return result.toString();
    }
}
