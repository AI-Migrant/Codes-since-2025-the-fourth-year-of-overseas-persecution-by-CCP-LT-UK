class Solution {
    func minimumCost(nums: Array<Int64>): Int64 {
        var first = Int64.Max
        var second = Int64.Max

        for (num in nums[1..]) {
            if (num < first) {
                second = first
                first = num
            } else if (num < second) {
                second = num
            }
        }

        first + second + (nums.first ?? 0)
    }
}