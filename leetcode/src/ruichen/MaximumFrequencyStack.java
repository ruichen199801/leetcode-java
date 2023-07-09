package ruichen;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class MaximumFrequencyStack {
    // TC = O(1) (push, pop), SC = O(n)
    class FreqStack {
        // [3, 3, 1]
        // freq:  <3,2>,<1,1>
        // group: <1,[3,1]>, <2,[3]>
        private Map<Integer, Integer> freq;         // <value, freq>
        private Map<Integer, Deque<Integer>> group; // <freq, stack of elements with that freq>
        private int maxFreq;

        public FreqStack() {
            this.freq = new HashMap<>();
            this.group = new HashMap<>();
            this.maxFreq = 0;
        }

        public void push(int val) {
            int f = freq.getOrDefault(val, 0) + 1;
            freq.put(val, f);
            if (!group.containsKey(f)) {
                group.put(f, new ArrayDeque<>());
            }
            group.get(f).offerFirst(val);
            maxFreq = Math.max(maxFreq, f);
        }

        public int pop() {
            int val = group.get(maxFreq).pollFirst();
            freq.put(val, freq.get(val) - 1);
            if (group.get(maxFreq).size() == 0) {
                maxFreq--;
            }
            return val;
        }
    }
}
