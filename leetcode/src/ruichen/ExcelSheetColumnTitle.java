package ruichen;

public class ExcelSheetColumnTitle {
    // 701 -> ZY
    // 700 % 26 + 65 = 89 -> Y, n = 700 / 26 = 26, Y
    // 25 % 26 + 65 = 90 -> Z, n = 25 / 26 = 0, ZY

    // TC = O(log n), SC = O(1)
    class Solution {
        public String convertToTitle(int columnNumber) {
            String res = "";
            while (columnNumber > 0) {
                columnNumber--;
                res = (char) (columnNumber % 26 + 'A') + res; // concatenate
                columnNumber /= 26;
            }
            return res;
        }
    }
}
