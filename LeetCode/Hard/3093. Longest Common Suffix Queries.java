class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie trie = new Trie();
        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsContainer.length; i++) {
            trie.add(wordsContainer[i], i);
        }

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = trie.find(wordsQuery[i]);
        }

        return ans;
    }
}


class Trie {
    HashMap<Character, Trie> children;
    TreeMap<Integer, TreeSet<Integer>> lengths;


    Trie() {
        children = new HashMap<>();
        lengths = new TreeMap<>();
    }


    void add(String word, int idx) {
        add(word.toCharArray(), word.length() - 1, idx);
    }


    void add(char[] word, int i, int idx) {
        lengths.computeIfAbsent(word.length, x -> new TreeSet<>()).add(idx);

        if (i < 0) {
            return;
        }

        Character c = word[i];
        children.computeIfAbsent(c, x -> new Trie()).add(word, i - 1, idx);
    }


    int find(String word) {
        return find(word.toCharArray(), word.length() - 1);
    }


    int find(char[] word, int i) {
        if (i < 0 || !children.containsKey(word[i])) {
            return lengths.firstEntry().getValue().first();
        } else {
            return children.get(word[i]).find(word, i - 1);
        }
    }
}