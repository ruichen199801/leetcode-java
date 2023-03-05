package ruichen;

public class IntegerToRoman {
    // TC = O(n), SC = O(1)
    class Solution {
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
