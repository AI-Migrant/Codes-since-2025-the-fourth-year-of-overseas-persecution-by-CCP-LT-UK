
public class Solution
{
	
	public static
    String
    reverseOrderWords
    (
        String str
    )
    {
        String[] arr = str.split( " " );
        StringBuilder ans = new StringBuilder();


        for
        (
            int i = arr.length - 1
            ; i >= 0
            ; i --
        )
        {
            ans.append( arr[i] + " " );
        }


        return ans.substring( 0, ans.length() - 1 );
    }

}
