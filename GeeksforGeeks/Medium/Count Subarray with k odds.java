class Solution
{
    
    public
    int
    countSubarrays
    (
        int [] arr
        , int k
    )
    {
        final int N = arr.length;
        final ArrayList < Integer > arrayList = new ArrayList <> ( N );
        arrayList.add( -1 );
        int i = 0;
        
        
        while
        (
            i < N
            && arrayList.size() <= k
        )
        {
            
            if
            (
                arr[i] % 2 == 1
            )
            {
                arrayList.add( i );
            }
            
            i ++;
        }
        
        
        if
        (
            arrayList.size() <= k
        )
        {
            return 0;
        }
        
        int answer = 0;
        
        
        do
        {
            
            
            while
            (
                i < N
                && arr[i] % 2 != 1
            )
            {
                i ++;
            }
            
            
            answer += ( arrayList.get( arrayList.size() - k  ) - arrayList.get( arrayList.size() - k - 1) )
                * ( i - arrayList.getLast() );
            arrayList.add( i );
            
            i ++;
        }
        while
        (
            i < N
        );
        
        
        if
        (
            arrayList.getLast() != N
        )
        {
            answer += ( arrayList.get( arrayList.size() - k ) - arrayList.get( arrayList.size() - k - 1 ) )
                 * ( N - arrayList.getLast() );
        }
        
        
        return answer;
    }
    
}
