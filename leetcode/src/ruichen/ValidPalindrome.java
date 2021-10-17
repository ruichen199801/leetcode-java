package ruichen;

public class ValidPalindrome {

    // #125 https://leetcode.com/problems/valid-palindrome/
    // String, Two Pointers

    class Solution1 {
        // Method 1: Compare with reverse
        // Pretreatment: Only look at letters or numbers, convert to lower case
        // TC = O(n), SC = O(n)
        public boolean isPalindrome(String s) {
            StringBuilder sb = new StringBuilder();
            for (char ch : s.toCharArray()) {
                if (Character.isLetterOrDigit(ch)) {
                    sb.append(Character.toLowerCase(ch));
                }
            }
            String original = sb.toString();
            String reversed = sb.reverse().toString();
            return original.equals(reversed); // compare string: .equals(), compare char: ==
        }
    }

    class Solution2 {
        // Method 2: Two pointers
        // TC = O(n), SC = O(1)
        public boolean isPalindrome(String s) {
            for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
                while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                    i++;
                }
                while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                    j--;
                }
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }
            }
            return true;
        }
    }
}
