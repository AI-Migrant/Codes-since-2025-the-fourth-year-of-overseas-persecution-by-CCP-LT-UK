class Solution
{

    public
    int
    sumFourDivisors
    (
        int [] nums
    )
    {
        final HashMap < Integer, Integer > hashMap = new HashMap <> ();
        int answer = 0;


        for
        (
            final int num
            : nums
        )
        {
            answer += getFourDivisorSumOrZero( hashMap, num );
        }


        return answer;
    }




    private
    int
    getFourDivisorSumOrZero
    (
        final HashMap < Integer, Integer > hashMap
        , final int num
    )
    {

        if
        (
            hashMap.containsKey( num )
        )
        {
            return hashMap.get( num );
        }
       
        int sqrt = Double.valueOf( Math.sqrt( num ) ).intValue();
        int count = 2;
        int sum = num + 1;

        if
        (
            sqrt * sqrt == num
        )
        {
            sum += sqrt;
            count ++;
            sqrt --;
        }


        for
        (
            int d = 2
            ; d <= sqrt
            ; d ++
        )
        {

            if
            (
                num % d == 0
            )
            {
                sum += d + ( num / d );
                count += 2;
            }

        }

        if
        (
            count == 4
        )
        {
            hashMap.put( num, sum );


            return sum;
        }
        else
        {
            hashMap.put( num, 0 );


            return 0;
        }

    }

}
