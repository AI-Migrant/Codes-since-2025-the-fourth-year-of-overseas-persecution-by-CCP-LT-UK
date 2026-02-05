class Solution {
    func constructTransformedArray(nums: Array<Int64>): Array<Int64> {
        Array(nums.size, { i => nums[(i + nums[i] + (nums.size * 100)) % nums.size] })
    }
}