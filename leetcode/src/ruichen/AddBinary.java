package ruichen;

public class AddBinary {
    // Same as #415
    // TC = O(N1 + N2), SC = O(max(N1, N2) + 1)
    class Solution {
        public String addBinary(String a, String b) {
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
                res.append(sum % 2);
                carry = sum / 2;
            }
            return res.reverse().toString();
        }
    }
}
