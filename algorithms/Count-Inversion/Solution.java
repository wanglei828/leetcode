/*
Inversion Count for an array indicates – how far (or close) the array is from being sorted. 
If array is already sorted then inversion count is 0. 
If array is sorted in reverse order that inversion count is the maximum. 
Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3)
*/

public class Solution {

	public static int mergeSort(int[] nums, int h, int t) {
		if (h == t)
			return 0;
		int m = h + (t - h) / 2;
		int cnt = 0;
		cnt = mergeSort(nums, h, m);
		cnt += mergeSort(nums, m + 1, t);
		cnt += merge(nums, h, m, t);
		return cnt;
	}

	public static int merge(int[] nums, int h, int m, int t) {
		int[] tmp = new int[t - h + 1];
		int cnt = 0;
		int i = h, j = m + 1;
		int k = 0;
		while (i <= m && j <= t) {
			if (nums[i] < nums[j]) {
				tmp[k++] = nums[i++];
			} else {
				tmp[k++] = nums[j++];
				cnt += (m - i + 1);
			}
		}
		while (i <= m) {
			tmp[k++] = nums[i++];
		}
		while (j <= t) {
			tmp[k++] = nums[j++];
		}
		for (i = h; i <= t; i++) {
			nums[i] = tmp[i - h];
		}
		return cnt;
	}

	public static void main(String[] args) {
		int[] nums = {8, 4, 2, 1};
		System.out.println(mergeSort(nums, 0, nums.length - 1));
	}
}
