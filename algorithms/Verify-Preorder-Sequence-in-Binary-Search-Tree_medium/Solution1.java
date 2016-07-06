public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) return true;
        return helper(preorder, 0, preorder.length-1);
    }
    private boolean helper(int[] arr, int s, int e) {
        if(s >= e) return true;
        int pivot = arr[s];
        int index = -1;
        for(int i=s+1; i<=e; i++) {
            if(arr[i] > pivot) {
                index = i;
                break;
            }
        }
        if(index != -1) {
            for(int i=index; i<=e; i++) {
                if(arr[i] < pivot) {
                    return false;
                }
            }
            return helper(arr, s+1, index-1) && helper(arr, index, e);
        } else {
            return helper(arr, s+1, e);
        }
        
    }
}
