class Solution
{
    
    public static
    boolean
    checkRedundancy
    (
        String s
    )
    {
        final Stack < Character > stack = new Stack <> ();
        
        
        for
        (
            final char c
            : s.toCharArray()
        )
        {
            
            if
            (
                Character.isLetter( c )
            )
            {
                continue;
            }
            else if
            (
                Character.valueOf( c ).equals( ')' )
            )
            {
                
                if
                (
                    stack.pop().equals( '(' )
                )
                {
                    return true;
                }
                
                
                while
                (
                    !stack.isEmpty()
                    && !stack.peek().equals( '(' )
                )
                {
                    stack.pop();
                }
                
                
                stack.pop();
            }
            else
            {
                stack.push( c );
            }
            
            
        }
        
        
        return false;
    }
    
}
