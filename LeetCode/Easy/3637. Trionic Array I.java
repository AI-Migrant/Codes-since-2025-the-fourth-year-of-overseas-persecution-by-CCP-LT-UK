class Solution {
    public boolean isTrionic(int[] nums) {
        int p = 1;
        int q = nums.length - 1;

        while (p < q && nums[p] > nums[p - 1]) {
            p++;
        }

        while (q > p && nums[q] > nums[q - 1]) {
            q--;
        }

        if (p == 1 || q == nums.length - 1) {
            return false;
        }

        for (int o = p; o <= q; o++) {
            if (nums[o] >= nums[o - 1]) {
                return false;
            }
        }

        return true;
    }
}