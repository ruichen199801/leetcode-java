package ruichen;

import java.util.Arrays;

public class ReorderDataInLogFiles {

    // #937 https://leetcode.com/problems/reorder-data-in-log-files/
    // Array, Sorting

    class Solution {
        public String[] reorderLogFiles(String[] logs) {

            // Rules:
            // letter "id a b c d"
            // digit "id 1 2 3 4"
            // letter vs letter: sort by logs[1] -> logs[0]
            // letter vs digit: letter comes before digit
            // digit vs digit: do nothing

            // TC = O(n log n)
            // Arrays.sort(): dual-pivot quick sort for primitive types, modified merge sort for object[] types that demand stability
            // SC = O(log n) in average, O(n) worst case

            Arrays.sort(logs, (log1, log2) -> {
                // log1 < log2: return -1
                // log1 == log2:        0
                // log1 > log2:         1
                int index1 = log1.indexOf(" "); // "id | xxxxxx" delimited by empty space
                String id1 = log1.substring(0, index1);
                String main1 = log1.substring(index1 + 1);

                int index2 = log2.indexOf(" ");
                String id2 = log2.substring(0, index2);
                String main2 = log2.substring(index2 + 1);

                boolean isDigit1 = Character.isDigit(main1.charAt(0));
                boolean isDigit2 = Character.isDigit(main2.charAt(0));

                if (!isDigit1 && !isDigit2) { // letter vs letter
                    return main1.compareTo(main2) == 0 ? id1.compareTo(id2) : main1.compareTo(main2);
                } else if (!isDigit1) {
                    return -1; // log1 letter vs log2 digit
                } else if (!isDigit2) {
                    return 1; // log1 digit vs log2 letter
                } else {
                    return 0; // digit vs digit
                }
            });
            return logs;
        }
    }
}
