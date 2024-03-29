package ruichen;

public class ReverseVowelsOfAString {
    // TC = O(n), SC: this should be an in-place operation, but the toCharArray() and new String() method costs O(n)
    class Solution {
        public String reverseVowels(String s) {
            if (s == null || s.length() <= 1) {
                return s;
            }
            char[] arr = s.toCharArray();
            int i = 0, j = arr.length - 1;
            while (i < j) {
                if (isVowel(arr, i) && isVowel(arr, j)) {
                    swap(arr, i++, j--);
                } else if (isVowel(arr, i)) {
                    j--;
                } else if (isVowel(arr, j)) {
                    i++;
                } else {
                    i++;
                    j--;
                }
            }
            return new String(arr);
        }

        private boolean isVowel(char[] arr, int i) {
            char ch = Character.toLowerCase(arr[i]);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return true;
            }
            return false;
        }

        private void swap(char[] arr, int i, int j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
