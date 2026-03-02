class Solution {
    func uniquePathsWithObstacles(obstacleGrid: Array<Array<Int64>>): Int64 {
        if (obstacleGrid.first?.first == 1) {
            return 0
        }
        
        let m = obstacleGrid.size
        let n = obstacleGrid[0].size
        var j = 0
        
        while (j < m && obstacleGrid[j].first == 0) {
            obstacleGrid[j][0] = 1
            j++
        }
        
        while (j < m) {
            obstacleGrid[j][0] = 0
            j++
        }
        
        j = 1
        
        while (j < n && obstacleGrid.first?[j] == 0) {
            obstacleGrid.first?[j] = 1
            j++
        }
        
        while (j < n) {
            obstacleGrid.first?[j] = 0
            j++
        }
        
        for (i in 1..m) {
            j = 1
            
            while (j < n) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]
                } else {
                    obstacleGrid[i][j] = 0
                }
                
                j++
            }
        }

        obstacleGrid[m - 1][n - 1]
    }
}
