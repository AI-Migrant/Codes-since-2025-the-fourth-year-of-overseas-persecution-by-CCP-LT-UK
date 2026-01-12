import java.util.*;




class Solution
{
    
    public
    int []
    searchRange
    (
        int [] arr
        , int key
    )
    {
        final int N = arr.length;
        final int O = N - 1;
        final int [] answer = new int [ 2 ];
        answer[0] = Math.max( -1, Arrays.binarySearch( arr, key ) );
        
        if
        (
            answer[0] < 0
        )
        {
            answer[0] = -1;
            answer[1] = -1;
        }
        else
        {
            int i = answer[0] + 1;
            
            
            while
            (
                i < N
                && arr[i] == key 
            )
            {
                i ++;
            }
            
            
            answer[1] = i - 1;
            i = answer[0];
            
            
            while
            (
                i >= 0
                && arr[i] == key
            )
            {
                i --;
            }
            
            
            answer[0] = i + 1;
        }
        
        
        return answer;
    }
    
}
