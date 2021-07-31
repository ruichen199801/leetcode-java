package ruichen;

public class FirstBadVersion {

    // #278 https://leetcode.com/problems/first-bad-version/
    // Binary Search
    // TC = O(log n), SC = O(1)

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    public class Solution {
        public int firstBadVersion(int n) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (isBadVersion(mid + 1) == true) { // API: n maps to (n + 1)
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left + 1;
        }

        private boolean isBadVersion(int i) {
            return true; // to play around IntelliJ's syntax check
        }
    }
}
