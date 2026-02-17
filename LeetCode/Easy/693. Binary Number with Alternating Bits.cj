class Solution {
    func hasAlternatingBits(n: Int64): Bool {
        var i = 62 - leadingZeros(n)
        var k = 0

        while (i >= 0) {
            if (((n >> i) & 1) != k) {
                return false
            }

            k ^= 1
            i--
        }

        true
    }
}