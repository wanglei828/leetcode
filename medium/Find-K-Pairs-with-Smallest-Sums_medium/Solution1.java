public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return res;
        int n1 = nums1.length;
        int n2 = nums2.length;
        PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int i=0; i<n1; i++) {
            q.add(new int[]{nums1[i]+nums2[0], i, 0});
        }
        while(k>0) {
            if(q.isEmpty()) break;
            int[] cur = q.poll();
            res.add(new int[]{nums1[cur[1]], nums2[cur[2]]});
            if(cur[2] < n2-1) {
                q.add(new int[]{nums1[cur[1]] + nums2[cur[2]+1], cur[1], cur[2]+1});
            }
            k--;
        }
        return res;
    }
}
