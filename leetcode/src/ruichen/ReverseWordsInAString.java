package ruichen;

public class ReverseWordsInAString {
    // TC = O(n), SC = O(n) to store results
    class Solution {
        public String reverseWords(String s) {
            // step 1: trim the input string
            s = removeSpace(s);
            char[] arr = s.toCharArray();
            // step 2: reverse the whole string
            reverse(arr, 0, arr.length - 1);
            // step 3: reverse each word
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

        private String removeSpace(String s) {
            // [0, i - 1]: result, [i, j - 1]: area we do not care about, [j, size - 1]: unknown area to explore
            char[] arr = s.toCharArray();
            int i = 0, j = 0;
            // __xxx___xxx___ -> xxx_xxx
            while (j < arr.length) {
                if (arr[j] == ' ' && (j == 0 || arr[j - 1] == ' ')) {
                    j++;
                    continue;
                }
                arr[i++] = arr[j++];
            }
            // mistakenly copy the first trailing space
            if (i > 0 && arr[i - 1] == ' ') {
                i--;
            }
            return new String(arr, 0, i);
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
