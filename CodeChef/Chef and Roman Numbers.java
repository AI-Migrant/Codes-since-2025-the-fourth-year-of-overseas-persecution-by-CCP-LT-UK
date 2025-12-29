public static
int
romanToInt
(
    String s
)
{
    final int len = s.length();
    final Map < Character, Integer > map = new HashMap <> ();
    map.put( 'I', 1 );
    map.put( 'V', 5 );
    map.put( 'X', 10 );
    map.put( 'L', 50 );
    map.put( 'C', 100 );
    map.put( 'D', 500 );
    map.put( 'M', 1000 );
    int answer = 0;
    
    
    for
    (
        int i = 0
        ; i < len
        ; i ++
    )
    {
        int j = i + 1;
        final int value1 = map.get( s.charAt( i ) );
        int sum = value1;
        
        
        while
        (
            j < len
            && s.charAt( i ) == s.charAt( j )
        )
        {
            sum += value1;
            
            j ++;
        }
        
        
        if
        (
            j < len
        )
        {
            final int value2 = map.get( s.charAt( j ) );
            
            if
            (
                value1 < value2
            )
            {
                answer += value2 - sum;
                i = j;
            }
            else
            {
                answer += sum;
                i = j - 1;
            }
            
        }
        else
        {
            answer += sum;
            
            break;
        }
        
    }
    
    
    return answer;
}
