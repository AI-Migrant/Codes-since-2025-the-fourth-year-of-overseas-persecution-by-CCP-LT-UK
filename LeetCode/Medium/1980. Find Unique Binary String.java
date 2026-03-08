// Solution 1
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        return Integer.toBinaryString((1 << nums[0].length()) | Arrays.mismatch(IntStream.range(0, (int)Math.pow(2, nums[0].length())).toArray(), Arrays.stream(nums).mapToInt(s -> Integer.parseInt(s, 2)).sorted().toArray())).substring(1);
    }
}




// Solution 2
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        return String.format("%" + nums[0].length() + "s", IntStream.iterate((int)Math.pow(2, nums[0].length()) - 1, i -> i >= 0, i -> i - 1).collect(() ->Arrays.stream(nums).sorted().collect(Collectors.toCollection(ArrayDeque::new)), (a, c) -> { if(!a.isEmpty() && Integer.parseInt(a.peekLast(), 2) == c) a.pollLast(); else a.offerFirst(Integer.toString(c, 2)); }, (a, c) -> {} ).pollFirst()).replace(" ", "0");
    }
}