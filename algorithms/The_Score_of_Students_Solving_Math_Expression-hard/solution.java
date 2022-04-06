/*
You are given a string s that contains digits 0-9, addition symbols '+', and multiplication symbols '*' only, 
representing a valid math expression of single digit numbers (e.g., 3+5*2). 
This expression was given to n elementary school students. 
The students were instructed to get the answer of the expression by following this order of operations:

Compute multiplication, reading from left to right; Then,
Compute addition, reading from left to right.
You are given an integer array answers of length n, which are the submitted answers of the students in no particular order. 
You are asked to grade the answers, by following these rules:

If an answer equals the correct answer of the expression, this student will be rewarded 5 points;
Otherwise, if the answer could be interpreted as if the student applied the operators in the wrong order but had correct arithmetic, 
this student will be rewarded 2 points;
Otherwise, this student will be rewarded 0 points.
Return the sum of the points of the students.

Input: s = "7+3*1*2", answers = [20,13,42]
Output: 7
Explanation: As illustrated above, the correct answer of the expression is 13, therefore one student is rewarded 5 points: [20,13,42]
A student might have applied the operators in this wrong order: ((7+3)*1)*2 = 20. Therefore one student is rewarded 2 points: [20,13,42]
The points for the students are: [2,5,0]. The sum of the points is 2+5+0=7.

Input: s = "3+5*2", answers = [13,0,10,13,13,16,16]
Output: 19
Explanation: The correct answer of the expression is 13, therefore three students are rewarded 5 points each: [13,0,10,13,13,16,16]
A student might have applied the operators in this wrong order: ((3+5)*2 = 16. Therefore two students are rewarded 2 points: [13,0,10,13,13,16,16]
The points for the students are: [5,0,0,5,5,2,2]. The sum of the points is 5+0+0+5+5+2+2=19.

Input: s = "6+0*1", answers = [12,9,6,4,8,6]
Output: 10
Explanation: The correct answer of the expression is 6.
If a student had incorrectly done (6+0)*1, the answer would also be 6.
By the rules of grading, the students will still be rewarded 5 points (as they got the correct answer), not 2 points.
The points for the students are: [0,0,5,0,0,5]. The sum of the points is 10.
 

Constraints:

3 <= s.length <= 31
s represents a valid expression that contains only digits 0-9, '+', and '*' only.
All the integer operands in the expression are in the inclusive range [0, 9].
1 <= The count of all operators ('+' and '*') in the math expression <= 15
Test data are generated such that the correct answer of the expression is in the range of [0, 1000].
n == answers.length
1 <= n <= 104
0 <= answers[i] <= 1000
*/

class Solution {
    Map<String, Set<Integer>> memo;
    public int scoreOfStudents(String s, int[] answers) {
        int[] idx = new int[1];
        memo = new HashMap<>();
        int correct = parseExp(s, idx);
        Set<Integer> all = getAll(s);
        int res = 0;
        for (int ans: answers) {
            if (ans == correct) {
                res += 5;
            } else if (all.contains(ans)) {
                res += 2;
            }
        }
        return res;
    }
    
    private Set<Integer> getAll(String s) {
        Set<Integer> res = new HashSet<>();
        if (s.length() == 0) {
            return res;
        } else if (s.length() == 1) {
            int val = Integer.parseInt(s);
            res.add(val);
            return res;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        boolean nosign = true;
        for (int i = 1; i < s.length(); i++) {
            char op = s.charAt(i);
            if (Character.isDigit(op)) continue;
            nosign = false;
            Set<Integer> left = getAll(s.substring(0,i));
            Set<Integer> right = getAll(s.substring(i+1));
            for (int n1 : left) {
                for (int n2: right) {
                    int n = (op == '*') ? n1 * n2 : n1 + n2;
                    if (n <= 1000) {
                      res.add(n);  
                    }
                }
            }
        }
        if (res.isEmpty() && nosign && Integer.parseInt(s) <= 1000) {
            res.add(Integer.parseInt(s));
        }
        memo.put(s, res);
        return res;
    }
    
    private int parseExp(String s, int[] idx) {
        int lhs = parseFac(s, idx);
        while (idx[0] < s.length() && s.charAt(idx[0]) == '+') {
            idx[0]++;
            int rhs = parseFac(s, idx);
            lhs += rhs;
        }
        return lhs;
    }
    
    private int parseFac(String s, int[] idx) {
        int lhs = parseNum(s, idx);
        while (idx[0] < s.length() && s.charAt(idx[0]) == '*') {
            idx[0]++;
            int rhs = parseNum(s, idx);
            lhs *= rhs;
        }
        return lhs;
    }
    
    private int parseNum(String s, int[] idx) {
        int num = 0;
        while (idx[0] < s.length() && Character.isDigit(s.charAt(idx[0]))) {
            num = num * 10 + s.charAt(idx[0]) - '0';
            idx[0]++;
        }
        return num;
    }
}

