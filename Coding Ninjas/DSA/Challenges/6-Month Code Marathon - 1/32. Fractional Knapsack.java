import java.util.*;

/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/

public class Solution
{

    public static
	double
	maximumValue
	(
		Pair[] items
		, int n
		, int w
	)
	{
		Arrays.sort( items, new ItemComparator() );
		double ans = 0;


		for
		(
			Pair item
			: items
		)
		{
			
			if
			(
				item.weight > w
			)
			{                
				ans += ( ( ( double ) ( item.value ) ) / item.weight ) * w;

				break;
			}
			else
			{
				ans += item.value;
				w -= item.weight;
			}

		}


		return ans;
    }

}






class ItemComparator
implements Comparator < Pair >
{

	@Override
	public
	int
	compare
	(
		Pair item1
		, Pair item2
	)
	{
		double value1 = ( ( double ) ( item1.value ) ) / item1.weight;
		double value2 = ( ( double ) ( item2.value ) ) / item2.weight;

		
		return Double.compare( value2, value1 );
	}
}
