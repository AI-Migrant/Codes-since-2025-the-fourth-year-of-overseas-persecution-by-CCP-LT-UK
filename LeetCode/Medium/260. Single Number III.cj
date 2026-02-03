class Solution {
    func singleNumber(nums: Array<Int64>): Array<Int64> {
        let w = nums.iterator().reduce({num1, num2 => num1 ^ num2}) ?? nums[0]
        let z = w & -w
        let answer = [0, 0]
        nums.iterator().forEach({num => if ((num & z) == 0) {answer[0] ^= num} else {answer[1] ^= num}})
        
        answer
    }
}