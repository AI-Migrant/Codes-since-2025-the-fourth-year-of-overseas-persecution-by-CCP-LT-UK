class Solution
{

    func minBitwiseArray
    (
        nums: ArrayList < Int64 >
    )
    : Array < Int64 >
    {
        let n = nums.size
        let answer = Array( n, repeat: -1 )


        for
        (
            i
            in
            0 .. n
        )
        {
            var p = 1


            while
            (
                ( nums[i] & p ) != 0
            )
            {
                p <<= 1
            }
            

            if
            (
                p != 1
            )
            {
                answer[i] = nums[i] ^ ( p >> 1 )
            }

        }


        answer
    }

}
