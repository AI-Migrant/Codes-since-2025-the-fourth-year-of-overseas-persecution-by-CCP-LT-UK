class Solution {
    func projectionArea(grid: Array<Array<Int64>>): Int64 {
        var answer = 0

        for (i in 0..grid.size) {
            var x = 0
            var y = 0

            for(j in 0..grid.size) {
                if (grid[i][j] != 0) {
                    answer++
                    x = max(x, grid[i][j])
                }
                
                if (grid[j][i] != 0) {
                    y = max(y, grid[j][i])
                }
            }

            answer += x + y
        }

        answer
    }
}