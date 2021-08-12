package ruichen;

public class ReverseStringII {

    // #541 https://leetcode.com/problems/reverse-string-ii/
    // String, Two Pointers
    // TC = O(n), SC = O(n) to store results

    class Solution {
        public String reverseStr(String s, int k) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i += 2 * k) {
                // start = i
                int end = Math.min(arr.length - 1, i + k - 1);
                reverse(arr, i, end);
            }
            return new String(arr);
        }

        private void reverse(char[] arr, int i, int j) {
            while (i < j) {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
    }
}
