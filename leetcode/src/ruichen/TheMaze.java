package ruichen;

import java.util.ArrayDeque;
import java.util.Queue;

public class TheMaze {
    // TC = O(m * n), SC = O(m * n) (similar to island problem)
    class Solution {
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int m = maze.length, n = maze[0].length;
            boolean[][] visited = new boolean[m][n];
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(start);
            visited[start[0]][start[1]] = true;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                if (cur[0] == destination[0] && cur[1] == destination[1]) {
                    return true;
                }
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    // if not hit wall: continue moving forward
                    while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                        x += dir[0];
                        y += dir[1];
                    }
                    // jump out of while loop: already invalid, so backtrack one move
                    x -= dir[0];
                    y -= dir[1];
                    if (!visited[x][y]) {
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            return false;
        }
    }
}
