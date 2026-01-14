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
        final Scanner scanner = new Scanner(System.in);
        final int T = scanner.nextInt();


        for
        (
            int t = 0
            ; t < T
            ; t ++
        )
        {
            scanner.nextInt();
            final String S = scanner.next();
            final HashMap < Character, Integer > hashMap = new HashMap <> ();
            String answer = "YES";


            for (final char c : S.toCharArray()) {
                hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);

                if (hashMap.get(c) == 3) {
                    answer = "NO";
                    
                    break;
                }
            }


            System.out.println(answer);
        }

        scanner.close();
    }

}
