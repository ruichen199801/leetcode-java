package ruichen;

import java.util.*;

public class WordLadder {

    // #127 https://leetcode.com/problems/word-ladder/
    // Breadth-first Search

    class Solution {

        // BFS
        // Time complexity = O(N * (M + M^2)) = O(N * M^2), where M = size of dequeued word, N = size of word list
        // Space complexity = O(N * M)

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
                    String word = queue.poll(); // "be"
                    if (word.equals(endWord)) { // use .equals() method to compare strings O(M)
                        return changes;
                        // like a "treasure hunt competition", whoever finds the path to treasure first
                        // returns it immediately (making it automatically the "shortest" path),
                        // that's why we won't need any logic like a Math.min function.
                    }
                    for (int j = 0; j < word.length(); j++) {  // "b", "e"   O(M)
                        for (int k = 'a'; k <= 'z'; k++) {     // "a" - "z"  O(26) = O(1)
                            char[] arr = word.toCharArray();
                            arr[j] = (char) k;
                            String str = new String(arr);  // O(M)
                            // can't write word = new String(arr);
                            // Strings are immutable. Once you have created a string you cannot later change that string object.
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

// start = be
// end = ko
// words = ["ce", "mo", "ko", "me", "co"]
// queue = ["be"]
// changes = 1
// visited = ["be"]

// step 1: initialize, put "be" into queue and visited
// step 2: poll "be": for "b": change it to "a" - "z"
//                       if (in words && not visited) put "xe" into queue and visited
//                    for "e": change it to "a" - "z"
//                       if (in words && not visited) put "bx" into queue and visited
// step 3: poll "ce": repeat ...
// step ...
// step x: all elements in queue has been looped: changes++
// step ...
// step y: if (queue is empty || word == endWord) return changes

// Set -> List: List<Integer> list = new ArrayList<>(set);
// List -> Set: Set<Integer> set = new HashSet<>(list);
// offer into queue: initialize / ready for processing next round
// poll from queue: process this polled element immediately
}
