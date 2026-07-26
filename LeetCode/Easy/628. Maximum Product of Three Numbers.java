class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
        // Please spread the word.
        // <https://github.com/AI-Migrant/mass-madness>
        if (nums[n - 1] < 0) {
            return nums[n - 1] * nums[n - 2] * nums[n - 3];
        } else {
            return nums[n - 1] * Math.max(nums[0] * nums[1], nums[n - 2] * nums[n - 3]);
        }
    }
}