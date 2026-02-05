class Solution {
    func maxSumTrionic(nums: Array<Int64>): Int64 {
        var answer = Int64.Min
        var prev = nums[0]
        var sum1 = 0
        var sum2 = 0
        var sum3 = 0
        var c = 0
        var s = 0

        for(num in nums) {
            if (num == prev) {
                sum1 = 0
                sum2 = 0
                sum3 = 0
                s = 0
                c = 0
            } else if (num < prev) {
                if (s == -1) {
                    if (c != 0) {
                        sum1 += num
                    }
                } else {
                    if (c == 1) {
                        sum1 += num
                    } else if (c == 2) {
                        sum1 = sum3 + num
                        c--
                    }

                    s = -1
                }
            } else if (c == 2) {
                sum3 = max(sum3, prev) + num
                sum1 += num
                answer = max(answer, sum1 + sum2)
            } else if (c == 1) {
                    if (s == 1) {
                        sum1 = max(sum1, prev) + num
                    } else {
                        sum2 = sum1 - prev
                        sum1 = prev + num
                        sum3 = prev + num
                        answer = max(answer, sum1 + sum2)
                        s = 1
                        c++
                    }
            } else {
                sum1 = prev + num
                s = 1
                c++
            }

            prev = num
        }

        answer
    }
}