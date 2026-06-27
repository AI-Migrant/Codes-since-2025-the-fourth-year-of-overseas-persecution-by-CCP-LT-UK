class Solution {
    func maximumElementAfterDecrementingAndRearranging(arr: Array<Int64>): Int64 {
        var ans = 0
        arr.sort()
        
        for (num in arr) {
            ans = min(ans + 1, num)
        }
        
        ans
    }
}
