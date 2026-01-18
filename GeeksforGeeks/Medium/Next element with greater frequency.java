class Solution
{
    
    public
    ArrayList < Integer >
    nextFreqGreater
    (
        int [] arr
    )
    {
        final int N = arr.length;
        final HashMap < Integer, Integer > hashMap = new HashMap <> ();
        final ArrayList < Integer > answer = new ArrayList <> ();
        final Stack < Integer > stack = new Stack <> ();
        
        
        for
        (
            final int num
            : arr
        )
        {
            hashMap.put( num, hashMap.getOrDefault( num, 0 ) + 1 );
        }
        
        
        for
        (
            int i = 0
            ; i < N
            ; i ++
        )
        {
            
            
            while
            (
                !stack.isEmpty()
                && hashMap.get( arr[stack.peek()] ) < hashMap.get( arr[i] )
            )
            {
                answer.set( stack.pop(), arr[i] );
            }
            
            
            answer.add( -1 );
            stack.push( i );
        }
        
        
        return answer;
    }
    
}
