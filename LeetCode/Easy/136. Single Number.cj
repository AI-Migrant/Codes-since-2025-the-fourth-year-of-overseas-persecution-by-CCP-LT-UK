class Solution {
    func singleNumber(nums: Array<Int64>): Int64 {
        var answer = 0

        for (num in nums) {
            answer ^= num
        }

        answer
    }
}