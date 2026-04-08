class Solution {
    func judgeCircle(moves: String): Bool {
        var p = 0
        var q = 0
        
        for (move in moves.toRuneArray()) {
            match (move) {
                case r"U" => p++
                case r"D" => p--
                case r"R" => q++
                case _ => q--
            }
        }
        
        return p == 0 && q == 0
    }
}