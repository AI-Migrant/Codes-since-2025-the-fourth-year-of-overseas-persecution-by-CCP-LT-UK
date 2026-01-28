import java.util.*;
import java.util.AbstractMap.*;


class Solution {
    private static int[][] dir = {{0, 1}, {1, 0}};


    public int minCost(int[][] grid, int k) {
        final int m = grid.length;
        final int n = grid[0].length;
        final int M = m - 1;
        final int N = n - 1;
        final State[][] cache = new State[m][n];
        final PriorityQueue<State> priorityQueue = new PriorityQueue<>((s1, s2) ->
                s1.getCost() == s2.getCost() ?
                        Integer.compare(s1.getTeleportations(), s2.getTeleportations()) :
                        Integer.compare(s1.getCost(), s2.getCost()));
        priorityQueue.offer(new State(0, 0, k, 0));
        final TreeMap<Integer, HashSet<SimpleImmutableEntry<Integer, Integer>>> treeMap = new TreeMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!treeMap.containsKey(grid[i][j])) {
                    treeMap.put(grid[i][j], new HashSet<>());
                }

                treeMap.get(grid[i][j]).add(new SimpleImmutableEntry<>(i, j));
            }
        }

        while (!priorityQueue.isEmpty()) {
            State currState = priorityQueue.poll();
            final int i = currState.getI();
            final int j = currState.getJ();
            final int teleportations = currState.getTeleportations();
            final int cost = currState.getCost();
            System.out.println(i + " " + j + " " + teleportations + " " + cost);
            if (i == M && j == N) {
                return cost;
            }

            for (int[] d : dir) {
                final int x = i + d[0];
                final int y = j + d[1];

                if (x < m && y < n) {
                    final int newCost = grid[x][y] + cost;
                    final State oldState = cache[x][y];

                    if (oldState == null || (oldState.getCost() > newCost ||
                            (oldState.getCost() == newCost &&
                                    oldState.getTeleportations() < teleportations))) {
                        {
                            final State newState = new State(x, y, teleportations, newCost);
                            cache[x][y] = newState;
                            priorityQueue.offer(newState);
                        }

                    }
                }
            }

            if (teleportations >= 1) {
                treeMap.headMap(grid[i][j]).values().forEach(s -> s.forEach(e -> {
                    final int x = e.getKey();
                    final int y = e.getValue();
                    final int newCost = grid[x][y] + cost;
                    final State oldState = cache[x][y];

                    if (oldState == null || oldState.getCost() > newCost ||
                            (oldState.getCost() == newCost &&
                                    oldState.getTeleportations() < teleportations - 1)) {
                        final State newState = new State(x, y, teleportations - 1, newCost);
                        cache[x][y] = newState;
                        priorityQueue.offer(newState);
                    }
                }));
            }


        }

        return 0;
    }
}


class State {
    private int i;
    private int j;
    private int teleportations;
    private int cost;


    State(final int i, final int j, final int teleportations, final int cost) {
        this.setI(i);
        this.setJ(j);
        this.setTeleportations(teleportations);
        this.setCost(cost);
    }


    int getI() {
        return this.i;
    }


    void setI(final int i) {
        this.i = i;
    }


    int getJ() {
        return this.j;
    }


    void setJ(final int j) {
        this.j = j;
    }


    int getTeleportations() {
        return this.teleportations;
    }


    void setTeleportations(final int teleportations) {
        this.teleportations = teleportations;
    }


    int getCost() {
        return this.cost;
    }


    void setCost(final int cost) {
        this.cost = cost;
    }
}