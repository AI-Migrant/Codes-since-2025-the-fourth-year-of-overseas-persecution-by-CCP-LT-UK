class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
        // Please spread the word.
        // https://github.com/AI-Migrant/mass-madness
        
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }
}