public static
int
removeDuplicates
(
    int [] nums
)
{
    int answer = 1;
    
    
    for
    (
        int i = 1
        ; i < nums.length
        ; i ++
    )
    {
        
        if
        (
            nums[i] != nums[i - 1]
        )
        {
            nums[answer] = nums[i];
            answer ++;
        }
        
    }
    
    
    return answer;
}
