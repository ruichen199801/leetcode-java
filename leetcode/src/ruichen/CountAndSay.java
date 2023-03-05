package ruichen;

public class CountAndSay {
    // Recursion + Memo
    // TC = O(l ^ (n-1)), l = average length of the digit string
    // SC = O(l), l = maximum length of the digit string (only record previous one)
    class Solution {
        public String countAndSay(int n) {
            if (n == 1) {
                return "1";
            }
            String s = countAndSay(n - 1);
            StringBuilder res = new StringBuilder();
            return helper(s, res);
        }

        // process the digit string segment by segment
        // 1 1 2 2 2 1 1 1 1
        // s   i

        // 1 1 2 2 2 1 1 1 1
        //     s     i

        // 1 1 2 2 2 1 1 1 1
        //           s     i
        private String helper(String s, StringBuilder res) {
            int start = 0;
            char[] array = s.toCharArray();
            for (int i = 1; i < array.length; i++) {
                if (array[start] != array[i]) {
                    res.append(i - start); // number
                    res.append(array[start]); // digit
                    start = i;
                }
            }
            // process the last segment
            res.append(array.length - start);
            res.append(array[start]);
            return res.toString();
        }
    }
}
