class Solution {
    int[] smallestDiff(int[] a, int[] b, int[] c) {
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int[] answer = new int[3];
        int[] array;

        for (int i = 0, j = 0, k = 0, d, sum, prevSum = 0, min = Integer.MAX_VALUE;
             i < a.length && j < b.length && k < c.length; ) {
            if (a[i] < b[j]) {
                if (a[i] < c[k]) {
                    if (b[j] < c[k]) {
                        array = new int[]{c[k], b[j], a[i]};
                    } else {
                        array = new int[]{b[j], c[k], a[i]};
                    }

                    i++;
                } else {
                    array = new int[]{b[j], a[i], c[k]};
                    k++;
                }
            } else if (a[i] < c[k]) {
                array = new int[]{c[k], a[i], b[j]};
                j++;
            } else if (b[j] < c[k]) {
                array = new int[]{a[i], c[k], b[j]};
                j++;
            } else {
                array = new int[]{a[i], b[j], c[k]};
                k++;
            }

            d = array[0] - array[2];
            sum = Arrays.stream(array).sum();

            if (d < min || (d == min && sum < prevSum)) {
                answer = array;
                min = d;
                prevSum = sum;
            }
        }

        return answer;
    }
}