import java.util.*;




class Solution
{

    public static
    void
    main
    (
        String [] args
    )
    {
        final Scanner scanner = new Scanner( System.in );
        final int T = scanner.nextInt();


        for
        (
            int t = 0
            ; t < T
            ; t ++
        )
        {
            final int N = scanner.nextInt();
            final int A = scanner.nextInt();
            final int B = scanner.nextInt();
            boolean isWearingJacket = false;
            int answer = 0;


            for
            (
                int i = 0
                ; i < N
                ; i ++
            )
            {

                if
                (
                    isWearingJacket
                    && scanner.nextInt() > B
                )
                {
                    isWearingJacket = false;
                }
                else if
                (
                    !isWearingJacket
                    && scanner.nextInt() < A
                )
                {
                    isWearingJacket = true;
                    answer ++;
                }

            }


            System.out.println( answer );
        }

        scanner.close();
    }

}
