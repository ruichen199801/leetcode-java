package ruichen;

import java.util.HashMap;
import java.util.Map;

public class DesignUndergroundSystem {

    // #1396 https://leetcode.com/problems/design-underground-system/
    // Hash Table, Design
    // TC = O(1) for checkIn(), checkOut() and getAverageTime(), SC = O(n)

    class UndergroundSystem {

        Map<Integer, Event> customer;
        Map<String, Average> travelTime;

        public UndergroundSystem() {
            customer = new HashMap<>();
            travelTime = new HashMap<>();
        }

        // <id: <stationName : timestamp>>
        public void checkIn(int id, String stationName, int t) {
            customer.put(id, new Event(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            Event checkIn = customer.get(id);
            String distance = checkIn.stationName + "," + stationName; // debatable, bad for scalability
            int time = t - checkIn.timestamp;
            if (!travelTime.containsKey(distance)) {
                travelTime.put(distance, new Average(time, 1));
            } else {
                travelTime.get(distance).sum += time;
                travelTime.get(distance).count++;
            }
            customer.remove(id);
        }

        // <station : averageTime>
        public double getAverageTime(String startStation, String endStation) {
            String distance = startStation + "," + endStation;
            return travelTime.get(distance).getAverage();
        }

        class Event {
            String stationName;
            int timestamp;
            public Event(String stationName, int timestamp) {
                this.stationName = stationName;
                this.timestamp = timestamp;
            }
        }

        class Average {
            int sum;
            int count;
            public Average(int sum, int count) {
                this.sum = sum;
                this.count = count;
            }
            public double getAverage() {
                return 1.0 * sum / count;
            }
        }
    }

}
