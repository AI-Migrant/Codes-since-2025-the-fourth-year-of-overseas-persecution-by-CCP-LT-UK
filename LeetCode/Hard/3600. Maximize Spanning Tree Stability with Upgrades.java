class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        if (n - 1 > edges.length) {
            return -1;
        }

        final PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[2] - x[2]);
        int answer = Integer.MAX_VALUE;
        int c = 1;
        final DSU dsu = new DSU(n);

        for (final int[] edge : edges) {
            if (edge[3] == 1) {
                if (!dsu.join(edge[0], edge[1])) {
                    return -1;
                } else {
                    c++;
                    answer = Math.min(answer, edge[2]);
                }
            } else {
                pq.offer(edge);
            }
        }

        while (c < n && !pq.isEmpty()) {
            final int[] edge = pq.poll();
            final int u = edge[0];
            final int v = edge[1];
            final int s = edge[2];
            
            if (!dsu.join(u, v)) {
                continue;
            } else {
                c++;

                if (c + k > n) {
                    k--;
                    answer = Math.min(answer, s * 2);
                } else {
                    answer = Math.min(answer, s);
                }
            }
        }

        if (c == n) {
            return answer;
        } else {
            return -1;
        }
    }


    class DSU {
        private int[] parents;


        private DSU(final int n) {
            parents = IntStream.range(0, n).toArray();
        }


        private int find(final int x) {
            int px = parents[x];

            if (px != x) {
                px = find(px);
            }

            parents[x] = px;

            return px;
        }


        private boolean join(final int x, final int y) {
            final int px = find(x);
            final int py = find(y);

            if (px == py) {
                return false;
            } else if (px < py) {
                parents[py] = px;
            } else {
                parents[px] = py;
            }

            return true;
        }
    }
}