class Solution {
    public int countSubset(int[] arr, int k) {
        int min = 0;
        int max = 0;
        
        for (final int num : arr) {
            if (num < 0) {
                min += num;
            } else {
                max += num;
            }
        }
        
        final int n = max - min + 1;
        
        if (k < min || k > max) {
            return 0;
        }
        
        final int[] nums = new int[n];
        nums[-min] = 1;
        
        for (final int num : arr) {
            if (num <= 0) {
                for (int i = min + num; i < n; i++) {
                    nums[i + num] += nums[i];
                }
            } else {
                final int o = num + min;
                
                for (int i = n - 1; i >= o; i--) {
                    nums[i] += nums[i - num];
                }
            }
        }
        
        return nums[k];
    }
}