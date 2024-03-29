package ruichen;

public class UniqueBinarySearchTrees {
    // Cut rope
    // G(n): num of BSTs at n
    // F(i, n): nums of BSTs at n, with i as root node (actually "j" in this implementation)
    // G(n) = SUM(F(i, n)), F(i, n) = G(i - 1) * G(n - i)
    // Mathematically count is the same, but each count does not represent exactly what the BST looks like

    // TC = O(n^2), SC = O(n)
    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }
    }
}
