class Solution
{
    static let answer: ArrayList < Int64 >




    static
    init
    ()
    {
        answer = ArrayList < Int64 > ( 339 )

        
        for
        (
            num
            in
            1 ..= 10000
        )
        {

            if
            (
                isSelfDividing( num )
            )
            {
                answer.add( num )
            }

        }

    }




    func
    selfDividingNumbers
    (
        left: Int64
        , right: Int64
    )
    : ArrayList < Int64 >
    {
        answer[indexOfLeft( left ) ..= indexOfRight( right )]
    }




    private static
    func
    isSelfDividing
    (
        num: Int64
    )
    {
        var worker = num


        while
        (
            worker > 0
        )
        {
            let d = worker % 10
            worker /= 10

            if
            (
                d == 0 ||
                num % d != 0
            )
            {
                return false
            }

        }


        true
    }



    private
    func
    indexOfLeft
    (
        target: Int64
    )
    : Int64
    {
        var left = 0
        var right = 338


        while
        (
            left < right
        )
        {
            let mid = ( left + right ) / 2

            if
            (
                answer[mid] == target
            )
            {
                return mid
            }
            else if
            (
                answer[mid] < target
            )
            {
                left = mid + 1
            }
            else
            {
                right = mid
            }

        }


        left
    }




    private
    func
    indexOfRight
    (
        target: Int64
    )
    : Int64
    {
        var left = 0
        var right = 338


        while
        (
            left < right
        )
        {
            let mid = ( left + right + 1 ) / 2

            if
            (
                answer[mid] <= target
            )
            {
                left = mid
            }
            else
            {
                right = mid - 1
            }

        }


        left
    }

}
