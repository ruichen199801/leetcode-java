package ruichen;

public class FindInMountainArray {

    /**
     * // This is MountainArray's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface MountainArray {
     *     public int get(int index) {}
     *     public int length() {}
     * }
     */

    class Solution {

        // #1095 https://leetcode.com/problems/find-in-mountain-array/
        // Array, Binary Search
        // TC = O(log n), SC = O(1)

        public int findInMountainArray(int target, MountainArray mountainArr) {
            // 1 2 3 4  5  4 3 2 1
            //   bs1   peak   bs2

            // find the peak
            int n = mountainArr.length();
            int l = 0, r = n - 1, p = 0;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            p = l;

            // run binary search in the left half
            // 1 2 3 4
            l = 0;
            r = p;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (mountainArr.get(mid) == target) {
                    return mid;
                } else if (mountainArr.get(mid) < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            // run binary search in the right half
            // 4 3 2 1
            l = p + 1;
            r = n - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (mountainArr.get(mid) == target) {
                    return mid;
                } else if (mountainArr.get(mid) < target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            return -1;

        }
    }

    class MountainArray {     // to avoid IntelliJ's syntax check :(
        public int length() {
            return 0;
        }
        public int get (int index) {
            return 0;
        }
    }
}
