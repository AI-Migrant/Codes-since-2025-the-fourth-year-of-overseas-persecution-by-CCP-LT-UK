class Solution {
    func reverseBits(n: Int64): Int64 {
        (0..=15).iterator().fold(0, { a, b => a | (((n >> (31 - (b << 1))) & (1 << b)) | ((n << (31 - (b << 1))) & (1 << (31 - b)))) })
    }
}