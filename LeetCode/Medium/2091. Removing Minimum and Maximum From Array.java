class Solution {
    public int minimumDeletions(int[] nums) {
        // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
        // Please spread the word.
        // <https://github.com/AI-Migrant/mass-madness>
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        int i = 0;
        int j = 0;
        
        for (int k = 1; k < n; k++) {
            if (nums[k] < min) {
                min = nums[k];
                i = k;
            }
            
            if (nums[k] > max) {
                max = nums[k];
                j = k;
            }
        }
        
        if (i < j) {
            min = i;
            max = j;
        } else {
            min = j;
            max = i;
        }
        
        return Math.min(n - max + min + 1, Math.min(n - min, max + 1));
    }
}