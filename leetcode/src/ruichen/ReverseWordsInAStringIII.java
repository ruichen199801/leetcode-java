package ruichen;

public class ReverseWordsInAStringIII {
    // TC = O(n), SC = O(n) to store results
    class Solution {
        public String reverseWords(String s) {
            char[] arr = s.toCharArray();
            int start = 0;
            for (int i = 0; i < arr.length; i++) {
                // _xxx
                if (arr[i] != ' ' && (i == 0 || arr[i - 1] == ' ')) {
                    start = i;
                }
                // xxx_
                if (arr[i] != ' ' && (i == arr.length - 1 || arr[i + 1] == ' ')) {
                    reverse(arr, start, i);
                }
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
