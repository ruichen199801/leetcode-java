package ruichen;

public class ReverseString {

    // #344 https://leetcode.com/problems/reverse-string/
    // String, Two Pointers
    // iterative: TC = O(n), SC = O(1)

    class Solution {
        public void reverseString(char[] s) {
            int i = 0, j = s.length - 1;
            while (i < j) {
                char tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
                i++;
                j--;
            }
        }
    }
}
