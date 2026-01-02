class Solution
{

    func
    pivotInteger
    (
        n: Int64
    ): Int64
    {
        let prefixSum = Array < Int64 > ( n + 1, repeat: 0 )
        var sum = 0


        for
        (
            num
            in
            1 ..= n
        )
        {
            prefixSum[num] = prefixSum[num - 1] + num
        }


        for
        (
            num
            in
            n ..= 1 : -1
        )
        {
            
            if
            (
                sum == prefixSum[num - 1]
            )
            {
                return num
            }
            else
            {
                sum += num
            }

        }


        -1
    }

}
