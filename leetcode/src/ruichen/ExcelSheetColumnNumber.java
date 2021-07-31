package ruichen;

public class ExcelSheetColumnNumber {

    class Solution {

        // #171 https://leetcode-cn.com/problems/excel-sheet-column-number/
        // Math
        // TC = O(n), SC = O(1)

        public int titleToNumber(String columnTitle) {
            // 26-nary representation
            int res = 0;
            for (char ch: columnTitle.toCharArray()) {
                res = res * 26 + ch - 'A' + 1;
            }
            return res;
        }
    }
}
