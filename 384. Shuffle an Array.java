/*
 * 384. Shuffle an Array
 * 随机数
 */
public class Solution {

	private int[] origin;
	private int[] nums;

	public Solution(int[] nums) {
		this.nums = nums;
		this.origin = nums.clone();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return origin;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		Random r = new Random();
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			int j = r.nextInt(len);//取[0,len-1]间的随机数
			swap(i, j);
		}
		return nums;
	}

	private void swap(int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(nums);
	 * int[] param_1 = obj.reset();
	 * int[] param_2 = obj.shuffle();
	 */
}