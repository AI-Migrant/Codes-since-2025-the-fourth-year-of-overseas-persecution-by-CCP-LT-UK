import java.util.*;





public class Solution
{
    
    public static
    boolean
    ninjaGram
    (
        String str
    )
    {
        
        HashSet < Character > set = new HashSet <> ();
        
        
        for
        (
            char c
            : str.toLowerCase().toCharArray()
        )
        {
            set.add( c );
        }
        
        
        return set.size() > 25;
    }
    
}
