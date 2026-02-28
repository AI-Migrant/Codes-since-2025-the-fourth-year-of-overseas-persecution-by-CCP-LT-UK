// Solution 1
class Solution {
    func numberOfSteps(num: Int64): Int64 {
        max(0, 63 - leadingZeros(num) + countOnes(num))
    }
}




//Solution 2
class Solution
{
    
    func
    numberOfSteps
    (
        num: Int64
    )
    : Int64
    {
        var ans: Int64 = 0
        var worker: Int64 = num
        
        
        while
        (
            worker > 0
        )
        {
            
            if
            (
                worker % 2 > 0
            )
            {
                worker --
            }
            else
            {
                worker /= 2
            }
            
            ans ++
        }
        
        
        ans
    }
    
}
