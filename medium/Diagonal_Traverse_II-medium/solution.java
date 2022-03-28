/*
Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the below images.

Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,4,2,7,5,3,8,6,9]

Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]

Constraints:

1 <= nums.length <= 105
1 <= nums[i].length <= 105
1 <= sum(nums[i].length) <= 105
1 <= nums[i][j] <= 105
*/

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = nums.size();
        int total = 0;
        for(int i = 0; i < n; i++) {
            total += nums.get(i).size();
        }
        int[] res = new int[total];
        int index = 0;
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = nums.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (map.containsKey(i+j)) {
                    map.get(i+j).addFirst(list.get(j));
                } else {
                    LinkedList<Integer> nlist = new LinkedList<>();
                    nlist.addFirst(list.get(j));
                    map.put(i+j, nlist);
                }
                index = Math.max(index, i+j);
            }
        }
        int cnt = 0;
        for (int i = 0; i <= index; i++) {
            if (map.containsKey(i)) {
                LinkedList<Integer> list = map.get(i);
                for (int a: list) {
                    res[cnt++] = a;
                }
            }
        }
        return res;
    }
}
