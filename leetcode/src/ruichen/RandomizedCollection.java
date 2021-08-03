package ruichen;

import java.util.*;

public class RandomizedCollection {

    private List<Integer> list;
    private Map<Integer, Set<Integer>> map; // store <int val, Set<Integer> indexes> as <k, v> pairs to handle duplicates
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        // execute insert no matter return true or false
        list.add(val);
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size() - 1);
        return map.get(val).size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).size() == 0) {
            return false;
        }
        // delete one element in the nested inner hashset if duplicates exist
        int index = map.get(val).iterator().next();
        int lastElement = list.get(list.size() - 1);
        int size = list.size(); // record list size in case it changed after removal

        list.set(index, lastElement);

        // operation order matters!
        map.get(val).remove(index); // val == lastElement case
        map.get(lastElement).add(index);
        map.get(lastElement).remove(size - 1); // one element case

        list.remove(size - 1);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        // test case 1:
        // ["RandomizedCollection","insert","insert","insert","insert","insert","remove","remove","remove","remove"]
        // [[],[4],[3],[4],[2],[4],[4],[3],[4],[4]]
        // [null,true,true,false,true,false,true,true,true,true]
        RandomizedCollection obj = new RandomizedCollection();

//        List<Boolean> result1 = new ArrayList<>();
//        result1.add(obj.insert(4));
//        result1.add(obj.insert(3));
//        result1.add(obj.insert(4));
//        result1.add(obj.insert(2));
//        result1.add(obj.insert(4));
//        result1.add(obj.remove(4));
//        result1.add(obj.remove(3));
//        result1.add(obj.remove(4));
//        result1.add(obj.remove(4));
//        System.out.print(result1);

        // test case 2:
        // ["RandomizedCollection","insert","remove","insert","remove","getRandom"]
        // [[],[0],[0],[-1],[0],[]]
//        List<Object> result2 = new ArrayList<>();
//        result2.add(obj.insert(0));
//        result2.add(obj.remove(0));
//        result2.add(obj.insert(-1));
//        result2.add(obj.remove(0));
//        result2.add(obj.getRandom());
//        System.out.print(result2);

        // test case 3:
        // ["RandomizedCollection","insert","remove","insert","getRandom","remove","insert","getRandom"]
        // [[],[1],[2],[2],[],[1],[2],[]]
        // [null,true,false,true,2,true,false,2]
        List<Object> result3 = new ArrayList<>();
        result3.add(obj.insert(1));
        result3.add(obj.remove(2));
        result3.add(obj.insert(2));
        result3.add(obj.getRandom());
        result3.add(obj.remove(1));
        result3.add(obj.insert(2));
        result3.add(obj.getRandom());
        System.out.print(result3);
    }
}