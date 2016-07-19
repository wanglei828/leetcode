public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0;
        List<Integer> list = new ArrayList<Integer>();
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i] < nums2[j]) {
                i++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        for(i=0; i<list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
