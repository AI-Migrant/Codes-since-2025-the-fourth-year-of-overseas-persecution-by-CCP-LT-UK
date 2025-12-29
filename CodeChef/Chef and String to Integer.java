public static
int
myAtoi
(
    String s
)
{
    s = s.trim();
    int p, i;
    
    if
    (
        s.charAt( 0 ) == '-'
    )
    {
        p = -1;
    }
    else
    {
        p = 1;
    }
    

    while
    (
        i < s.length()
        && Character.isDigit( s.charAt( i ) )
    )
    {
        i ++;
    }


    return Integer.parseInt( s.substring( 0, i ) ) * p;
}
