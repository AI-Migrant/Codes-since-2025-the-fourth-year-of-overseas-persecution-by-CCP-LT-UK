public static
int
additionalMoneyRequired
(
    int x
    , int y
    , int z
)
{
    return Math.max( 0, z - x - y );
}
