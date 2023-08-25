package ruichen;

import java.util.Arrays;

public class TwoCityScheduling {
    // TC = O(n log n), SC = O(log n) (sorting)
    class Solution {
        public int twoCitySchedCost(int[][] costs) {
            // Sort by the difference of cost between the two cities for each person
            Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

            int n = costs.length / 2;
            int sum = 0;

            // Send the first n persons to city A and the rest to city B
            for (int i = 0; i < n; i++) {
                sum += costs[i][0] + costs[i + n][1];
            }

            return sum;
        }
    }
}
