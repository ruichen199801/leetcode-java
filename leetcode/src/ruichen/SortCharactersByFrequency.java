package ruichen;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    // TC = O(n log n), SC = O(n)
    class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> freqMap = new HashMap<>();

            // count the frequency of each character
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }

            PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));

            // maxHeap.addAll(freqMap.keySet());
            for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
                maxHeap.offer(entry.getKey());
            }

            StringBuilder sb = new StringBuilder();
            while (!maxHeap.isEmpty()) {
                char c = maxHeap.poll();

                // append the character 'frequency' times to the sorted string
                for (int i = 0; i < freqMap.get(c); i++) {
                    sb.append(c);
                }
            }

            return sb.toString();
        }
    }
}
