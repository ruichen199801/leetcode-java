package ruichen;

public class DesignParkingSystem {

    // #1603 https://leetcode.com/problems/design-parking-system/
    // Design

    class ParkingSystem {

        private int[] slots;

        public ParkingSystem(int big, int medium, int small) {
            slots = new int[] {big, medium, small};
        }

        public boolean addCar(int carType) {
            return slots[carType - 1]-- > 0;
        }
    }
}
