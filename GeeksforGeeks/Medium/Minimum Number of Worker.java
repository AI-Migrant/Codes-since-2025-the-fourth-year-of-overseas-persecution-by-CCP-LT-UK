class Solution
{

    public
    int
    minMen
    (
        int arr []
    )
    {
        final ArrayList < Integer > arrayList = new ArrayList<>();


        for
        (
            int i = 0
            ; i < arr.length
            ; i ++
        )
        {
            final int j = i - arr[i];
            final int k = i + arr[i];

            if
            (
                j <= 0
            )
            {

                if
                (
                    arrayList.isEmpty()
                    ||
                    arrayList.getLast() + arr[arrayList.getLast()] <= k
                )
                {
                    arrayList.clear();
                    arrayList.add(i);
                }
                
                continue;
            }


            while
            (
                (
                    arrayList.size() >= 2
                    && arrayList.get( arrayList.size() - 2 )
                        + arr[arrayList.get( arrayList.size() - 2 )] + 1
                        >= j
                    && arrayList.getLast() + arr[arrayList.getLast()] < k
                )
                ||
                (
                    !arrayList.isEmpty()
                    && arrayList.getLast() - arr[arrayList.getLast()] >= j
                )
            )
            {
                arrayList.removeLast();
            }


            if
            (
                (
                    arrayList.isEmpty()
                    && j <= 0
                )
                ||
                (
                    !arrayList.isEmpty()
                    && arrayList.getLast() + arr[arrayList.getLast()] + 1 >= j
                    && arrayList.getLast() + arr[arrayList.getLast()] < k
                )
            )
            {
                arrayList.add( i );
            }

        }
        
        
        while
        (
            arrayList.size() >= 2
            &&
            (
                arrayList.get( arrayList.size() - 2 )
                + arr[arrayList.get( arrayList.size() - 2 )] + 1 >= arr.length
            )
        )
        {
            arrayList.removeLast();
        }
        

        if
        (
            arrayList.isEmpty()
            || arrayList.getLast() + arr[arrayList.getLast()] + 1 < arr.length
        )
        {
            return -1;
        }
        else
        {
            return arrayList.size();
        }

    }

}
