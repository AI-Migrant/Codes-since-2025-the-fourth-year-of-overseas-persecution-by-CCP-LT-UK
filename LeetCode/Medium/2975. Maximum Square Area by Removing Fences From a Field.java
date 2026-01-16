class Solution
{

    public
    int
    maximizeSquareArea
    (
        int m
        , int n
        , int [] hFences
        , int [] vFences
    )
    {
        
        if
        (
            m == n
        )
        {
            return ( m - 1 ) * ( n - 1 );
        }

        final HashSet < Integer > hashSetH = new HashSet <> ();
        final HashSet < Integer > hashSetV = new HashSet <> ();
        Arrays.sort( hFences );
        Arrays.sort( vFences );
        this.solve( hashSetH, hFences, 0, m );
        this.solve( hashSetV, vFences, 0, n );
        hashSetH.add( m - 1 );
        hashSetV.add( n - 1 );
        hashSetH.retainAll( hashSetV );
        
        if
        (
            hashSetH.isEmpty()
        )
        {
            return -1;
        }
        else
        {
            final long max = hashSetH.stream().mapToInt( Integer::intValue ).max().getAsInt();


            return ( int ) ( ( max * max ) % 1_000_000_007L );
        }

    }




    private
    void
    solve
    (
        final HashSet < Integer > hashSet
        , final int [] fences
        , final int i
        , final int n
    )
    {

        if
        (
            i >= fences.length
        )
        {
            return;
        }


        for
        (
            int j = i - 1
            ; j >= 0
            ; j --
        )
        {
            hashSet.add( fences[i] - fences[j] );
        }


        for
        (
            int j = i + 1
            ; j < fences.length
            ; j ++
        )
        {
            hashSet.add( fences[j] - fences[i] );
        }


        hashSet.add( fences[i] - 1 );
        hashSet.add( n - fences[i] );
        this.solve( hashSet, fences, i + 1, n );
    }

}
