class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        final TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int num : nums) {
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        }

        int x = treeMap.firstKey();
        int f = treeMap.get(x);
        int y = -1;

        for (var entry : treeMap.entrySet()) {
            if (!entry.getValue().equals(f)) {
                y = entry.getKey();

                break;
            }
        }

        if (y == -1) {
            return new int[] { -1, -1 };
        } else {
            return new int[] { x, y };
        }
    }
}