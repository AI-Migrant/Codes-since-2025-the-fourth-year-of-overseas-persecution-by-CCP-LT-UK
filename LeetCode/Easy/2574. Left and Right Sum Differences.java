class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0;
        int right = 0;

        for (int num : nums) {
            right += num;
        }

        for (int i = 0; i < n; i++) {
            right -= nums[i];
            ans[i] = Math.abs(left - right);
            left += nums[i];
        }

        return ans;
    }
}