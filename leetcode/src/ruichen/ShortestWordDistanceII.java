package ruichen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII {
    // constructor: TC = O(n), n = # of words in the input list
    // find shortest: TC = O(n) worst case
    // SC = O(n) for hash map
    class WordDistance {
        Map<String, List<Integer>> dict;

        public WordDistance(String[] wordsDict) {
            dict = new HashMap<>();
            for (int i = 0; i < wordsDict.length; i++) {
                if (!dict.containsKey(wordsDict[i])) {
                    dict.put(wordsDict[i], new ArrayList<>());
                }
                dict.get(wordsDict[i]).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> index1 = dict.get(word1); // 1, 3, 4
            List<Integer> index2 = dict.get(word2); // 2, 5
            int p1 = 0, p2 = 0;
            int min = Integer.MAX_VALUE;
            while (p1 < index1.size() && p2 < index2.size()) {
                min = Math.min(min, Math.abs(index1.get(p1) - index2.get(p2)));
                if (index1.get(p1) < index2.get(p2)) {
                    p1++;
                } else {
                    p2++;
                }
            }
            return min;
        }
    }
}
