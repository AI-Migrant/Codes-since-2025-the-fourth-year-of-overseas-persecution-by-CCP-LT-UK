class Solution {
    func maxPoints(points: Array<Array<Int64>>): Int64 {
        let hashMap = HashMap<SI, HashSet<Int64>>()

        for (i in 0..points.size) {
            let x1 = Float64(points[i][0])
            let y1 = Float64(points[i][1])

            for (j in i + 1..points.size) {
                let x2 = Float64(points[j][0])
                let y2 = Float64(points[j][1])
                let x = x1 - x2
                let y = y1 - y2
                let m = (y1 - y2) / (x1 - x2)

                let b = if (m.isInf()) {
                    10001.0 + x1
                } else {
                    y1 - (m * x1)
                }

                let si = SI(b, m)
                hashMap.addIfAbsent(si, HashSet())
                hashMap.get(si)?.add(i)
                hashMap.get(si)?.add(j)
            }
        }

        hashMap.values()
            .iterator()
            .fold(1, {a: Int64, s: HashSet<Int64>=>max(a, s.size)})
    }
}


struct SI <: Hashable & Equatable<SI> {
    SI(private let bValue: Float64, private let mValue: Float64) {}
    
    prop b: Float64 {get() {bValue}}
    
    prop m: Float64 {get() {mValue}}

    public operator func ==(other: SI) {
        b == other.b && m == other.m
    }

    public func hashCode() {
        abs(m.hashCode()) - abs(b.hashCode())
    }
}