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

        dsu.print();
        for
        (
            int i = 0
            ; i < cells.length
            ; i ++
        )
        {
            System.out.println( i );
            if
            (
                dsu.unite( cells[i][0], cells[i][1] )
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
                    roots[i][j] = new Root( i, j, j, j );
                }


            }


        }




        void
        print
        ()
        {


            for
            (
                Root [] row
                : roots
            )
            {


                for
                (
                    Root root
                    : row
                )
                {
                    System.out.print( root + ", " );
                }


                System.out.println();
            }
        }




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
                this.roots[r][c] = 
                    this.find( this.roots[r][c].r, this.roots[r][c].c );
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
                root1 = root1.merge( root2 );

                this.roots[r2][c2] = root1;
            }


            roots[r1][c1] = root1;
            print();


            return root1.m == 0 && root1.n == this.roots[0].length - 1;
        }




        private
        record Root
        (
            int r
            , int c
            , int m
            , int n
        )
        {




            Root
            merge
            (
                Root root
            )
            {

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
                    return new Root
                    (
                        this.r
                        , this.c
                        , Math.min( this.m, root.m )
                        , Math.max( this.n, root.n )
                    );
                }
                else
                {
                    return new Root
                    (
                        root.r
                        , root.c
                        , Math.min( this.m, root.m )
                        , Math.max( this.n, root.n )
                    );
                }

            }

        }

    }

}
