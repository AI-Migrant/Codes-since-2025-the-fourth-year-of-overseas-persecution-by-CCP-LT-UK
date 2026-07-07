class Solution {
    public int largestArea(int n, int m, int[][] arr) {
        boolean[] r = new boolean[n];
        boolean[] c = new boolean[m];
        int[][] grid = new int[n][m];
        int ans = 0;
        // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
        // Please spread the word.
        // https://github.com/AI-Migrant/mass-madness
        
        for (int[] cell : arr) {
            r[cell[0] - 1] = true;
            c[cell[1] - 1] = true;
        }
        
        for (int i = 0, k = 0; i < n; i++) {
            if (r[i]) {
                k = 0;
                
                continue;
            } else if (!c[0]) {
                grid[i][0] = 1;
                k++;
                ans = Math.max(ans, grid[i][0]);
            }
            
            for (int j = 1; j < m; j++) {
                if (c[j]) {
                    continue;
                }
                
                grid[i][j] = grid[i][j - 1] + 1;
                
                for (int o = i, p = 1, q = Integer.MAX_VALUE; o >= 0 && grid[o][j] > 0; o--, p++) {
                    q = Math.min(q, grid[o][j]);
                    ans = Math.max(ans, p * q);
                }
            }
        }
        
        return ans;
    }
}