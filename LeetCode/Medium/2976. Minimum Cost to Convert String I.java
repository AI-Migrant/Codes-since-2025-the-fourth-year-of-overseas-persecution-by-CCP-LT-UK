import java.util.*;
import java.util.AbstractMap.*;


class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long answer = 0L;
        final char[] s = source.toCharArray();
        final char[] t = target.toCharArray();
        final int N = s.length;
        final CharExchanger charExchanger = new CharExchanger(original, changed, cost);

        for (int i = 0; i < N; i++) {
            if (s[i] == t[i]) {
                continue;
            } else {
                final int changeCost = charExchanger.getChangeCost(s[i], t[i]);

                if (changeCost == -1) {
                    return -1;
                } else {
                    answer += changeCost;
                }
            }
        }

        return answer;
    }
}


class CharExchanger {
    private final HashMap<Character, HashMap<Character, Integer>> hashMap;


    CharExchanger(final char[] original, final char[] changed, final int[] cost) {
        this.hashMap = getHashMap(original, changed, cost);
    }


    private HashMap<Character, HashMap<Character, Integer>>
    getHashMap(final char[] original, final char[] changed, final int[] cost) {
        HashMap<Character, HashMap<Character, Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < cost.length; i++) {
            final char o = original[i];
            final char c = changed[i];

            if (!hashMap.containsKey(o)) {
                hashMap.put(o, new HashMap<>());
            }

            if (!hashMap.get(o).containsKey(c) || hashMap.get(o).get(c) > cost[i]) {
                hashMap.get(o).put(c, cost[i]);
            }
        }

        for (Character key : new HashSet<>(hashMap.keySet())) {
            final HashMap<Character, Integer> thisMap = hashMap.get(key);
            final HashSet<Character> visited = new HashSet<>();
            visited.add(key);

            final PriorityQueue<SimpleImmutableEntry<Character, Integer>> priorityQueue =
                    new PriorityQueue<>(Comparator.comparingInt(SimpleImmutableEntry::getValue));

            thisMap.entrySet().forEach(e -> priorityQueue.offer(new SimpleImmutableEntry<>(e)));

            while (!priorityQueue.isEmpty()) {
                final SimpleImmutableEntry<Character, Integer> entry = priorityQueue.poll();
                final Character o = entry.getKey();
                final Integer oCost = entry.getValue();

                if (visited.contains(o) || (thisMap.containsKey(o) && thisMap.get(o) < oCost)) {
                    continue;
                } else {
                    visited.add(o);
                    thisMap.put(o, oCost);
                }

                if (!hashMap.containsKey(o)) {
                    continue;
                }

                hashMap.get(o).entrySet().forEach(e -> {
                    final Character c = e.getKey();
                    final Integer cCost = e.getValue() + oCost;
                    priorityQueue.offer(new SimpleImmutableEntry<>(c, cCost));
                });
            }
        }

        return hashMap;
    }


    int getChangeCost(final char o, final char c) {
        if (hashMap.containsKey(o) && hashMap.get(o).containsKey(c)) {
            return hashMap.get(o).get(c);
        } else {
            return -1;
        }
    }
}