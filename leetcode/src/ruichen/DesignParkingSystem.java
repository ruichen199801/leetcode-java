package ruichen;

public class DesignParkingSystem {
    class ParkingSystem {
        private int[] slots;

        public ParkingSystem(int big, int medium, int small) {
            slots = new int[]{big, medium, small};
        }

        public boolean addCar(int carType) {
            return slots[carType - 1]-- > 0;
        }
    }
}
