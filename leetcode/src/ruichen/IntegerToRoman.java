package ruichen;

public class IntegerToRoman {

    // #12 https://leetcode.com/problems/integer-to-roman/
    // Math

    class Solution {

        // Time complexity = O(n), n = number of roman numerals in result
        // The loop over the numerals array does NOT count into total time, for
        // it's fixed size do not grow as our input size grows
        // Space complexity = O(1) for fixed-size numerals array

        private Numeral[] numerals = {
                new Numeral("M", 1000),
                new Numeral("CM", 900),
                new Numeral("D", 500),
                new Numeral("CD", 400),
                new Numeral("C", 100),
                new Numeral("XC", 90),
                new Numeral("L", 50),
                new Numeral("XL", 40),
                new Numeral("X", 10),
                new Numeral("IX", 9),
                new Numeral("V", 5),
                new Numeral("IV", 4),
                new Numeral("I", 1)
        };

        public String intToRoman(int num) {
            // 1 <= num <= 3999
            StringBuilder result = new StringBuilder();
            while (num > 0) {
                for (Numeral numeral : numerals) {
                    int count = num / numeral.value;
                    while (count-- > 0) {
                        result.append(numeral.symbol);
                        num -= numeral.value;
                    }
                }
            }
            return result.toString();
        }

        class Numeral {
            public String symbol;
            public int value;
            public Numeral(String symbol, int value) {
                this.symbol = symbol;
                this.value = value;
            }
        }
    }
}