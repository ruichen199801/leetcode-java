package ruichen;

public class RobotBoundedInCircle {

    // #1041 https://leetcode.com/problems/robot-bounded-in-circle/
    // Math, Simulation
    // TC = O(n), SC = O(1) (toCharArray() cost not counted)

    class Solution {
        public boolean isRobotBounded(String instructions) {
            // directions[index]: 0 - 3 represent north, east, south, west
            // clockwise: turn right is 1, turn left is 3
            int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int x = 0, y = 0; // at original point initially
            int index = 0; // face north initially
            for (char instruction: instructions.toCharArray()) {
                if (instruction == 'G') {
                    x += directions[index][0];
                    y += directions[index][1];
                } else if (instruction == 'R') {
                    index = (index + 1) % 4;
                } else {
                    index = (index + 3) % 4; // 1 turn to the left = 3 turns to the right
                }
            }
            return (x == 0 && y == 0) || index != 0; // can loop in a cycle when return to original point or direction changed after one run
        }
    }
}
