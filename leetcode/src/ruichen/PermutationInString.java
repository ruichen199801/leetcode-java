package ruichen;

import java.util.Arrays;

public class PermutationInString {
    class Solution {
        // TC = O(m + n - m) = O(n), SC = O(1)
        public boolean checkInclusion(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            if (m > n) {
                return false;
            }

            int[] arr1 = new int[26]; // abc
            int[] arr2 = new int[26]; // eidbacooo

            for (int i = 0; i < m; i++) {
                arr1[s1.charAt(i) - 'a']++; // abc
                arr2[s2.charAt(i) - 'a']++; // eid
            }

            // similar to strStr(): slide the needle to find a match in haystack
            // eidbacooo
            //  xxx ->
            for (int i = 0; i < n - m; i++) {
                if (Arrays.equals(arr1, arr2)) {
                    return true;
                }
                // eid -> idb, restore e + add b
                arr2[s2.charAt(i) - 'a']--;
                arr2[s2.charAt(i + m) - 'a']++;
            }

            // eidbacooo|
            //       xxx|
            return Arrays.equals(arr1, arr2);
        }
    }
}
