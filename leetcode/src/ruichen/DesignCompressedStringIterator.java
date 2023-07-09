package ruichen;

public class DesignCompressedStringIterator {
    // TC = O(1) (for both operations), SC = O(1)
    class StringIterator {
        private String compressedString;
        private int currIndex;
        private char currChar;
        private int count;

        public StringIterator(String compressedString) {
            this.compressedString = compressedString;
            this.currIndex = 0;
            this.currChar = ' ';
            this.count = 0;
        }

        public char next() {
            if (!hasNext()) {
                return ' ';
            }
            if (count == 0) {
                currChar = compressedString.charAt(currIndex++);

                StringBuilder digits = new StringBuilder();
                while (currIndex < compressedString.length() && Character.isDigit(compressedString.charAt(currIndex))) {
                    digits.append(compressedString.charAt(currIndex));
                    currIndex++;
                }
                count = Integer.parseInt(digits.toString());
            }
            count--;
            return currChar;
        }

        public boolean hasNext() {
            return currIndex < compressedString.length() || count > 0;
        }
    }
}
