class Solution {
    func minPathSum(grid: Array<Array<Int64>>): Int64 {
        let m = grid.size
        let n = grid[0].size
        
        for (i in 1..n) {
            grid[0][i] += grid[0][i - 1]
        }
        
        for (i in 1..m) {
            grid[i][0] += grid[i - 1][0]
            
            for (j in 1..n) {
                grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])
            }
        }
        
        grid[m - 1][n - 1]
    }
}
