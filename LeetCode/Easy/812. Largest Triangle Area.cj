class Solution {
    func largestTriangleArea(points: Array<Array<Int64>>): Float64 {
        let N = points.size
        var answer = 0

        for (i in 0..N) {
            for (j in i + 1..N) {
                for (k in j + 1..N) {
                    answer = max(answer, 
                        abs(points[i][0] * (points[j][1] - points[k][1]) +
                            points[j][0] * (points[k][1] - points[i][1]) +
                            points[k][0] * (points[i][1] - points[j][1])))
                }
            }
        }

        0.5 * Float64(answer)
    }
}