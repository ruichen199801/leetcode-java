package ruichen;

public class MaximumNumberOfBalloons {
    // TC = O(m + n), SC = O(26 * 2) = O(1)
    class Solution {
        public int maxNumberOfBalloons(String text) {
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
