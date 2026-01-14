import java.util.*;




class Solution
{
    private static final String [] ODDS = { "1", "3", "5", "7", "9" };
    
    
    
    
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
            final String N = scanner.next();
            
            
            if
            (
                Arrays.stream( ODDS ).anyMatch( odd -> odd.equals( N.substring( N.length() - 1 ) ) )
            )
            {
                System.out.println( 0 );
            }
            else if
            (
                Arrays.stream( ODDS ).anyMatch( odd -> N.contains( odd ) ) )
            {
                System.out.println( 1 );
            }
            else if
            (
                N.length() == 1
            )
            {
                System.out.println( -1 );
            }
            else
            {
                int numberOfOperations = 3;
                
                
                for
                (
                    final char c
                    : N.substring( 0, N.length() - 1).toCharArray()
                )
                {
                    
                    if
                    (
                        c > N.charAt( N.length() - 1 )
                    )
                    {
                        numberOfOperations = 2;
                        
                        break;
                    }
                    
                }
                
                
                System.out.println( numberOfOperations );
            }
            
        }
        
        
        
        scanner.close();
    }
    
}
