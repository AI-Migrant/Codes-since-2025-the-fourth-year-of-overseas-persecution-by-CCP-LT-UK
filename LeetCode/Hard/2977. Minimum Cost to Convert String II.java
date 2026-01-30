//TLE


class Solution {
    private static final long INF = Long.MAX_VALUE / 2;


    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        long answer = 0L;
        final StringExchanger stringExchanger = new StringExchanger(original, changed, cost);
        final int maxLength = stringExchanger.getMaxLength();
        final int N = source.length();
        final long[] cache = new long[N + 1];

        for (int i = N - 1; i >= 0; i--) {
            long total = INF;

            for (int k = Math.min(maxLength, N - i); k >= 1; k--) {
                final int j = i + k;
                final String s = source.substring(i, j);
                final String t = target.substring(i, j);

                if (s.equals(t)) {
                    total = Math.min(total, cache[j]);
                } else {
                    final int changeCost = stringExchanger.getChangeCost(s, t);

                    if (changeCost != -1) {
                        total = Math.min(total, changeCost + cache[j]);
                    }
                }
            }

            cache[i] = total;
        }

        if (cache[0] == INF) {
            return -1;
        } else {
            return cache[0];
        }
    }
}


class StringExchanger {
    private final HashMap<Integer, HashMap<String, HashMap<String, Integer>>> hashMap;


    StringExchanger(final String[] original, final String[] changed, final int[] cost) {
        this.hashMap = fillHashMap(original, changed, cost);
        hashMap.keySet().forEach(this::getHashMap);
    }


    private HashMap<Integer, HashMap<String, HashMap<String, Integer>>>
    fillHashMap(final String[] original, final String[] changed, final int[] cost) {
        HashMap<Integer, HashMap<String, HashMap<String, Integer>>> hashMap = new HashMap<>();

        for (int i = 0; i < cost.length; i++) {
            final String o = original[i];
            final String c = changed[i];
            final int n = o.length();

            if (!hashMap.containsKey(n)) {
                hashMap.put(n, new HashMap<>());
            }

            var iHashMap = hashMap.get(n);

            if (!iHashMap.containsKey(o)) {
                iHashMap.put(o, new HashMap<>());
            }

            var oHashMap = iHashMap.get(o);

            if (!oHashMap.containsKey(c) || oHashMap.get(c) > cost[i]) {
                oHashMap.put(c, cost[i]);
            }
        }

        return hashMap;
    }


    private void getHashMap(final int cost) {
        final HashMap<String, HashMap<String, Integer>> iHashMap = hashMap.get(cost);

        for (String key : new HashSet<>(iHashMap.keySet())) {
            final HashMap<String, Integer> thisMap = iHashMap.get(key);
            final HashSet<String> visited = new HashSet<>();
            visited.add(key);

            final PriorityQueue<Map.Entry<String, Integer>> priorityQueue =
                    new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

            thisMap.entrySet().forEach(priorityQueue::offer);

            while (!priorityQueue.isEmpty()) {
                final Map.Entry<String, Integer> entry = priorityQueue.poll();
                final String o = entry.getKey();
                final Integer oCost = entry.getValue();

                if (visited.contains(o)) {
                    continue;
                } else {
                    visited.add(o);
                    thisMap.put(o, oCost);
                }

                if (!iHashMap.containsKey(o)) {
                    continue;
                }

                iHashMap.get(o).forEach((c, v) -> {
                    if (!visited.contains(c) && (!thisMap.containsKey(c) || thisMap.get(c) > v + oCost)) {
                        priorityQueue.offer(new AbstractMap.SimpleImmutableEntry<>(c, v + oCost));
                    }
                });
            }
        }
    }


    int getChangeCost(final String o, final String c) {
        HashMap<String, HashMap<String, Integer>> iHashMap = hashMap.get(o.length());

        if (iHashMap != null && iHashMap.containsKey(o) && iHashMap.get(o).containsKey(c)) {
            return iHashMap.get(o).get(c);
        } else {
            return -1;
        }
    }


    int getMaxLength() {
        OptionalInt maxLength = hashMap.keySet().stream().mapToInt(Integer::intValue).max();

        if (maxLength.isPresent()) {
            return maxLength.getAsInt();
        } else {
            return -1;
        }
    }
}