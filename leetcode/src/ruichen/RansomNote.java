package ruichen;

public class RansomNote {
    // TC = O(n), SC = O(1)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) return false;
            int[] counter = new int[26]; // not char[]
            for (int i = 0; i < magazine.length(); i++) {
                char c = magazine.charAt(i);
                counter[c - 'a']++;
            }

            for (int i = 0; i < ransomNote.length(); i++) {
                char c = ransomNote.charAt(i);
                counter[c - 'a']--;
                if (counter[c - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
