class Solution {
    func uniquePaths(m: Int64, n: Int64): Int64 {
        let dp = Array(n, repeat: 1)
        
        for (_ in 1..m) {
            for (i in 1..n) {
                dp[i] += dp[i - 1]
            }
        }
        
        dp[n - 1]
    }
}
