package ruichen;

public class ExcelSheetColumnNumber {
    // TC = O(n), SC = O(1)
    class Solution {
        public int titleToNumber(String columnTitle) {
            int res = 0;
            for (char ch : columnTitle.toCharArray()) {
                res = res * 26 + ch - 'A' + 1; // 26-nary representation
            }
            return res;
        }
    }
}
