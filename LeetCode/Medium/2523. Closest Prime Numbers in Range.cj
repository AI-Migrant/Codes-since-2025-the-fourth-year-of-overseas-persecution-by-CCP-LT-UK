class Solution
{
    private static const LENGTH = 5_000_000
    private static let primeArray = Array( LENGTH + 1, repeat: true )
    private static let distanceArray = Array( LENGTH + 1, repeat: Int64.Max )




    static
    init
    ()
    {
        primeArray[0] = false
        primeArray[1] = false
        var prev = 2


        for
        (
            i
            in
            4 ..= LENGTH : 2
        )
        {
            primeArray[i] = false
        }


        for
        (
            i
            in
            3 ..= LENGTH
        )
        {

            if
            (
                primeArray[i]
            )
            {
                distanceArray[i] = i - prev
                prev = i


                for
                (
                    j
                    in
                    i + i ..= LENGTH : i
                )
                {
                    primeArray[j] = false
                }


            }


        }


    }




    func closestPrimes
    (
        left: Int64
        , right: Int64
    )
    : Array < Int64 >
    {
        var answerIndex = -1
        var answerDistance = Int64.Max


        for
        (
            i
            in
            left + 1 ..= right
        )
        {
            
            if
            (
                distanceArray[i] < answerDistance
                && i - distanceArray[i] >= left
            )
            {
                answerIndex = i
                answerDistance = distanceArray[i]
            }

        }


        if
        (
            answerIndex == -1
        )
        {
            [ -1, -1 ]
        }
        else
        {
            [ answerIndex - answerDistance, answerIndex ]
        }
        
    }

}
