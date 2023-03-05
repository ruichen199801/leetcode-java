package ruichen;

public class FirstBadVersion {
    // TC = O(log n), SC = O(1)
    public class Solution {
        public int firstBadVersion(int n) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (isBadVersion(mid + 1)) { // API: n maps to (n + 1)
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left + 1;
        }

        private boolean isBadVersion(int i) { // placeholder
            return true;
        }
    }
}
