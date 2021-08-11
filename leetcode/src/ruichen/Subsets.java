package ruichen;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    // #78 https://leetcode.com/problems/subsets/
    // Depth-first Search
    // TC = O(2^n * n): for each layer, 2^n numbers of recursive calls * O(n) deep copy curr to result
    // SC = O(n): recursion call stack (if we ignore the memory used only to return result)

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(nums, 0, curr, result); // input array, index (recursion depth), helper to add/throw elements in DFS, result (equivalent to print)
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> curr, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(curr)); // result.add(curr); -> [[], [], [], [], [], [], [], []]
            return;
        }
        // case 1: add the current element
        curr.add(nums[index]);
        helper(nums, index + 1, curr, result);
        curr.remove(curr.size() - 1); // remove the added character when backtracking to the previous level

        // case 2: not add the current element
        helper(nums, index + 1, curr, result);
    }

    public static void main(String[] args) {
        Subsets obj = new Subsets();
        int[] nums = {1, 2, 3};
        System.out.print(obj.subsets(nums));
    }
}

/*
                                                            { }
                                                     /                \
For a:                                   {a}                                    { }
                                 /                 \                      /               \
For b:                        {a, b}                 {a}                {b}               { }
                            /       \              /     \            /     \            /    \
For c:                 {a, b, c}   {a, b}      {a, c}    {a}      {b, c}    {b}         {c}   { }

 */