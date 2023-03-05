package ruichen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    // #347 https://leetcode.com/problems/top-k-frequent-elements/
    // Hash Table, Heap, Quick Select

    class Solution1 {
        // Method 1: Priority Queue
        // TC = O(n log k), SC = O(n)
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) ->  map.get(a) - map.get(b));
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                minHeap.offer(entry.getKey());
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
            int[] result = new int[k];
            for (int i = k - 1; i >= 0; i--) {
                result[i] = minHeap.poll();
            }
            return result;
        }
    }

    class Solution2 {
        // Method 2: Quick Select
        // TC = O(n) in average, O(n^2) at worst (we only care about top k half instead of processing both parts of the array, so O(n) not O(n log n))
        // SC = O(n)
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int num : nums) {
                if (!freqMap.containsKey(num)) {
                    freqMap.put(num, 0);
                }
                freqMap.put(num, freqMap.get(num) + 1);
            }

            int[] arr = new int[freqMap.size()];
            int index = 0;
            for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
                arr[index++] = entry.getKey();
            }

            quickSelect(arr, 0, arr.length - 1, k, freqMap);
            return Arrays.copyOf(arr, k);
        }

        private void quickSelect(int[] arr, int left, int right, int k, Map<Integer, Integer> freqMap) {
            if (left >= right) {
                return;
            }

            int pivotIndex = partition(arr, left, right, freqMap);
            int numLarger = pivotIndex - left + 1;

            if (numLarger == k) {
                return;
            } else if (numLarger > k) {
                quickSelect(arr, left, pivotIndex - 1, k, freqMap);
            } else {
                quickSelect(arr, pivotIndex + 1, right, k - numLarger, freqMap);
            }
        }

        private int partition(int[] arr, int left, int right, Map<Integer, Integer> freqMap) {
            int pivot = arr[right];
            int i = left;

            for (int j = i; j < right; j++) {
                if (freqMap.get(arr[j]) >= freqMap.get(pivot)) { // sort in decreasing order (we want k biggest)
                    swap(arr, i, j);
                    i++;
                }
            }

            swap(arr, i, right);
            return i;
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
