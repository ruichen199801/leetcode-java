package ruichen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger {

    // #989 https://leetcode.com/problems/add-to-array-form-of-integer/
    // Math, String
    // TC = O(n + log k), SC = O(max(n, log k)) where n is the length of num

    class Solution {

        // a fun fact: there's no built-in method in Java to convert list of integers to primitive int array, check the post below:
        // https://stackoverflow.com/questions/718554/how-to-convert-an-arraylist-containing-integers-to-primitive-int-array
        // array to list, on the other hand: Arrays.asList(array)

        public List<Integer> addToArrayForm(int[] num, int k) {
            List<Integer> result = new ArrayList<>();
            int i = num.length - 1, carry = 0;
            while (i >= 0 || k > 0 || carry != 0) {
                int sum = carry;
                if (i >= 0) {
                    sum += num[i];
                    i--;
                }
                if (k > 0) {
                    sum += k % 10;
                    k /= 10;
                }
                result.add(sum % 10);
                carry = sum / 10;
            }
            Collections.reverse(result); // a void method
            return result;
        }

    }
}
