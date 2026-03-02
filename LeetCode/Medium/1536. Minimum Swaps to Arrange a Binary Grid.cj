class Solution {
    func minSwaps(grid: Array<Array<Int64>>): Int64 {
        var m = grid.size - 1
        var q1 = ArrayQueue<Int64>(m + 1)
        var q2 = ArrayQueue<Int64>(m)
        var answer = 0
        
        for (row in grid) {
            q1.add(m - (row.lastIndexOf(1) ?? -1))
        }
        
        while (m > 0) {
            while (!q1.isEmpty() && (q1.peek() ?? 0) < m) {
                q2.add(q1.remove() ?? 0)
            }
            
            if (q1.isEmpty()) {
                return -1
            } else {
                m--
                answer += q2.size
                q1.remove()
                
                for (e in q1) {
                    q2.add(e)
                }
                
                q1 = q2
                q2 = ArrayQueue<Int64>(m)
            }
        }
        
        answer
    }
}