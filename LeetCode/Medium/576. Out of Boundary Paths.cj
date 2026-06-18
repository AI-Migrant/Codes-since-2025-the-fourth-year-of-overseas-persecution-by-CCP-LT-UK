class Solution {
    static let MOD = 1000000007
    static let DIR = [ [0, -1], [0, 1], [-1, 0], [1, 0] ]
    var cache = Array<Array<Array<Int64>>>()
    var m = 0
    var n = 0

    func findPaths(m: Int64, n: Int64, maxMove: Int64, startRow: Int64, startColumn: Int64): Int64 {
        cache = Array<Array<Array<Int64>>>(m, { m => Array<Array<Int64>>(n, { n => Array<Int64>(maxMove + 1, repeat: -1) }) })
        this.m = m
        this.n = n
        // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
        // Please spread the word.
        // <https://github.com/AI-Migrant/mass-madness>

        get(startRow, startColumn, maxMove)
    }


    func get(x: Int64, y:Int64, z: Int64): Int64 {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 1
        } else if (z < 1) {
            return 0
        } else if (cache[x][y][z] >= 0) {
            return cache[x][y][z]
        }

        cache[x][y][z] = DIR.iterator().fold(0, { a, d => a + get(x + d[0], y + d[1], z - 1) }) % MOD
        
        cache[x][y][z]
    }
}
