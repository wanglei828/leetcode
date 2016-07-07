/*
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, 
you and your friend take turns to flip two consecutive "++" into "--". 
The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm's runtime complexity.
*/

public class Solution {
    public boolean canWin(String s) {
        if(s == null || s.length() <= 1) return false;
        return win(s.toCharArray());
    }
    
    private boolean win(char[] s) {
        int n = s.length;
        for(int i=0; i<n-1; i++) {
            if(s[i] == '+' &&  s[i+1] == '+') {
                s[i] = '-';
                s[i+1] = '-';
                if(!win(s)) {
                    s[i] = '+';
                    s[i+1] = '+';
                    return true;
                }
                s[i] = '+';
                s[i+1] = '+';
            }
        }
        return false;
    }
}
