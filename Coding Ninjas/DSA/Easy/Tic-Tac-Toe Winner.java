import java.util.*;





public class Solution
{

    public static
    String
    ticTacToeWinner
    (
        ArrayList < ArrayList < Integer > > moves
        , int n
    )
    {
        int[][] grid = new int[3][3];
        
        
        for
        (
            int i = 0
            ; i < n
            ; i ++
        )
        {
            int x = moves.get( i ).get( 0 );
            int y = moves.get( i ).get( 1 );
            grid[x][y] = ( i % 2 ) + 1;
        }


        for
        (
            int i = 0
            ; i < 3
            ; i ++
        )
        {

            if
            (
                grid[i][0] == grid[i][1]
                && grid[i][1] == grid[i][2]
                && grid[i][2] > 0
            )
            {
                return "player" + grid[i][2];
            }
            else if
            (
                grid[0][i] == grid[1][i]
                && grid[1][i] == grid[2][i]
                && grid[2][i] > 0
            )
            {
                return "player" + grid[2][i];
            }
            
        }

        if
        
        (
            (
                (
                    grid[0][0] == grid[1][1]
                    && grid[1][1] == grid[2][2]
                )
                ||
                (
                    grid[0][2] == grid[1][1]
                    && grid[1][1] == grid[2][0]
                )
            )
            &&
            grid[1][1] > 0
        )
        {
            return "player" + grid[1][1];
        }
        else if
        (
            n < 9
        )
        {
            return "uncertain";
        }
        else
        {
            return "draw";
        }

    }
}
