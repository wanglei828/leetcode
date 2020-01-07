/*

Design a class to find the kth largest element in a stream. 
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, 
which contains initial elements from the stream. For each call to the method KthLargest.add, 
return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
Note:
You may assume that nums' length ≥ k-1 and k ≥ 1.

*/

class KthLargest {
    PriorityQueue<Integer> q;
    int curK;
    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<Integer>();
        curK = k;
        int i=0;
        while(i<nums.length && i<k) {
            q.add(nums[i]);
            i++;
        }
        while(i<nums.length) {
            int cur = q.peek();
            if(cur < nums[i]) {
                q.poll();
                q.add(nums[i]);
            }
            i++;
        }
    }
    
    public int add(int val) {
        if(q.size() < curK) {
            q.add(val);
            return q.peek();
        }
        int cur = q.peek();
        if(val <= cur) {
            return cur;
        } else {
            q.poll();
            q.add(val);
            return q.peek();
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
