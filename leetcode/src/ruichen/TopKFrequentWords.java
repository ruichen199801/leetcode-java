package ruichen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    // priority queue solution:
    // step 1: use a hash map to record { word : freq }
    // step 2: build a min heap of size k and rewrite its comparator
    // step 3: pop into result array in reversed order

    // TC = O(n log k): loop over every word + offer() into pq takes O(log k)
    // SC = O(n): hash map, worst case every word is unique

    // refer to #347 Top K Frequent Elements for the quick select solution
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            PriorityQueue<String> minHeap = new PriorityQueue<>((s1, s2) -> {
                int freq1 = map.get(s1), freq2 = map.get(s2);
                if (freq1 == freq2) {
                    return s2.compareTo(s1); // since we'll reverse output, we reverse the lexicographical order here
                } else {
                    return freq1 - freq2;
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
