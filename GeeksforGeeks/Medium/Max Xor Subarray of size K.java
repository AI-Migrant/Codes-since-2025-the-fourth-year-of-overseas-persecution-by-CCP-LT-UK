class Solution
{
    
    public
    int
    maxSubarrayXOR
    (
        int [] arr
        , int k
    )
    {
        final int N = arr.length;
        int xor = arr[0];
        
        
        for
        (
            int i = 1
            ; i < k
            ; i ++
        )
        {
            xor ^= arr[i];
        }
        
        
        int answer = xor;
        
        
        for
        (
            int i = k
                , j = 0
            ; i < N
            ; i ++, j ++
        )
        {
            xor ^= arr[i] ^ arr[j];
            answer = Math.max( answer, xor );
        }
        
        
        return answer;
    }
    
}
