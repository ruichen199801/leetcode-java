package ruichen;

public class DuplicateZeros {
    // Count the number of zeros to be duplicated
    // do not count the zeros to be trimmed
    // edge case: a zero present on the last boundary: copy it exactly once

    // TC = O(n), SC = O(1)
    class Solution {
        public void duplicateZeros(int[] arr) {
            int zeros = 0, len = arr.length;

            for (int i = 0; i < len - zeros; i++) {
                if (arr[i] == 0) {
                    if (i == len - zeros - 1) {
                        arr[len - 1] = 0; // last element of "result array" is set to zero (once)
                        len--; // when we iterate again to construct result, skip this position
                        break; // this shouldn't be counted into the zeros to be duplicated, so break
                    }
                    zeros++;
                }
            }

            // construct result from end of array to avoid overwriting original values
            for (int i = len - zeros - 1; i >= 0; i--) {
                if (arr[i] == 0) {
                    arr[i + zeros] = 0;
                    zeros--;
                    arr[i + zeros] = 0;
                } else {
                    arr[i + zeros] = arr[i];
                }
            }
        }
    }
}
