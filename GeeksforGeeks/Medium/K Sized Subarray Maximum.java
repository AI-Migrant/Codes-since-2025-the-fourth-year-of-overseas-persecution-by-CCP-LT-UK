class Solution
{
    
    public
    ArrayList < Integer >
    maxOfSubarrays
    (
        int [] arr
        , int k
    )
    {
        final int N = arr.length;
        final ArrayList < Integer > answer = new ArrayList <> ( N );
        final TreeMap < Integer, Integer > treeMap = new TreeMap <> ();
        
        
        for
        (
            int i = 0
            ; i < k
            ; i ++
        )
        {
            treeMap.put( arr[i], treeMap.getOrDefault( arr[i], 0 ) + 1 );
        }
        
        
        answer.add( treeMap.lastKey() );
        
        
        for
        (
            int i = k
                , j = 0
            ; i < N
            ; i ++, j ++
        )
        {
            treeMap.put( arr[i], treeMap.getOrDefault( arr[i], 0 ) + 1 );
            
            if
            (
                treeMap.get( arr[j] ) == 1
            )
            {
                treeMap.remove( arr[j] );
            }
            else
            {
                treeMap.put( arr[j], treeMap.get( arr[j] ) - 1 );
            }
            
            answer.add( treeMap.lastKey() );
        }
        
        
        return answer;
    }
    
}
