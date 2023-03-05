package ruichen;

import java.util.*;

public class WordLadder {
    // BFS
    // TC = O(N * (M + M^2)) = O(N * M^2), where M = size of dequeued word, N = size of word list
    // SC = O(N * M)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> words = new HashSet<>(wordList); // convert list to map for O(1) lookup
            if (!words.contains(endWord)) {
                return 0;
            }

            int changes = 1;
            Queue<String> queue = new ArrayDeque<>();
            Set<String> visited = new HashSet<>();
            queue.offer(beginWord);
            visited.add(beginWord);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) { // O(N)
                    String word = queue.poll();
                    if (word.equals(endWord)) {
                        return changes;
                    }

                    for (int j = 0; j < word.length(); j++) {  // O(M)
                        for (int k = 'a'; k <= 'z'; k++) {     // O(26) = O(1)
                            char[] arr = word.toCharArray();
                            arr[j] = (char) k;
                            String str = new String(arr);  // O(M)

                            if (words.contains(str) && !visited.contains(str)) {
                                queue.offer(str);
                                visited.add(str);
                            }
                        }
                    }
                }
                changes++;
            }
            return 0;
        }
    }
}
