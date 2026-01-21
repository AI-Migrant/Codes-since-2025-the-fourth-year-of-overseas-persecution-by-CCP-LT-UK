class Solution {
    func singleNumber(nums: Array<Int64>): Int64 {
        nums.iterator().reduce({a, b => a ^ b}) ?? nums[0]
    }
}