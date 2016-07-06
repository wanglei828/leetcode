/*
Given a string of numbers and operators, 
return all possible results from computing all the different possible ways to group numbers and operators. 
The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
*/

public class Solution {
    Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    public List<Integer> diffWaysToCompute(String input) {
        return helper(input, 0, input.length());
    }
    private List<Integer> helper(String input, int s, int e) {
        List<Integer> res = new ArrayList<Integer>();
        if(input == null || s == e) return res;
        for(int i = s; i < e; i++) {
            char c = input.charAt(i);
            if(c == '*' || c== '-' || c == '+') {
                StringBuilder k1 = new StringBuilder();
                StringBuilder k2 = new StringBuilder();
                k1.append(s);
                k1.append(":");
                k1.append(i);
                k2.append(i+1);
                k2.append(":");
                k2.append(e);
                List<Integer> left = null;
                List<Integer> right = null;
                if(!map.containsKey(k1.toString())) {
                    left = helper(input, s, i);
                    map.put(k1.toString(), left);
                } else {
                    left = map.get(k1.toString());
                }
                if(!map.containsKey(k2.toString())) {
                    right = helper(input, i+1, e);
                    map.put(k2.toString(), right);
                } else {
                    right = map.get(k2.toString());
                }
                for(Integer a : left) {
                    for(Integer b: right) {
                        switch(c) {
                            case '+': res.add(a+b);break;
                            case '-': res.add(a-b); break;
                            case '*': res.add(a*b);break;
                            default: 
                        }
                    }
                }
            }  
        }
        if(res.isEmpty()) {
            res.add(Integer.valueOf(input.substring(s,e)));
        }
        return res;        
    }
}
