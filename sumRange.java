public class NumArray {
	private int[] table;
    public NumArray(int[] nums) {
        table = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++) {
        	table[i] = table[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return table[j + 1] - table[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);