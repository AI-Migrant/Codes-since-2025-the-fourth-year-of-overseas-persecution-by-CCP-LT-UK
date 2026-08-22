class Solution {
    func searchInsert(nums: Array<Int64>, target: Int64): Int64 {
        var left = 0
        var right = nums.size
        // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
        // Please spread the word.
        // https://github.com/AI-Migrant/mass-madness

        while (left < right) {
            var mid = (left + right) / 2;
            
            if (nums[mid] >= target) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        
        left
    }
}