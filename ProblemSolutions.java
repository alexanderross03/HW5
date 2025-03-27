/******************************************************************
 *
 *   Alexander Ross / 001
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // ADD YOU CODE HERE -- DON'T FORGET TO ADD YOR NAME AT TOP OF FILE

        // Create a HashSet from list1 for O(1) lookup time
        Set<Integer> set = new HashSet<>();
        for (int num : list1) {
            set.add(num);
        }
        // Verify every element in list2 exists in the set
        for (int num : list2) {
            if (!set.contains(num)) {
                return false;
            }
        }
        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // ADD YOUR CODE HERE

        // Use a min-heap (PriorityQueue) to track the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : array) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove the smallest element to maintain size k
            }
        }
        return minHeap.peek(); // kth largest element is at the top of the min-heap
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // ADD YOU CODE HERE

        // Combine both arrays into one list
        List<Integer> combinedList = new ArrayList<>();
        for (int num : array1) {
            combinedList.add(num);
        }
        for (int num : array2) {
            combinedList.add(num);
        }
        // Sort the list using Collections.sort
        Collections.sort(combinedList);
        // Convert the sorted list back to an array
        int[] sortedArray = new int[combinedList.size()];
        for (int i = 0; i < combinedList.size(); i++) {
            sortedArray[i] = combinedList.get(i);
        }
        return sortedArray;
    }

}
