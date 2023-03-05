package ruichen;

public class ShortestWordDistance {
    // TC = O(n * m), n = # of words in the input list, m = total length of word1 and word2
    // SC = O(1)
    class Solution {
        public int shortestDistance(String[] wordsDict, String word1, String word2) {
            int index = -1, min = Integer.MAX_VALUE;
            for (int i = 0; i < wordsDict.length; i++) {
                if (wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) {
                    if (index != -1 && !wordsDict[i].equals(wordsDict[index])) {
                        min = Math.min(min, i - index);
                    }
                    index = i;
                }
            }
            return min;
        }
    }
}
