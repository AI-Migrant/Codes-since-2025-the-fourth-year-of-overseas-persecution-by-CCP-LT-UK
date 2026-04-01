class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        final int n = healths.length;
        final Integer[] indice = new Integer[n];
        final ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        final ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            indice[i] = i;
        }

        Arrays.sort(indice, (x, y) -> positions[x] - positions[y]);

        for (final Integer index : indice) {
            final int i = index;

            if (directions.charAt(i) == 'R') {
                arrayDeque.offerLast(index);

                continue;
            }

            while (!arrayDeque.isEmpty()) {
                final int j = arrayDeque.pollLast();

                if (healths[i] > healths[j]) {
                    healths[j] = 0;
                    healths[i]--;
                } else {
                    if (healths[i] < healths[j]) {
                        healths[j]--;
                        arrayDeque.offerLast(j);
                    } else {
                        healths[j] = 0;
                    }

                    healths[i] = 0;

                    break;
                }
            }
        }

        for (final int health : healths) {
            if (health > 0) {
                answer.add(health);
            }
        }

        return answer;
    }
}
