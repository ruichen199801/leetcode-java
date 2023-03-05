package ruichen;

public class SingleNumberII {
    class Solution {
        // Hash Set/Hash Map: TC = O(n), SC = O(n)
        // Bit Manipulation: TC = O(n), SC = O(1)

        // x ^ x = 0 -> if x ^ x = 1, must appear once or three times

        // initialize:
        // e.g. x = 2  0b 0000001
        //   once = 0  0b 0000000
        //  twice = 0  0b 0000000

        // when x appears once:
        // e.g. x = 2  0b 0000001
        //   once = 2  0b 0000001
        //  twice = 0  0b 0000000

        // when x appears twice:
        // e.g. x = 2  0b 0000001
        //   once = 0  0b 0000000
        //  twice = 2  0b 0000001

        // when x appears three times:
        // e.g. x = 2  0b 0000001
        //   once = 0  0b 0000000
        //  twice = 0  0b 0000000

        // therefore, we return once
        public int singleNumber(int[] nums) {
            int once = 0;
            int twice = 0;
            for (int num : nums) {
                once = ~twice & (once ^ num);
                twice = ~once & (twice ^ num);
            }
            return once;
        }
    }
}
