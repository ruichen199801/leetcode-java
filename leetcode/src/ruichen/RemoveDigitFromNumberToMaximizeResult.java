package ruichen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoveDigitFromNumberToMaximizeResult {

    // #2259 https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/
    // String

    class Solution1 {
        // Method 1: Add all possible results to a list, then sort (space is terrible)
        // TC = O(n), SC = O(n^2)
        public String removeDigit(String number, char digit) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) == digit) {
                    res.add(number.substring(0, i) + number.substring(i + 1));
                }
            }
            Collections.sort(res); // 0, 1, 2, A, B, a, b
            return res.get(res.size() - 1);
        }
    }

    class Solution2 {
        // Method 1: Iterate from left (most significant digit), stop when the next digit is greater than current digit
        // TC = O(n), SC = O(n)
        public String removeDigit(String number, char digit) {
            int index = 0;
            int len = number.length();
            for (int i = 0; i < len; i++) {
                if (number.charAt(i) == digit) {
                    index = i;
                    if (i < len - 1 && number.charAt(i) < number.charAt(i + 1)) {
                        break;
                    }
                }
            }
            return number.substring(0, index) + number.substring(index + 1);
        }
    }
}
