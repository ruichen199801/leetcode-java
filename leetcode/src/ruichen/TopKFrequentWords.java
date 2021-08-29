package ruichen;

import java.util.*;

public class TopKFrequentWords {

    // #692 https://leetcode.com/problems/top-k-frequent-words/
    // Hash Table, Heap
    // TC = O(n log k): loop over every word + offer() into pq takes O(log k)
    // SC = O(n): hash map, worst case every word is unique
    // refer to #347 Top K Frequent Elements for the quick select solution

    class Solution {
        public List<String> topKFrequent(String[] words, int k) {

            // priority queue solution:
            // step 1: use a hash map to record { word : freq }
            // step 2: build a min heap of size k and rewrite its comparator
            // step 3: pop into result array in reversed order

            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            PriorityQueue<String> minHeap = new PriorityQueue<>(new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    // less frequency or greater alphabetical order comes first
                    if (map.get(s1) == map.get(s2)) {
                        return s2.compareTo(s1); // reverse the default alphabetical order
                    }
                    return map.get(s1) - map.get(s2);
                }
            });
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                minHeap.offer(entry.getKey());
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
            List<String> result = new ArrayList<>();
            while (k > 0) {
                result.add(minHeap.poll());
                k--;
            }
            Collections.reverse(result);
            return result;
        }
    }
}
