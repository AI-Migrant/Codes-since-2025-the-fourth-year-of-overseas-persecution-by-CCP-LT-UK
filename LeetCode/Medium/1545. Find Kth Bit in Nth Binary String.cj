class Solution {
    func findKthBit(n: Int64, k: Int64): Rune {
        Rune(solve(n, k))
    }


    private func solve(n: Int64, k: Int64): UInt32 {
        if (k == 1) {
            return 48
        }
        
        var m = 1 << (n - 1)
        
        match (k.compare(m)) {
            case Ordering.EQ => 49
            case Ordering.LT => solve(n - 1, k)
            case _ => 97 - solve(n, m + m - k)
        }
    }
}
