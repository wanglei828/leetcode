/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        if(k==0) return res;
        helper(1, n, k, null);
        return res;
    }
    private void helper(int start, int n, int k, List<Integer>list) {
        if(k==0 && list != null) {
            List<Integer> copy = new ArrayList<Integer>();
            for(Integer i:list){
                copy.add(i);
            }
            res.add(copy);
            return;
        }
        list = (list != null)? list : new ArrayList<Integer>();
        int size = list.size();
        for(int i = start; i <= n; i++) {
            list.add(i);
            k--;
            helper(i+1, n, k, list);
            list.remove(size);
            k++;
        }
    }
}
