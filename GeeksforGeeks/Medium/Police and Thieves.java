class Solution
{
    
    public
    int
    catchThieves
    (
        char [] arr
        , int k
    )
    {
        final ArrayDeque < Integer > legalisedArrayDeque
            = new ArrayDeque <> ();
            
        final ArrayDeque < Integer > nonlegalisedArrayDeque
            = new ArrayDeque <> ();
            
        int answer = 0;
        
        
        for
        (
            Integer i = 0
            ; i < arr.length
            ; i ++
        )
        {
            
            if
            (
                arr[i] == 'P'
            )
            {
                answer += match
                    (
                        nonlegalisedArrayDeque
                        , legalisedArrayDeque
                        , i
                        , i - k
                    );
            }
            else
            {
                answer += match
                    (
                        legalisedArrayDeque
                        , nonlegalisedArrayDeque
                        , i
                        , i - k
                    );
            }
            
        }


        return answer;
    }
    
    
    
    
    private
    int
    match
    (
        final ArrayDeque < Integer > arrayDeque1
        , final ArrayDeque < Integer > arrayDeque2
        , final int i
        , final int j
    )
    {
        
        
        while
        (
            !arrayDeque1.isEmpty()
            && arrayDeque1.peekFirst() < j
        )
        {
            arrayDeque1.pollFirst();
        }


        if
        (
            arrayDeque1.isEmpty()
        )
        {
            arrayDeque2.offerLast( i );


            return 0;
        }
        else
        {
            arrayDeque1.pollFirst();


            return 1;
        }

    }
    
}
