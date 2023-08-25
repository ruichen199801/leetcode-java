package ruichen;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarI {
    // book(): TC = O(n) (booking n events will take n * O(n) = O(n^2))
    // SC = O(n)
    class MyCalendar {
        private List<int[]> bookings;

        public MyCalendar() {
            bookings = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] booking : bookings) {
                //  [x x x x x]
                // e           s
                if (end > booking[0] && start < booking[1]) {
                    return false;
                }
            }
            bookings.add(new int[]{start, end});
            return true;
        }
    }
}
