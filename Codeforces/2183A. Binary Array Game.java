import java.util.*;




public class Main
{

    public static
    void
    main
    (
        String args []
    )
    {
        final Scanner scanner = new Scanner( System.in );
        final int n = scanner.nextInt();
        final int [] array = new int [ n ];


        for
        (
            int i = 0
            ; i < n
            ; i ++
        )
        {
            array[i] = scanner.nextInt();
        }


        scanner.close();

        if
        (
            n == 1
            || array[n - 1] != array[n - 2]
        )
        {
            System.out.println( array[n - 1] );


            return;
        }


        for
        (
            int i = 1
            ; i < n
            ; i += 2
        )
        {

            if
            (
                array[i] != array[i - 1]
            )
            {
                System.out.println( array[i - 1] );

                break;
            }

        }


    }

}
