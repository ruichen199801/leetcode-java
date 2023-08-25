package ruichen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestinationCity {
    // TC = O(n), SC = O(n)
    class Solution {
        public String destCity(List<List<String>> paths) {
            Map<String, String> graph = new HashMap<>();

            for (List<String> path : paths) {
                graph.put(path.get(0), path.get(1));
            }

            for (List<String> path : paths) {
                if (!graph.containsKey(path.get(1))) {
                    return path.get(1);
                }
            }

            return "";
        }
    }
}
