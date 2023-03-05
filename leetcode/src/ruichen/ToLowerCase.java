package ruichen;

public class ToLowerCase {
    // TC = O(n), SC = O(n)
    class Solution {
        public String toLowerCase(String s) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (Character.isUpperCase(arr[i])) {
                    arr[i] = (char) (arr[i] + 'a' - 'A');
                }
            }
            return new String(arr);
        }
    }
}
