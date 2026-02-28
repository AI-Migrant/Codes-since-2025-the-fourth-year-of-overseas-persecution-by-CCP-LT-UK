// Solution 1
class Solution {
    func runningSum(nums: Array<Int64>): Array<Int64> {
        let answer = nums.clone()
        
        for (i in 1..answer.size) {
            answer[i] += answer[i - 1]
        }
        
        answer
    }
}




// Solution 2
class Solution
{
    
    func
    runningSum
    (
        nums: Array < Int64 >
    )
    : Array < Int64 >
    {
        let ans: Array < Int64 > = Array( nums.size, repeat: 0 )
        ans[0] = nums[0]
        
        
        for
        (
            i
            in
            1..nums.size
        )
        {
            ans[i] = ans[i - 1] + nums[i]
        }
        
        
        ans
    }

}
