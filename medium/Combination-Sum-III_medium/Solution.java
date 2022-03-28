/*
Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/

public class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k < 1 || n < 1) return res;
        helper(null, k, n, 1);
        return res;
    }
    
    private void helper(List<Integer> list, int k, int n, int s) {
        if(k == 0 && n == 0) {
            List<Integer> copy = new ArrayList<Integer>();
            for(Integer i:list) {
                copy.add(i);
            }
            res.add(copy);
            return;
        }
        list = (list == null)? new ArrayList<Integer>() : list;
        int size = list.size();
        for(int i=s; i<=9; i++) {
            if(n<i) return;
            list.add(i);
            helper(list, k-1, n-i, i+1);
            list.remove(size);
        }
    }
}
