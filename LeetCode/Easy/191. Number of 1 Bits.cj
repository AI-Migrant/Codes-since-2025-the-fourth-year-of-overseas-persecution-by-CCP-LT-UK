class Solution {
    func hammingWeight(n: Int64): Int64 {
        var p = 1 << 31
        var answer = 0
        
        while (p != 0) {
            if ((n & p) != 0) {
                answer++
            }

            p >>= 1
        }

        answer
    }
}