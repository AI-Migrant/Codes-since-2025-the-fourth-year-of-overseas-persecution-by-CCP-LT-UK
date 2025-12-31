class Solution
{
    private Map < Character, Map < Character, Set < Character > > > map;
    private StringBuilder [] pyramid;
    private Set < String > seen;
    
    
    
    
    public
    boolean
    pyramidTransition
    (
        String bottom
        , List < String > allowed
    )
    {
        map = new HashMap <> ();
        seen = new HashSet <> ();
        pyramid = new StringBuilder [ bottom.length() ];
        pyramid[0] = new StringBuilder( bottom );
        
        
        for
        (
            int i = 1
            ; i < pyramid.length
            ; i ++
        )
        {
            pyramid[i] = new StringBuilder( " ".repeat( bottom.length() - i ) );
        }
        
        
        for
        (
            final String s
            : allowed
        )
        {
            final Character k1 = s.charAt( 0 );
            final Character k2 = s.charAt( 1 );
            
            if
            (
                !map.containsKey( k1 )
            )
            {
                map.put( k1, new HashMap <> () );
            }
            
            if
            (
                !map.get( k1 ).containsKey( k2 )
            )
            {
                map.get( k1 ).put( k2, new HashSet <> () );
            }
            
            map.get( k1 ).get( k2 ).add( s.charAt( 2 ) );
        }
        
        
        return build( 0, 1 );
    }
    
    
    
    
    private
    boolean
    build
    (
        int i
        , int j
    )
    {
        
        if
        (
            j == pyramid[0].length() - i
        )
        {
            i ++;
            j = 1;
            final String s = pyramid[i].toString();
            
            if
            (
                seen.contains( s )
            )
            {
                return false;
            }
            else
            {
                seen.add( s );
            }
            
        }
        
        if
        (
            i >= pyramid.length - 1
        )
        {
            return true;
        }
        
        final Character k1 = pyramid[i].charAt( j - 1 );
        final Character k2 = pyramid[i].charAt( j );
        j ++;
        
        if
        (
            !map.containsKey( k1 )
            || !map.get( k1 ).containsKey( k2 )
        )
        {
            return false;
        }
         
        
        for
        (
            final char c
            : map.get( k1 ).get( k2 )
        )
        {
            pyramid[i + 1].setCharAt( j - 2, c );
            
            if
            (
                build( i, j )
            )
            {
                return true;
            }
            
        }
        
        
        return false;
    }
    
}
