package ruichen;

import java.util.*;

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
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer i1, Integer i2) { // not "int"!
                    int freq1 = map.get(i1), freq2 = map.get(i2);
                    if (freq1 == freq2) {
                        return 0;
                    }
                    return freq1 - freq2;
                }
            });
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
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int[] arr = new int[map.size()];
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                arr[i++] = entry.getKey();
            }
            quickSelect(arr, 0, arr.length - 1, k - 1, map);
            return Arrays.copyOf(arr, k); // return in any order
        }

        private void quickSelect(int[] arr, int left, int right, int target, Map<Integer, Integer> map) {
            if (left == right) {
                return;
            }
            int p = partition(arr, left, right, map);
            if (p == target) {
                return;
            } else if (p > target) {
                quickSelect(arr, left, p - 1, target, map);
            } else {
                quickSelect(arr, p + 1, right, target, map);
            }
        }

        private int partition(int[] arr, int left, int right, Map<Integer, Integer> map) {
            int pivot = arr[right];
            int i = left;
            int j = right - 1;
            // sort in decreasing order (we want k biggest)
            while (i <= j) {
                if (map.get(arr[i]) > map.get(pivot)) {
                    i++;
                } else if (map.get(arr[j]) <= map.get(pivot)) {
                    j--;
                } else {
                    swap(arr, i++, j--);
                }
            }
            swap(arr, i, right);
            return i;
        }

        private void swap(int[] arr, int a, int b) {
            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }
    }
}
