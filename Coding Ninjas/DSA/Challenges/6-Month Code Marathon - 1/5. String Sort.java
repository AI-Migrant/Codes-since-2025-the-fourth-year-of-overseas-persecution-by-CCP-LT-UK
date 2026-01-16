import java.util.*;





public class Solution
{
	public static
	String
	stringSort
	(
		String s
	)
	{
		char[] arr = s.toCharArray();
		Arrays.sort( arr );
		StringBuilder ans = new StringBuilder();


		for
		(
			char c
			: arr
		)
		{
			ans.append( c );
		}


		return ans.toString();
	}

}
