package ruichen;

public class MinCostClimbingStairs {
    class Solution1 {
        // Say f[i] is the final cost to climb to the top from step i
        // Bottom-up DP (Tabulation): f[i] = min(f[i-1] + cost[i-1], f[i-2] + cost[i-2])
        // TC = O(n), SC = O(n)
        public int minCostClimbingStairs(int[] cost) {
            int[] minCost = new int[cost.length + 1];
            minCost[0] = 0;
            minCost[1] = 0; // we can directly start from index 1
            for (int i = 2; i <= cost.length; i++) {
                int takeOneStep = minCost[i - 1] + cost[i - 1];
                int takeTwoSteps = minCost[i - 2] + cost[i - 2];
                minCost[i] = Math.min(takeOneStep, takeTwoSteps);
            }
            return minCost[cost.length];
        }
    }

    class Solution2 {
        // f[i] = min(f[i-1] + cost[i-1], f[i-2] + cost[i-2])
        // our recurrence relation only cares about 2 steps below the current step
        // Optimized Bottom-up DP: TC = O(n), SC = O(1)
        public int minCostClimbingStairs(int[] cost) {
            int a = 0;
            int b = 0;
            for (int i = 2; i <= cost.length; i++) {
                int temp = b;
                b = Math.min(a + cost[i - 2], b + cost[i - 1]);
                a = temp;
            }
            return b;
        }
    }
}
