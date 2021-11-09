package ruichen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    // #17 https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    // Depth-first Search
    // TC = O(n * 4^n), 4^n: worst case, digits only contain 7s and 9s; n: cost to build the combination each run
    // SC = O(n), n = number of digits (= depth of recursion stack)

    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if (digits == null || digits.length() == 0) {
                return result;
            }
            StringBuilder cur = new StringBuilder();
            Map<Character, String> map = new HashMap<>();
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jhl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
//            Java 9 new feature:
//            Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi",
//                                                '5', "jkl", '6', "mno", '7', "pqrs",
//                                                '8', "tuv", '9', "wxyz");
            dfs(0, digits, map, cur, result);
            return result;
        }

        private void dfs(int index, String digits, Map<Character, String> map,
                         StringBuilder cur, List<String> result) {
            if (index == digits.length()) {
                result.add(new String(cur));
                return;
            }
            String letters = map.get(digits.charAt(index)); // "abc"
            for (char letter : letters.toCharArray()) {
                cur.append(letter);
                dfs(index + 1, digits, map, cur, result);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}
