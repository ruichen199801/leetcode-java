package ruichen;

public class FindTheDifference {

    // #389 https://leetcode.com/problems/find-the-difference/
    // Bit Manipulation, Hash Table
    // TC = O(n), SC = O(1)

    class Solution1 {
        public char findTheDifference(String s, String t) {
            // Maintain an array to record count of 26 letters, SC = O(26) = O(1)
            int[] table = new int[26]; // 0 - 25: 'a' - 'z'
            char[] s1 = s.toCharArray();
            char[] t1 = t.toCharArray();
            for (char ch: s1) {
                table[ch - 'a']++;
            }
            for (char ch: t1) {
                table[ch - 'a']--;
                if (table[ch - 'a'] == -1) {
                    return ch;
                }
            }
            return ' ';
        }
    }

    class Solution2 {
        public char findTheDifference(String s, String t) {
            // The difference of the ASCII sum of s and t is the answer
            int sum1 = 0, sum2 = 0;
            for (char ch: s.toCharArray()) {
                sum1 += ch;
            }
            for (char ch: t.toCharArray()) {
                sum2 += ch;
            }
            return (char)(sum2 - sum1);
        }
    }

    class Solution3 {
        public char findTheDifference(String s, String t) {
            // XOR twice, same as #136 single number
            int xor = 0;
            for (char ch: s.toCharArray()) {
                xor ^= ch; // 0 ^= ch = ch itself
            }
            for (char ch: t.toCharArray()) {
                xor ^= ch;
            }
            return (char)xor;
        }
    }
}
