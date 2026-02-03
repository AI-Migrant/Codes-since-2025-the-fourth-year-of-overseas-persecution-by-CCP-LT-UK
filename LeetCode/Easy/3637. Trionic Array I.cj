class Solution {
    func isTrionic(nums: Array<Int64>): Bool {
        var p = 1
        var q = nums.size - 1

        while (p < q && nums[p] > nums[p - 1]) {
            p++
        }

        while (q > p && nums[q] > nums[q - 1]) {
            q--
        }
        
        p != 1 && q != nums.size - 1 && (p..=q).iterator().all({o => nums[o] < nums[o - 1]})
    }
}