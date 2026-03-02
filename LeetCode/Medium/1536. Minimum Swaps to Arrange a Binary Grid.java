class Solution {
    public int minSwaps(int[][] grid) {
        int m = grid.length - 1;
        final ArrayDeque<Integer> arrayDeque1 = new ArrayDeque<>(m + 1);
        final ArrayDeque<Integer> arrayDeque2 = new ArrayDeque<>(m);
        int answer = 0;

        for (final int[] row : grid) {
            int i = m;

            while (i >= 0 && row[i] != 1) {
                i--;
            }

            arrayDeque1.offerLast(m - i);
        }

        while (m >= 1) {
            while (!arrayDeque1.isEmpty() && arrayDeque1.peekFirst() < m) {
                arrayDeque2.offerLast(arrayDeque1.pollFirst());
            }

            if (arrayDeque1.isEmpty()) {
                return -1;
            } else {
                m--;
                answer += arrayDeque2.size();
                arrayDeque1.pollFirst();

                while (!arrayDeque2.isEmpty()) {
                    arrayDeque1.offerFirst(arrayDeque2.pollLast());
                }
            }
        }

        return answer;
    }
}