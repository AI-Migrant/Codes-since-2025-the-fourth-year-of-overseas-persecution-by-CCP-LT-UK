class Solution {
    func minimumDeletions(s: String): Int64 {
        var bs = 0
        var answer = 0
        
        for (c in s) {
            if (c == 97) {
                if (bs != 0) {
                    bs--
                    answer++
                }
            } else {
                bs++
            }
        }

        answer
    }
}