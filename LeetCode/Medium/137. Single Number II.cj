class Solution {
    func singleNumber(nums: Array<Int64>): Int64 {
        (0..=63).iterator().fold(0, {a, i => a | if (nums.iterator().fold(0, {m, n => m + ((n >> i) & 1)}) % 3 == 0) {0} else {1 << i}})
    }
}