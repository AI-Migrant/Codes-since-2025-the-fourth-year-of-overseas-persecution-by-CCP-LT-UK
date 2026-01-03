class Solution
{
    private static let sizes: VArray < Int64, $10 > = [ 0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 ]
    private static let digits = [ "1", "2", "3", "4", "5", "6", "7", "8", "9" ]
    private static let answer = Array < Array < String > > ( 10, repeat: [] )
    



    static
    init
    ()
    {

        for
        (
            length
            in
            1 ..= 9
        )
        {
            let arrayList = ArrayList < String > ( sizes[length] )
            permutation( arrayList, length, "" )
            answer[length] = arrayList.toArray()
        }
        
    }




    func
    getPermutation
    (
        n: Int64
        , k: Int64
    )
    : String
    {
        answer[n][k - 1]
    }




    private static
    func
    permutation
    (
        arrayList: ArrayList < String >
        , length: Int64
        , s: String
    )
    : Unit
    {

        if
        (
            s.size == length
        )
        {
            arrayList.add( s )


            return
        }


        for
        (
            d
            in
            digits[.. length]
        )
        {
            
            if
            (
                s.contains( d )
            )
            {
                continue
            }

            permutation( arrayList, length, s + d )
        }

    }

}
