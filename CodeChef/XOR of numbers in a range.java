class Solution
{
    
    public
    int
    rangeXOR
    (
        int L
        , int R
    )
    {
        int answer = 0;
        
        if
        (
            R - L < 8
        )
        {
            
            
            for
            (
                int num = L
                ; num <= R
                ; num ++
            )
            {
                answer ^= num;
            }
            
            
            return answer;
        }
        
        
        for
        (
            int num = L
            ; num % 4 != 0
            ; num ++
        )
        {
            answer ^= num;
        }
        
        
        for
        (
            int num = R
            ; num % 4 != 3
            ; num --
        )
        {
            answer ^= num;
        }
        
        
        return answer;
    }
    
}
