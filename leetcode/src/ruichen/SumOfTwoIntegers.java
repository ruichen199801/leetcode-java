package ruichen;

public class SumOfTwoIntegers {

    // #371 https://leetcode.com/problems/sum-of-two-integers/
    // Bit Manipulation
    // TC = O(1) (each integer contains 32 bits), SC = O(1)

    class Solution {

        public int getSum(int a, int b) {

            // negative number's binary representation in Java: 2's complement

            while (b != 0) {
                // addition without carry: 1+1=0, 1+0=1, 0+0=0 -> XOR
                int result = a ^ b;
                // carry: one position left side of 01+01=10 -> AND + left shift 1
                int carry = (a & b) << 1;
                // a represents result
                a = result;
                // b represents carry: loop terminate condition
                b = carry;
            }
            return a;
        }

    }

}
