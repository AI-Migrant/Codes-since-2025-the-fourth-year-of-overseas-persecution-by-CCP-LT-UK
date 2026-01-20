class Solution {
    func computeArea(ax1: Int64, ay1: Int64, ax2: Int64, ay2: Int64, bx1: Int64, by1: Int64, bx2: Int64, by2: Int64): Int64 {
        let answer = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1)

        if (ax1 < bx2 && ax2 > bx1 && ay1 < by2 && ay2 > by1) {
            return answer - ((min(ax2, bx2) - max(ax1, bx1)) *
            (min(ay2, by2) - max(ay1, by1)))
        }

        answer
    }
}