//package ruichen;
//
//public class MakingALargeIsland {
//
//    // #827 https://leetcode.com/problems/making-a-large-island/
//    // Depth-first Search
//    // TC = O(n^2), SC = O(n^2) (recursion depth)
//
//    class Solution {
//        public int largestIsland(int[][] grid) {
//
//        }
//    }
//}
//
///*
//initial state:
//0 1 0 1 0  max =          // global max # of interconnected islands (horizontal or vertical)
//1 1 0 0 1  islandId = 2   // unique island ids of connected islands starting from 2 to differ from original 1s, incremental
//0 0 1 1 0  map = []       // hashmap to store (islandId, local max) as (k, v) pairs
//
//recursively mark islandId:
//0 2 0 3 0  max= 3
//2 2 0 0 4  islandId = 6
//0 0 5 5 0  map = [(2,3), (3,1), (4,1), (5,2)]
//
//explore all 0s to compute max after changing 0 to 1:
//condition: adjacent islands should have unique islandId, skip when islandId is the same or reach matrix boundary
//0 2 0 3 0  max= 3 -> 5 -> 6
//2 2 0 0 4  islandId = 5
//0 1 5 5 0  map = [(2,3), (3,1), (4,1), (5,2)]
// */