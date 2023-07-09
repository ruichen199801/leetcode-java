package ruichen;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DesignALeaderboard {
    // addScore(), reset(): TC = O(1)
    // top(): TC = O(n * log k), SC = O(k)
    // hash map: SC = O(n)
    class Leaderboard {
        private Map<Integer, Integer> scores;

        public Leaderboard() {
            scores = new HashMap<>();
        }

        public void addScore(int playerId, int score) {
            scores.put(playerId, scores.getOrDefault(playerId, 0) + score);
        }

        public int top(int K) {
            // Build a minHeap of size k
            PriorityQueue<Integer> minHeap = new PriorityQueue<>((player1, player2) -> scores.get(player1) - scores.get(player2));
            for (Map.Entry<Integer, Integer> entry : scores.entrySet()) {
                minHeap.offer(entry.getKey());
                if (minHeap.size() > K) {
                    minHeap.poll();
                }
            }
            // Sum all the scores remaining in the heap
            int result = 0;
            while (!minHeap.isEmpty()) {
                result += scores.get(minHeap.poll());
            }
            return result;
        }

        public void reset(int playerId) {
            scores.put(playerId, 0);
        }
    }
}
