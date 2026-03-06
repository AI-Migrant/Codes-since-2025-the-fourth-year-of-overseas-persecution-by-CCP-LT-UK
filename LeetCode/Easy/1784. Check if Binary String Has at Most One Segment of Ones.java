class Solution {
    public boolean checkOnesSegment(String s) {
        return s.substring(s.indexOf("1"), s.lastIndexOf("1")).codePoints().allMatch(c -> c == 49);
    }
}