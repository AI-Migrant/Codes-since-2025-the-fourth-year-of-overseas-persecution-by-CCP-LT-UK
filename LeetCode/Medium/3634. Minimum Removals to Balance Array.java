class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        final int n = nums.length - 1;
        int i = 0;
        int j = n;
        long K = (long) k;
        
        while (i < j) {
            final int m = (i + j) / 2;
            boolean t = false;
            
            for (int o = 0; o <= m; o++) {
                if (nums[o] * K >= nums[n + o - m]) {
                    t = true;

                    break;
                }
            }

            if (t) {
                j = m;
            } else {
                i = m + 1;
            }
        }
        
        return i;
    }
}