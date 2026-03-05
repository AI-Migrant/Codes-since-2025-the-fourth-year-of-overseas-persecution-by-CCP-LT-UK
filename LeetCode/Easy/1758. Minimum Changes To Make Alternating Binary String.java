class Solution {
    public int minOperations(String s) {
        return Arrays.stream(s.codePoints().collect(() -> new int[]{ 0, 0 }, (a, c) -> { final int i = a[0]; a[0] = a[1] + Math.abs(48 - c); a[1] = i + Math.abs(49 - c); }, (a, c) -> { a[0] += c[0]; a[1] += c[1]; })).min().getAsInt();
    }
}
