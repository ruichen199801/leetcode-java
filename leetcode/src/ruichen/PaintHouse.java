package ruichen;

public class PaintHouse {
    // TC = O(n), SC = O(1) (if we are allowed to modify costs matrix)
    class Solution {
        public int minCost(int[][] costs) {
            int len = costs.length;
            for (int i = 1; i < len; i++) {
                costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]); // red
                costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]); // green
                costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]); // blue
            }
            return Math.min(Math.min(costs[len - 1][0], costs[len - 1][1]), costs[len - 1][2]);
        }
    }
}
