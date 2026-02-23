import java.util.stream.*;


class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        return IntStream.concat(Arrays.stream(a).distinct(), Arrays.stream(b).distinct()).distinct().boxed().collect(Collectors.toCollection(ArrayList::new));
    }
}