package ruichen;

public class AddBinary {

    // #67 https://leetcode.com/problems/add-binary/
    // Math, String
    // TC = O(N1 + N2), SC = O(max(N1, N2) + 1)

    class Solution {
        public String addBinary(String a, String b) {
            // Same as #415 Add Strings
            StringBuilder res = new StringBuilder();
            int p1 = a.length() - 1, p2 = b.length() - 1;
            int carry = 0;
            while (p1 >= 0 || p2 >= 0 || carry != 0) {
                int sum = carry;
                if (p1 >= 0) {
                    sum += a.charAt(p1) - '0';
                    p1--;
                }
                if (p2 >= 0) {
                    sum += b.charAt(p2) - '0';
                    p2--;
                }
                res.append(sum % 2); // sb.append(E e): pass in any type as a string representation in the stringbuilder
                carry = sum / 2;
            }
            return res.reverse().toString(); // sb to string
        }
    }
}
