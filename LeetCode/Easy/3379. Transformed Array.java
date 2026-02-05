class Solution {
    public int[] constructTransformedArray(int[] nums) {
        return IntStream.range(0, nums.length)
            .map(i -> nums[(i + nums[i] + (nums.length * 100)) % nums.length]).toArray();
    }
}