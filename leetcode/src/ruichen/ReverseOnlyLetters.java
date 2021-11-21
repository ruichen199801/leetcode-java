package ruichen;

public class ReverseOnlyLetters {

    // #917 https://leetcode.com/problems/reverse-only-letters/
    // String, Two Pointers
    // TC = O(n), SC = O(n)

    class Solution {
        public String reverseOnlyLetters(String s) {
            char[] arr = s.toCharArray();
            int i = 0, j = arr.length - 1;
            while (i < j) {
                if (!Character.isAlphabetic(arr[i])) {
                    i++;
                    continue;
                } else if (!Character.isAlphabetic(arr[j])) {
                    j--;
                    continue;
                } else {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                }
            }
            return new String(arr);
        }
    }
}
