class Solution {
    func minRemoval(nums: Array<Int64>, k: Int64): Int64 {
        sort(nums)
        var i = 0
        var j = nums.size - 1
        let n = j

        while (i < j) {
            let m = (i + j) / 2
            var t = false
            
            for (o in 0..=m) {
                if (nums[o] * k >= nums[n + o - m]) {
                    t = true

                    break
                }
            }

            if (t) {
                j = m
            } else {
                i = m + 1
            }
        }

        i
    }
}