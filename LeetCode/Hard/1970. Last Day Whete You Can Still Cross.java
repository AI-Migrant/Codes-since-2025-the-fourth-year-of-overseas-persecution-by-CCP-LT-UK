class Solution
{
    
    public
    int
    latestDayToCross
    (
        int row
        , int col
        , int [][] cells
    )
    {
        int answer = 0;
        final DSU dsu = new DSU( row, col );
        
        
        for
        (
            int i = 0
            ; i < cells.length
            ; i ++
        )
        {
            
            if
            (
                dsu.unite( cells[i][0] - 1, cells[i][1] -1 )
            )
            {
                return i;
            }
            
        }
        
        
        return -1;
    }
    
    
    
    
    private
    class DSU
    {
        private static final int [][] dir =
        {
            { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }
            , { 1, 0 }, { 1, 1 }
        };
        
        private final Root [][] roots;
        
        
        
        
        DSU
        (
            final int row
            , final int col
        )
        {
            this.roots = new Root [ row ][ col ];
            
            
            for
            (
                int i = 0
                ; i < row
                ; i ++
            )
            {
                
                
                for
                (
                    int j = 0
                    ; j < col
                    ; j ++
                )
                {
                    this.roots[i][j] = new Root( i, j, j, j, CellType.LAND );
                }
                
                
            }


        }
        
        
        
        
        private
        Root
        find
        (
            final int r
            , final int c
        )
        {
            
            if
            (
                this.roots[r][c].r != r
                || this.roots[r][c].c != c
            )
            {
                this.roots[r][c]
                    = this.find( this.roots[r][c].r, this.roots[r][c].c );
            }
            
            
            return this.roots[r][c];
        }
        
        
        
        
        private
        boolean
        unite
        (
            final int r1
            , final int c1
        )
        {
            Root root1 = this.find( r1, c1 );
            
            
            for
            (
                final int [] dir
                : this.dir
            )
            {
                final int r2 = r1 + dir[0];
                final int c2 = c1 + dir[1];
                
                if
                (
                    r2 < 0
                    || r2 == this.roots.length
                    || c2 < 0
                    || c2 == this.roots[0].length
                )
                {
                    continue;
                }
                
                final Root root2 = this.find( r2, c2 );
                
                if
                (
                    root2.cellType.equals( CellType.LAND )
                )
                {
                    continue;
                }
                
                this.roots[root1.r][root1.c]
                    = root1.getMergedWith( root2 );
                    
                root1 = this.roots[root1.r][root1.c];
                this.roots[root2.r][root2.c] = root1;
            }
            
            
            if
            (
                root1.cellType.equals( CellType.LAND )
            )
            {
                this.roots[r1][c1]
                    = new Root( r1, c1, root1.m, root1.n, CellType.SEA );
            }
            else
            {
                this.roots[r1][c1] = root1;
            }
            
            
            return root1.m == 0 && root1.n == this.roots[0].length - 1;
        }
        
        
        
        
        private
        record Root
        (
            int r
            , int c
            , int m
            , int n
            , CellType cellType
        )
        implements
        Comparable < Root >
        {
            
            @Override
            public
            int
            compareTo
            (
                final Root root
            )
            {
                
                if
                (
                    this.c == root.c
                )
                {
                    return Integer.compare( this.r, root.r );
                }
                else
                {
                    return Integer.compare( this.c, root.c );
                }
                
            }
            
            
            
            
            private
            Root
            getMergedWith
            (
                final Root root
            )
            {
                final int m = Math.min( this.m, root.m );
                final int n  = Math.max( this.n, root.n );
                int r;
                int c;
                
                if
                (
                    this.c < root.c
                    ||
                    (
                        this.c == root.c
                        && this.r <= root.r
                    )
                )
                {
                    c = this.c;
                    r = this.r;
                }
                else
                {
                    r = root.r;
                    c = root.c;
                }
                
                
                return new Root( r, c, m, n, CellType.SEA); 
            }
            
        }
        
    }
    
    
    
    
    private
    enum CellType
    {
        LAND
        , SEA
    }
    
}
