class Solution {
    private static const MOD = 1_000_000_007


    func concatenatedBinary(n: Int64): Int64 {
        var answer = 0
        var j = 0

        for (i in 1..=n) {
            j = i
            
            while (j != 0) {
                answer <<= 1
                j >>= 1
            }

            answer = (answer | i) % MOD
        }

        answer
    }
}
