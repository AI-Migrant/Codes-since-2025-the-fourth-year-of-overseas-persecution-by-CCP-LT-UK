import java.util.*;


public class Solution 
{
    public static int findDoubleStrings(String str) 
    {
        final HashMap<Character, ArrayList<Integer>> hashMap = new HashMap<>();
        final char[] arr = str.toCharArray();
        final int n = arr.length;
        final HashSet<String> answerSet = new HashSet<>();

        for (int i = 0; i < n; i ++) {
            if (!hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], new ArrayList<>());
            }

            hashMap.get(arr[i]).add(i);
        }

        for (final var a : hashMap.values()) {
            for (int i = 0; i < a.size(); i++) {
                final int p = a.get(i);



                for (int j = i + 1; j < a.size(); j++) {
                    final int q = a.get(j);

                    if (q + q - p > n) {
                        break;
                    }
                    final String s1 = str.substring(p, q);

                    if (s1.equals(str.substring(q, q + q - p))) {
                        answerSet.add(s1);
                    }
                }
            }
        }

        return answerSet.size();
    }
}