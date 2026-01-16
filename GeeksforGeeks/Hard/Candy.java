import java.util.AbstractMap.*;




class Solution
{
    
    public
    int
    minCandy
    (
        int arr []
    )
    {
        int answer = 1;
        final Stack < SimpleImmutableEntry < Integer, Integer > > stack
            = new Stack <> ();
        stack.push( new SimpleImmutableEntry <> ( 0, 1 ) );
        
        
        for
        (
            int i = 1
                , c = 1
                , d = 0
            ; i < arr.length
            ; i ++
        )
        {
            
            if
            (
                arr[i - 1] > arr[i]
            )
            {
                
                
                while
                (
                    !stack.isEmpty()
                    && stack.peek().getValue() <= i - stack.peek().getKey()
                )
                {
                    d ++;
                    answer += i - stack.peek().getKey()
                        - stack.pop().getValue();
                }
                
                
                d ++;
                answer += d;
                c = 1;
                
                continue;
            }
            else if
            (
                arr[i - 1] < arr[i]
            )
            {
                c ++;
                d = 0;
            }
            else
            {
                c = 1;
                d = 0;
            }
            
            answer += c;
            stack.clear();
            stack.push( new SimpleImmutableEntry <> ( i, c ) );
        }
        
        
        return answer;
    }
    
}
