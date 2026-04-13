class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        for (int i = start, j = start; i >= 0 || j < nums.length; --i, ++j) {
            if (i >= 0 && nums[i] == target) {
                return start - i;
            } else if (j < nums.length && nums[j] == target) {
                return j - start;
            }
        }

        return -1;
    }
}