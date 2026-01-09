class Solution
{
    
    public
    int
    countAtMostK
    (
        int arr []
        , int k
    )
    {
        final int arrLength = arr.length;
        final HashMap < Integer, Integer > hashMap = new HashMap <> ();
        int answer = 0;
        
        
        for
        (
            int i = 0
                , j = -1
            ; i < arrLength
            ; i ++
        )
        {
            hashMap.put( arr[i], hashMap. getOrDefault( arr[i], 0 ) + 1 );
            
            
            while
            (
                hashMap.size() > k
            )
            {
                j ++;
                
                if
                (
                    hashMap.get( arr[j] ) == 1
                )
                {
                    hashMap.remove( arr[j] );
                }
                else
                {
                    hashMap.put( arr[j], hashMap.get( arr[j] ) - 1 );
                }
                
            }
            
            
            answer += i - j;
        }
        
        
        return answer;
    }
    
}
