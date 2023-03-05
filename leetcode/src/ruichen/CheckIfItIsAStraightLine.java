package ruichen;

public class CheckIfItIsAStraightLine {
    // TC = O(n), SC = O(1)
    class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            if (coordinates.length <= 2) {
                return true;
            }
            int x0 = coordinates[0][0], y0 = coordinates[0][1];
            int x1 = coordinates[1][0], y1 = coordinates[1][1];
            int dx = x1 - x0, dy = y1 - y0;
            for (int[] coord : coordinates) {
                int x = coord[0], y = coord[1];
                // check slope: use multiplication form to avoid being divided by 0
                if (dx * (y - y0) != dy * (x - x0)) {
                    return false;
                }
            }
            return true;
        }
    }
}
