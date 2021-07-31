package ruichen;

public class ExcelSheetColumnTitle {

    class Solution {

        // #168 https://leetcode.com/problems/excel-sheet-column-title/
        // Math
        // TC = O(log n), SC = O(1)

        public String convertToTitle(int columnNumber) {
            // 701 -> ZY
            // 700 % 26 + 65 = 89 -> Y, n = 700 / 26 = 26, Y
            // 25 % 26 + 65 = 90 -> Z, n = 25 / 26 = 0, ZY
            String res = "";
            while (columnNumber > 0) {
                columnNumber--;
                res = (char)(columnNumber % 26 + 'A') + res; // concatenate
                columnNumber /= 26;
            }
            return res;
        }
    }
}
