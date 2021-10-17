package ruichen;

public class MaximumNumberOfBalloons {

    class Solution {

        // #1189 https://leetcode.com/problems/maximum-number-of-balloons/
        // Hash Table, String, Counting
        // TC = O(m + n), SC = O(26 * 2) = O(1)

        public int maxNumberOfBalloons(String text) {
            // pattern and text consist of lower case English letters only.
            String pattern = "balloon";
            return maxNumberOfPattern(pattern, text);
        }

        private int maxNumberOfPattern(String pattern, String text) {
            int[] freqInPattern = new int[26];
            int[] freqInText = new int[26];
            int m = pattern.length(), n = text.length();
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                freqInPattern[pattern.charAt(i) - 'a']++;
            }
            for (int i = 0; i < n; i++) {
                freqInText[text.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (freqInPattern[i] > 0) {
                    int freq = freqInText[i] / freqInPattern[i];
                    res = Math.min(res, freq);
                }
            }
            return res;
        }
    }
}
