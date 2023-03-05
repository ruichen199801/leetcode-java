package ruichen;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class PerfectSquares {
    class Solution1 {
        // Method 1: DP: TC = O(n * sqrt(n)), SC = O(n)

        // dp[n] indicates that the perfect squares count of the given n
        // initialize dp[0] = 0
        // dp[1] = dp[1 - 1 * 1] + 1 = dp[0] + 1 = 1
        // dp[2] = dp[2 - 1 * 1] + 1 = dp[1] + 1 = 2
        // dp[3] = dp[3 - 1 * 1] + 1 = dp[2] + 1 = 3
        // dp[4] = min{dp[4 - 1 * 1] + 1, dp[4 - 2 * 2] + 1} = min{dp[3] + 1, dp[0] + 1} = min{4, 1} = 1
        // ... dp[n] is the answer for integer n
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            return dp[n];
        }
    }

    class Solution2 {
        // Method 2: Classic BFS + Greedy: Only look at square numbers
        public int numSquares(int n) {
            Set<Integer> seen = new HashSet<>();
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(n);
            int level = 0;
            while (!queue.isEmpty()) {
                level++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int curNum = queue.poll();
                    seen.add(curNum);
                    for (int j = 1; j * j <= curNum; j++) {
                        int squareNum = j * j;
                        if (curNum == squareNum) {
                            return level;
                        }
                        int nextNum = curNum - squareNum;
                        if (!seen.contains(nextNum)) {
                            queue.offer(nextNum);
                            seen.add(nextNum);
                        }
                    }
                }
            }
            return level;
        }
    }
}
