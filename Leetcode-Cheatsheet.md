# Leetcode Cheatsheet

## Table of Contents

- [Common Mistakes](#Common-Mistakes)
- [Java Tricks](#Java-Tricks)
- [Algorithm Tricks](#Algorithm-Tricks)
- [Complexity Analysis](#Complexity-Analysis)

## Common Mistakes

1. Be careful with initialization operations.

    ```
    Queue<Integer> queue = new ArrayDeque<>();
    Set<Integer> visited = new HashSet<>();

    queue.offer(firstNode);             // DO NOT FORGET         
    visited.add(firstNode);             // DO NOT FORGET  

    while (!queue.isEmpty()) { ... }
    ```

2. Be careful with initialization values.

    ```
    int min = Integer.MAX_VALUE;  // DO NOT INITIALIZE TO 0

    int max = Integer.MIN_VALUE;  // 0, -1
    ```

3. Be careful with data types.

    ```
    boolean[][] IS NOT int[][]

    long IS NOT int
    
    TreeNode IS NOT Integer
    
    node.val IS NOT node
    ```

4. Do not mix notations.

    ```
    dp[i][j] IS NOT matrix[i][j]

    ListNode curr = head;
    curr IS NOT head, DO NOT update head in a loop

    TreeNode curr = root;
    curr IS NOT root, DO NOT update root in a loop
    ```

5. Do not mix variables.

    ```
    nums[i] IS NOT i

    len1 IS NOT len2
    arr1 IS NOT arr2
    a    IS NOT b
    ```

6. Do not forget new keyword.

    ```
    int[] arr = new int[] {1, 2, 3};
    int[] arr = {1, 2, 3};            // Shorthand

    return arr;               
    return new int[] {1, 2, 3};       // NOT {1, 2, 3}
    ```

7. Length and index are different.

    ```
    int[][] dp = new int[m + 1][n + 1]; 
    // i, j represents length
    // dp[i][j] is mapped to matrix[i - 1][j - 1], 
    //          or s.charAt(i - 1), t.charAt(j - 1)

    int[][] dp = new int[m][n];          
    // i, j represents ending index
    // dp[i][j] is mapped to matrix[i][j], 
    //          or s.charAt(i), t.charAt(j)
    ```

8. Deep copy DFS results.

   ```
   List<Integer> curr = new ArrayList<>();
   ...
   result.add(new ArrayList<>(curr));  // NOT result.add(curr)
   ```

## Java Tricks

1. Make comparisons.

- String and char[]

    ```
    if (c1 == c2) { ... }
    
    if (s1.equals(s2)) { ... }
    
    if (s1.equalsIgnoreCase(s2)) { ... }   
    ```

- Integer and int

    ```
    int a, b;
    if (a == b) { ... }     

    Integer a, b;
    if (a.equals(b)) { ... }  

    Deque<Integer> stack = new ArrayDeque<>();      // Stack values are Integer, not int

    stack.pollFirst() == minStack.peekFirst()       // Wrong
    stack.pollFirst().equals(minStack.peekFirst())  // Correct

    int val = stack.pollFirst();                    // Unbox to int
    val == minStack.peekFirst()                     // Correct
    ```

- byte[]

    ```
    if (Arrays.equals(arr1, arr2)) { ... }
    ```
    
- compareTo()

    ```
    "apple".compareTo("banana") < 0  // b is lexicographically greater than a
    ```

2. Given `row * col` matrix, where `matrix[r][c]` represents a point on the 2D grid.

    ``` 
    matrix[r][c] -> int index = r * col + c;   // 2D -> 1D

    index -> matrix[index / col][index % col]  // 1D -> 2D
    ```

3. Use a counter to count lowercase characters.

    ```
    int[] counter = new int[26];  // NOT char[]

    counter[c - 'a']++;           // NOT counter[c]++;
    ```

4. Check and read digits from char or string.

- Check digits

    ```
    if (Character.isDigit(c)) { ... }
    
    if (Character.isAlphabetic(c)) { ... }
    
    if (Character.isLetterOrDigit(c)) { ... }
    
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    for (char c : alphabet.toCharArray()) { ... }
    
    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') { ... }
    ```

- Read digits

    ```
    int digit = s.charAt(i - 1) - '0';
    
    int oneDigit = Integer.parseInt(s.substring(i - 1, i));
    int twoDigits = Integer.parseInt(s.substring(i - 2, i));
    ```

5. Add and subtract characters.

    ```
    'a' + 'b'          // '97'+'98' = 195 (int)
    '' + 'a' + 'b'     // "ab" (string)
    
    s.charAt(i) - '0'  // 0-9 (int)
    s.charAt(i) - 'a'  // 0-25 (int), for lowercase letters
    ```

6. Join and split string.

- Join string

    ```
    String[] words = {"Java", "is", "awesome"};
    String sentence = String.join(" ", words);   // Java is awesome
    
    List<String> words = Arrays.asList("Java", "is", "awesome");
    String sentence = String.join(" ", words);   // Java is awesome
    ```
    
- Split string

    ```
    String[] parts = s.split(" ");
    
    String[] parts = s.split("\\.");  // ESCAPE SPECIAL CHARACTERS
    ```

7. Pass comparators to heaps, custom classes, and sort functions.

    ```
    Arrays.sort(array, (a, b) -> a[0] - b[0]);  // Ascending order

    Arrays.sort(array, (a, b) -> b[0] - a[0]);  // Descending order

    PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
    ```

8. Conversion between string and value.

    ```
    int val = Integer.parseInt(str);  // Convert String to int
                                      // ALWAYS USE THIS

    int val = Integer.valueOf(str);   // Convert String to Integer
                                      // DO NOT USE THIS
                                         
    String str = String.valueOf(val); // Convert int to String
    ```

9. Convert string array/list to set.

    ```
    // List<String>

    Set<Integer> wordSet = new HashSet<>(wordList);
    
    // String[]

    Set<Integer> wordSet = new HashSet<>();
    for (String word : wordList) {
      wordSet.add(word);
    }
    ```

10. Conversion between list and array.

    ```
    // List<Integer> to int[]

    List<Integer> list = new ArrayList<>();
    int[] arr = list.toArray(new int[list.size()]);

    // List<int[]> to int[][]

    List<int[]> list = new ArrayList<>();
    int[] arr = list.toArray(new int[list.size()][]);

    // int[] to List<Integer>

    int[] arr = {1, 2, 3, 4, 5};
    List<Integer> list = new ArrayList<>();
    for (int i : arr) {
      list.add(i);
    }
    ```
    
11. Size and length.

    ```
    arr.length    // Array

    s.length()    // String/StringBuilder

    list.size()   // List/Set/Map/Stack/Queue/PriorityQueue
    ```

12. Misc APIs.

- Sort

    ```
    Arrays.sort(array);      // int[] array

    Collections.sort(list);  // List<Integer> list
    ```

- Arrays

    ```
    Arrays.fill(nums, Integer.MAX_VALUE);  // 1, -1
    
    Arrays.copyOf(nums, newLength)

    Arrays.asList(1, 2, 3)  // Individual elements -> List<Integer>
                            // NOT {1, 2, 3}

    Arrays.toString(solution())  // Useful to print list/matrix result in main function
    ```

- String

    ```
    char[] arr = s.toCharArray();
    String s = new String(arr);
    String s = new String(arr, start, length);
    
    String s1 = s.substring(start, end)  // [inclusive, exclusive)
    ```

- StringBuilder

    ```
    StringBuilder sb = new StringBuilder();
    
    sb.append(c);          // e.g. "Hello", 123, 'a', true, 3.14, new Object()
    sb.deleteCharAt(i);    // e.g. sb.size() - 1
     
    return sb.toString();  // Create a new String
    return sb.reverse().toString();
    ```

- Stack

    ```
    Deque<Integer> stack = new ArrayDeque<>();
    
    stack.offerFirst(i);
    int curr = stack.pollFirst();
    while (!stack.isEmpty()) { ... }
    if (curr == stack.peekFirst()) { ... }
    ```

- Queue

    ```
    Queue<Integer> queue = new ArrayDeque<>();
    
    queue.offer(node);
    int curr = queue.poll();
    while (!queue.isEmpty()) { ... }
    ```

- PriorityQueue

    ```
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();   
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    
    minHeap.offer(i);
    int curr = minHeap.poll();
    while (!minHeap.isEmpty()) { ... }
    if (curr == minHeap.peek()) { ... }
    ```

- HashMap

    ```
    Map<String, Integer> map = new HashMap<>();
    
    int count = map.getOrDefault(word, 0) + 1;
    map.put(word, count);
    
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      String key = entry.getKey();
      Integer val = entry.getValue();
    }
    ```
    
## Algorithm Tricks

1. Tree problems

- Always use recursion to attempt tree problems.

- If the original function is difficult to use for our recursive solution, we can add more parameters to the signature, e.g. in [Symmetric tree](https://leetcode.com/problems/symmetric-tree/).

- Avoid using global variables for shared states, such as the result/sum/max/min array. Add them to the DFS function signature instead.

- If we need to pass or store **intermediate states** between nodes, we should change the return type to int or boolean, otherwise use void.

    ```
    void func(TreeNode root) { ... }    // Original function
    
    int dfs(TreeNode root, int[] max);  // DFS function
    ```

2. Do we need a visited set in BFS/DFS?

- No, if we are traversing tree.

- No, if we can modify input directly to mark as visited, e.g. in [Number of islands](https://leetcode.com/problems/number-of-islands/), mark `grid[i][j] = 0`.

3. Do we need minHeap or maxHeap to solve [Top k frequent elements](https://leetcode.com/problems/top-k-frequent-elements/)?

- maxHeap

  - Step 1: Heapify all elements: O(n)

  - Step 2: Call maxHeap.poll() k times to get k most frequent elements: O(n log k)

  - TC = O(n + k log n), SC = O(n)

- minHeap (PREFERRED)

  - Step 1: Heapify the first k elements: O(k)

  - Step 2: Enqueue the remaining (n - k) elements, and conveniently, the popped out elements from minHeap are the less frequent elements we don't want: O((n - k) log k)

  - TC = O(k) + (n - k) * O(log k) = O(k + (n - k) log k), SC = O(k)

4. Think about conditions/rules to check before exploring neighbors in BFS.

- General: If the neighbor is visited

- Island: If the coordinate is valid/in bound && the point is an island

- [Course schedule](https://leetcode.com/problems/course-schedule/): If the vertex is in graph.

    ```
    if (graph.containsKey(curr)) {
        for (int nei : graph.get(cur)) {
            ...
        }
    }
    ```

5. Prefix sum

    ```
    // prefixSum[i]: Sum from 0 to i (inclusive)

    int[] prefixSum = new int[n];
    prefixSum[0] = nums[0];
    for (int i = 1; i < n; i++) {
        prefixSum[i] = prefixSum[i - 1] + nums[i];
    }

    // Sum from i to j (inclusive)

    Sum[i...j] = prefixSum[j] - prefixSum[i] + nums[i]; 
    ```

## Complexity Analysis

1. Amortized and average complexity

- Average 

  - Makes assumptions about the input that may not be met in certain cases. Therefore, if your input is not random, in the worst case the actual performace of an algorithm may be much slower than the average case.

- Amortized 
  
  - Makes no such assumptions, but it considers the total performance of a sequence of operations instead of just one operation.

2. [Balanced binary tree](https://leetcode.com/problems/balanced-binary-tree/)

- Method 1: TC = O(n log n) average, O(n^2) worst

  - Call height() `n` times for each node: O(n)

  - Call isBalanced() `height` times: O(height) = O(log n) if balanced, O(n) worst case

- Method 2: TC = O(n)

  - Avoids the need to compute the height of each subtree separately and instead combines the computation of height and balance status into a single function.

3. Why cycle detection using BFS/DFS takes O(V + E)?

- Equeue each node once: O(V)

- Traverse neighbors of current node: O(E)

4. Quick select and merge sort

- Quick select: O(n) in average, O(n^2) worst case 

  - We only care about the smaller half, the total array size is shrinking each run.

- Merge sort: O(n log n) 

  - The total array size is always n each run, for log n times recursive calls.

5. We often can optimize the space complexity of a dynamic programming solution from O(n^2) to O(n), and even O(1), if the recursive equation only depends on the previous state.
