class Solution {
    private static long[] p;


    static {
        p = new long[100001];
        long j = 1;

        for (int i = 1; i < 100001; i++, j += i) {
            p[i] = j;
        }
    }


    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        final int n = workerTimes.length;
        final int[] a = new int[n];
        Arrays.fill(a, 1);
        final PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) ->
                Long.compare(workerTimes[x] * p[a[x]], workerTimes[y] * p[a[y]]));
        long answer = 0;

        for (int i = 0; i < n; i ++) {
            pq.offer(i);
        }

        while (mountainHeight > 0) {
            final int x = pq.poll();
            answer = Math.max(answer, workerTimes[x] * p[a[x]]);
            a[x]++;
            pq.offer(x);
            mountainHeight--;
        }

        return answer;
    }
}