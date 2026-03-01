class Solution {
    func minPartitions(n: String): Int64 {
        Int64(n.iterator().fold(0u8, { a, c => max(a, c) }) - 48)
    }
}
