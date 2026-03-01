class Solution {
    public int minPartitions(String n) {
        return n.codePoints().max().getAsInt()
 - '0';
    }
}
