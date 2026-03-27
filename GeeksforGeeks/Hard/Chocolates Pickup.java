class Solution {
    private int[][] grid;
    private int[][][] cache;
    private int n;
    private int m;
    
    
    public int maxChocolate(int grid[][]) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        cache = new int[n][m][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(cache[i][j], -1);
            }
        }
        
        return solve(0, 0, m - 1);
    }
    
    
    public int solve(final int i, final int j, final int k) {
        if (i == n || j < 0 || j >= m || k < 0 || k >= m) {
            return 0;
        } else if (cache[i][j][k] != -1) {
            return cache[i][j][k];
        }
        
        int c = 0;
        
        for (int u = -1; u < 2; u++) {
            int p = j + u;
            
            for (int v = -1; v < 2; v++) {
                int q = k + v;
                
                if (p > q) {
                    c = Math.max(c, solve(i + 1, q, p));
                } else {
                    c = Math.max(c, solve(i + 1, p, q));
                }
            }
        }
        
        cache[i][j][k] = c += grid[i][j] + (j == k ? 0 : grid[i][k]);
        
        return c;
    }
}