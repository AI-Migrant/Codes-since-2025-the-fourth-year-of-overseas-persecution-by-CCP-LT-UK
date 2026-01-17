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
        final int t = scanner.nextInt();


        for
        (
            int h = 0
            ; h < t
            ; h ++
        )
        {
            final int n = scanner.nextInt();
            boolean o = ( scanner.nextInt() % 2 == 0 );
            String answer = "YES";


            for
            (
                int i = 1
                ; i < n
                ; i ++
            )
            {

                if
                (
                    ( scanner.nextInt() % 2 == 0 ) == o
                )
                {
                    answer = "NO";
                }

                o = !o;
            }


            System.out.println( answer );
        }


        scanner.close();
    }

}
