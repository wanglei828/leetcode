public class NumArray {

    int[] nums;
    int[] bit;
    int n;
    public NumArray(int[] nums) {
        if(nums == null || nums.length == 0) return;
        this.n = nums.length;
        this.nums = new int[n];
        this.bit = new int[n+1];
        for(int i=0; i<n; i++) {
            update(i, nums[i]);
        }
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        for(i+=1; i<=n; i+=(-i&i)) {
            bit[i] += diff;
        }
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i-1);
    }

    private int getSum(int i) {
        int sum = 0;
        for(i +=1; i>0; i-=(-i&i)) {
            sum += bit[i];
        }
        return sum;
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
