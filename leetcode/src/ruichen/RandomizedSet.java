package ruichen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
    // TC: getRandom O(1) insert/remove O(1) in average, O(n) worst case when operation exceeds capacity of array/hashmap
    // SC = O(2n) = O(n) to store n elements
    private List<Integer> list;
    private Map<Integer, Integer> map; // <val, index of val in the list>
    private Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);
        // swap val with last element, delete last element
        list.set(index, lastElement); // set(int index, E element): replace index i with new element
        map.put(lastElement, index); // put(key, value): update
        list.remove(list.size() - 1); // remove(int index)
        map.remove(val); // remove(key)
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}