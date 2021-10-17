package ruichen;

public class RearrangeSpacesBetweenWords {

    // #1592 https://leetcode.com/problems/rearrange-spaces-between-words/
    // String
    // TC = O(n), SC = O(n)

    class Solution1 {
        // Construct the answer char by char
        public String reorderSpaces(String text) {
            int wordCount = 0, spaceCount = 0;
            char[] arr = text.toCharArray();
            int len = arr.length;
            // traverse text to count number of words and spaces
            for (int i = 0; i < len; i++) {
                if (arr[i] == ' ') {
                    spaceCount++;
                }
                if (arr[i] != ' ' && (i == len - 1 || arr[i + 1] == ' ')) {
                    wordCount++;
                }
            }
            // calculate the space length between words (edge case: text contains only one word)
            int spaceLength = wordCount == 1 ? 0 : spaceCount / (wordCount - 1);
            // modify on arr directly may overwrite original values, therefore maken a copy of arr
            char[] arrCopy = new char[len];
            // slow pointer: store results in arrCopy, fast pointer: traverse arr
            int slow = 0, fast = 0;
            // skip the leading spaces
            while (fast < len && arr[fast] == ' ') {
                fast++;
            }
            // Case 1: if fast points to a word, copy it to arrCopy using slow
            // Case 2: if fast points to a space, copy space to arrCopy for spaceLength times, then move fast to skip spaces and point to the next word
            while (fast < len) {
                if (arr[fast] != ' ') {
                    arrCopy[slow++] = arr[fast++];
                } else {
                    while (fast < len && arr[fast] == ' ') {
                        fast++;
                    }
                    for (int i = 0; slow < len && i < spaceLength; i++) {
                        arrCopy[slow++] = ' ';
                    }
                }
            }
            // pad arrCopy with extra spaces
            while (slow < len) {
                arrCopy[slow++] = ' ';
            }
            return new String(arrCopy);
        }
    }

    class Solution2 {
        // Construct the answer word by word
        public String reorderSpaces(String text) {
            String[] words = text.trim().split("\\s+");
            int wordCount = words.length;
            int spaceCount = 0;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ' ') {
                    spaceCount++;
                }
            }
            int spaceLength = wordCount == 1 ? 0 : spaceCount / (wordCount - 1);
            int extraSpace = wordCount == 1 ? spaceCount : spaceCount % (wordCount - 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < wordCount; i++) {
                sb.append(words[i]);
                int j = 0, limit = i == wordCount - 1 ? extraSpace : spaceLength;
                while (j < limit) {
                    sb.append(' ');
                    j++;
                }
            }
            return sb.toString();
        }
    }
}
