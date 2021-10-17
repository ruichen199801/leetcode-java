package ruichen;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class PerfectSquares {

    // #279 https://leetcode.com/problems/perfect-squares/
    // Breadth-first Search
    // Classic BFS + Greedy: Only look at square numbers (tricky TC & SC)

    class Solution {
        public int numSquares(int n) {
            Set<Integer> seen = new HashSet<>();
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(n);
            int level = 0;
            while(!queue.isEmpty()) {
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
