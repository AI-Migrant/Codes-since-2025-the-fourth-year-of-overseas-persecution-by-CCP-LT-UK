class Solution {
    func minPairSum(nums: Array<Int64>): Int64 {
        sort(nums)

        nums[..nums.size / 2].iterator().enumerate().fold(0, {a, c => max(a, c[1] + nums[nums.size - c[0] - 1])})
    }
}




// Solution 2
class Solution {
    func minPairSum(nums: Array<Int64>): Int64 {
        sort(nums)
        var i = 0
        var j = nums.size - 1
        var answer = 0

        while (i < j) {
            answer = max(answer, nums[i] + nums[j])
        }

        answer
    }
}