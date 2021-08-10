package ruichen;

public class AddStrings {

    // #415 https://leetcode.com/problems/add-strings/
    // Math, String
    // TC = O(N1 + N2), SC = O(max(N1, N2) + 1)

    class Solution {
        public String addStrings(String num1, String num2) {

            // bit-by-bit/schoolbook addition
            // "11" + "123" = "134"
            // "1" -> 1: "1" - "0"
            //  1  2  3
            //     1  1
            //  -------
            //  1  3  4
            // add from backward, result: 4 3 1 -> reverse

            StringBuilder res = new StringBuilder();
            int p1 = num1.length() - 1, p2 = num2.length() - 1;
            int carry = 0;
            while (p1 >= 0 || p2 >= 0 || carry != 0) {
                int sum = carry;
                if (p1 >= 0) {
                    sum += num1.charAt(p1) - '0';
                    p1--;
                }
                if (p2 >= 0) {
                    sum += num2.charAt(p2) - '0';
                    p2--;
                }
                res.append(sum % 10); // sb.append(E e): pass in any type as a string representation in the stringbuilder
                carry = sum / 10;
            }
            return res.reverse().toString(); // sb to string
        }
    }
}
