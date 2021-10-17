package ruichen;

public class ToLowerCase {

    // #709 https://leetcode.com/problems/to-lower-case/
    // String
    // TC = O(n), SC = O(n)

    class Solution {
        public String toLowerCase(String s) {
            // ASCII: 'A': 65, 'a': 97
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                // if (arr[i] >= 65 && arr[i] <= 90) {
                //     arr[i] += 32;
                // }
                if (Character.isUpperCase(arr[i])) {
                    arr[i] = (char) (arr[i] + 'a' - 'A');
                }
            }
            return new String(arr);
        }
    }
}
