class Solution {
    public int shortestPath(int V, int src, int dest, int[][] edges) {
        ArrayList<int[]>[] graph = new ArrayList[V];
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        boolean[] visited = new boolean[V];
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> dist[x] - dist[y]);
        pq.offer(src);
        
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (var edge : edges) {
            graph[edge[0]].add(new int[] { edge[1], edge[2] });
            graph[edge[1]].add(new int[] { edge[0], edge[2] });
        }
        
        while (!pq.isEmpty()) {
            int u = pq.poll();
            int w = dist[u];
            
            if (u == dest) {
                return w;
            } else {
                visited[u] = true;
            }
            
            for (var v : graph[u]) {
                if (!visited[v[0]] && w + v[1] < dist[v[0]]) {
                    dist[v[0]] = w + v[1];
                    pq.offer(v[0]);
                }
            }
        }
        
        return -1;
    }
}