package ruichen;

public class MultiplyStrings {

    // #43 https://leetcode.com/problems/multiply-strings/
    // Math, String
    // TC = O(m * n), SC = O(m + n) (term depends on max(m, n))

    class Solution {

        public String multiply(String num1, String num2) {

            //     1 2 3     <- index i
            //       4 5     <- index j
            //   ---------
            //       1 5
            //     1 0
            //   0 5
            //     1 2
            //   0 8
            // 0 4
            // ------------
            // 0 1 2 3 4 index of result
            //    <- l r
            // add position: [l, r] -> [i+j, i+j+1]

            int m = num1.length(), n = num2.length();
            int[] pos = new int[m + n];
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int mult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    int l = i + j, r = i + j + 1;
                    int sum = mult + pos[r];
                    pos[r] = sum % 10;
                    pos[l] += sum / 10;
                }
            }
            StringBuilder result = new StringBuilder();
            for (int p : pos) {
                if (result.length() == 0 && p == 0) { // play around the case: 2 * 3 = 6, result = "06"
                    continue;
                }
                result.append(p);
            }
            return result.length() == 0 ? "0" : result.toString(); // 0 * 0 = 0
        }
    }
}
