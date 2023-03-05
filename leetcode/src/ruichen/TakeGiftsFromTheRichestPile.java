package ruichen;

import java.util.PriorityQueue;

public class TakeGiftsFromTheRichestPile {
    class Solution1 {
        // TC = O(kn), SC = O(1)
        public long pickGifts(int[] gifts, int k) {
            while (k-- > 0) {
                int maxIdx = findMax(gifts);
                int maxNum = gifts[maxIdx];
                maxNum = (int) Math.sqrt(maxNum);
                gifts[maxIdx] = maxNum;
            }
            long sum = 0;
            for (int gift : gifts) {
                sum += gift;
            }
            return sum;
        }

        private int findMax(int[] arr) {
            int maxIdx = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > arr[maxIdx]) {
                    maxIdx = i;
                }
            }
            return maxIdx;
        }
    }

    class Solution2 {
        // TC = O(k log n + n log n), SC = O(n)
        public long pickGifts(int[] gifts, int k) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a1, a2) -> a2 - a1);
            for (int gift : gifts) { // O(n * log n)
                maxHeap.offer(gift);
            }
            while (k-- > 0) { // O(k * log n)
                int maxNum = maxHeap.poll();
                maxNum = (int) Math.sqrt(maxNum);
                maxHeap.offer(maxNum);
            }
            long sum = 0;
            while (!maxHeap.isEmpty()) { // Sum up modified array, not original array: O(n * log n)
                sum += maxHeap.poll();
            }
            return sum;
        }
    }
}
