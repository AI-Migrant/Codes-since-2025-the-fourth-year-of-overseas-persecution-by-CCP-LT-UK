import java.util.*;





public class Solution
{

	public static
	String
	encode
	(
		String secretInformation
	)
	{
		StringBuilder s = new StringBuilder();


		for
		(
			char c
			: secretInformation.toCharArray()
		)
		{
			s.appendCodePoint( c + 1 );
		}


		return s.toString();
	}





	public static
	String
	decode
	(
		String encodedInformation
	)
	{
		StringBuilder s = new StringBuilder();


		for
		(
			char c
			: encodedInformation.toCharArray()
		)
		{
			s.appendCodePoint( c - 1 );
		}


		return s.toString();
	}
	
}
