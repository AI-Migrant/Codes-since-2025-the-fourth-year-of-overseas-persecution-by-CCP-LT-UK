class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }

        int answer = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = k - 1, j = 0; i < nums.length; i++, j++) {
            answer = Math.min(answer, nums[i] - nums[j]);
        }

        return answer;
    }
}