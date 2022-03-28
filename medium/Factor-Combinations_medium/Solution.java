/*
Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note: 
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Examples: 
input: 1
output: 
[]
input: 37
output: 
[]
input: 12
output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
input: 32
output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
*/

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        return helper(2, n);
    }
    private List<List<Integer>> helper(int start, int cur) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int m = (int)Math.sqrt((double)cur);
        for(int i=start; i<=m; i++) {
            if(cur%i == 0) {
                List<Integer> newList = new ArrayList<Integer>();
                newList.add(i);
                newList.add(cur/i);
                res.add(newList);
                List<List<Integer>> list = helper(i, cur/i);
                if(!list.isEmpty()) {
                    for(List<Integer> sublist: list) {
                        sublist.add(0, i);
                        res.add(sublist);
                    }
                }
            }
        }
        return res;        
    }
}
