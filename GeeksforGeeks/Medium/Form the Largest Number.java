import java.util.stream.*;


class Solution {
    public String findLargest(int[] arr) {
        return Arrays.stream(arr).mapToObj(Integer::toString).sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
                .collect(Collectors.joining()).replaceFirst("^0+(?!$)", "");
    }
}