// Solution 1
class Solution {
    static int noOfWays(int m, int n, int x) {
        int[][] cache = new int[n][x + 1];
        
        for (final int[] a : cache) {
            Arrays.fill(a, -1);
        }
        
        return solve(cache, m, n, x);
    }
    
    
    private static int solve(final int[][] cache, final int m, int n, final int x) {
        final int o = m * n;
        
        if (o < x || n > x) {
            return 0;
        } else if (n == 1 || x == n || o == x) {
            return 1;
        } else if (cache[--n][x] != -1) {
            return cache[n][x];
        }
        
        for (int i = 1; i <= m; i++) {
            cache[n][x] += solve(cache, m, n, x - i);
        }
        
        return ++cache[n][x];
    }
}




// Solution 2
import java.util.stream.*;


class Solution {
    static int noOfWays(int m, int n, int x) {
        return n > x || m * n < x ? 0 : IntStream.range(0, n).collect(() -> new int[x +
1], (a, c) -> IntStream.iterate(Math.min((c + 1) * m, x), i ->
i - 1).limit(Math.min((c + 1) * m, x) - c).forEach(i -> a[i] =
Math.max(1, Arrays.stream(a, Math.max(c, i - m), i).sum())), (a, c) -> {})[x];

    }
}


