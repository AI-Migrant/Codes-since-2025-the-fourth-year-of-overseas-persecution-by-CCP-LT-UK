class Solution
{
    func minTimeToVisitAllPoints
    (
        points: Array < Array < Int64 > >
    )
    : Int64
    {
        var answer = 0


        for
        (
            i
            in
            1 .. points.size
        )
        {
            answer += max(
                abs( points[i][0] - points[i - 1][0] )
                , abs( points[i][1] - points[i - 1][1] )
            )
        }


        answer
    }

}
