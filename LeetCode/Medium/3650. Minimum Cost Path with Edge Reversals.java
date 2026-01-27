class Solution {
    public int minCost(int n, int[][] edges) {
        final int target = n - 1;
        final HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        final HashMap<Integer, HashMap<Integer, Integer>> reverseGraph = new HashMap<>();
        final HashSet<Integer> visited = new HashSet<>();
        final PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue =
                new PriorityQueue<>(Comparator.comparing(Map.Entry::getValue));

        for (final int[] edge : edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new HashMap<>());
            }
            
            if (!reverseGraph.containsKey(edge[1])) {
                reverseGraph.put(edge[1], new HashMap<>());
            }

            graph.get(edge[0]).put(edge[1], edge[2]);
            reverseGraph.get(edge[1]).put(edge[0], edge[2] * 2);
        }

        if (graph.containsKey(0)) {
            graph.get(0).entrySet().forEach(priorityQueue::offer);
        }

        if (reverseGraph.containsKey(0)) {
            reverseGraph.get(0).entrySet().forEach(priorityQueue::offer);
        }

        visited.add(0);

        if (reverseGraph.containsKey(0)) {
            reverseGraph.get(0).entrySet().forEach(priorityQueue::offer);
        }

        while (!priorityQueue.isEmpty()) {
            final int node = priorityQueue.peek().getKey();
            final int cost = priorityQueue.poll().getValue();
            
            if (node == target) {
                return cost;
            } else if (visited.contains(node)) {
                continue;
            } else {
                visited.add(node);
            }

            if (graph.containsKey(node)) {
                graph.get(node).entrySet().forEach(e -> {
                    e.setValue(e.getValue() + cost);
                    priorityQueue.offer(e);
                });
            }

            if (reverseGraph.containsKey(node)) {
                reverseGraph.get(node).entrySet().forEach(e -> {
                    e.setValue(e.getValue() + cost);
                    priorityQueue.offer(e);
                });
            }
            
        }

        return -1;
    }
}