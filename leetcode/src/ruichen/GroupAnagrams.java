package ruichen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    class Solution1 {
        // Method 1: Categorize by Sorted String
        // TC = O(n * k log k), SC = O(n * k), n = strs[] length, k = string length
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) {
                return new ArrayList<>();
            }
            // store <sorted anagram, actual corresponding anagrams> in hash map
            Map<String, List<String>> anagrams = new HashMap<>();
            for (String str : strs) {
                char[] arr = str.toCharArray();
                Arrays.sort(arr);
                String sortedStr = new String(arr);
                if (!anagrams.containsKey(sortedStr)) {
                    anagrams.put(sortedStr, new ArrayList<>());
                }
                anagrams.get(sortedStr).add(str);
            }
            return new ArrayList<>(anagrams.values());
        }
    }

    class Solution2 {
        // Method 2: Categorize by Count
        // TC = O(n * k), SC = O(n * k)
        public List<List<String>> groupAnagrams(String[] strs) {
            // strs[i] consists of lowercase English letters
            if (strs == null || strs.length == 0) {
                return null;
            }
            Map<String, List<String>> anagrams = new HashMap<>();
            for (String str : strs) {
                char[] counter = new char[26];
                for (char c : str.toCharArray()) {
                    counter[c - 'a']++;
                }
                String key = new String(counter);
                if (!anagrams.containsKey(key)) {
                    anagrams.put(key, new ArrayList<>());
                }
                anagrams.get(key).add(str);
            }
            return new ArrayList<>(anagrams.values());
        }
    }
}
