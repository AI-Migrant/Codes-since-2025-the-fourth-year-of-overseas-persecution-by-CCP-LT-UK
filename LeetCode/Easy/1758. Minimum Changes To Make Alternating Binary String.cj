class Solution {
    func minOperations(s: String): Int64 {
        min(s.iterator().fold([ 0, 0, 48, 49 ], { a, c => [ a[0] + abs(a[2] - Int64(c)), a[1] + abs(a[3] - Int64(c)), a[3], a[2] ] })[0..2]) ?? 0
    }
}
