package ruichen;

public class ThousandSeparator {
    // TC = O(n), SC = O(n)
    // If the cost of converting String to StringBuilder is not counted, TC = O(log n), SC = O(1)
    class Solution {
        public String thousandSeparator(int n) {
            String str = String.valueOf(n);
            if (n < 1000) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str);
            for (int i = str.length() - 3; i > 0; i -= 3) {
                sb.insert(i, '.');
            }
            return sb.toString();
        }
    }
}
