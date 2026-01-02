class Solution
{

    func
    canMakeArithmeticProgression
    (
        arr: Array < Int64 >
    ): Bool
    {
        sort( arr )
        let diff = arr[1] - arr[0]
        var curr = arr[0] - diff


        for
        (
            num
            in
            arr
        )
        {
            
            if
            (
                num - curr != diff
            )
            {
                return false
            }
            else
            {
                curr = num
            }

        }
        

        true;
    }

}
