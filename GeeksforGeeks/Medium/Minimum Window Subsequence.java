class Solution
{
    
    public
    String
    minWindow
    (
        String s1
        , String s2
    )
    {
        final char [] array1 = s1.toCharArray();
        final char [] array2 = s2.toCharArray();
        final int m = array1.length;
        final int n = array2.length;
        int answerLength = Integer.MAX_VALUE;
        int answerStart = 0;
        int answerEnd = 0;
        
        
        for
        (
            int i = s1.indexOf( array2[0] )
            ; i >= 0
            ; i = s1.indexOf( array2[0], i + 1 )
        )
        {
            int j = i + 1;
            int k = 1;
            
            
            while
            (
                j < m
                && k < n
            )
            {
                
                if
                (
                    array1[j] == array2[k]
                )
                {
                    k ++;
                }
                
                j ++;
            }
            
            
            if
            (
                k == n
                && j - i < answerLength
            )
            {
                answerLength = j - i;
                answerStart = i;
                answerEnd = j;
            }
            
        }
        
        
        return s1.substring( answerStart, answerEnd );
    }
    
}
