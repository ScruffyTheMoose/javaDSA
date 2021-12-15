import java.util.*;

public class QuickSort {
    
    public static void main(String[] ares) {

        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();

        for ( int i = 0; i < 25; i++ ) {
            list.add(rand.nextInt(100));
        }

        System.out.println(list);
        quickSort(list);
        validate(list);
        System.out.println(list);

    }

    /**
     * Parent method that operates all subordinate quicksort methods to perform the sort.
     * @param pList
     */
    public static void quickSort(ArrayList<Integer> pList) {
        recursiveQuickSort(pList, 0, pList.size() - 1);
    }

    /**
     * Method that will recursively apply partition and quicksort
     * 
     * Worst case time complexity of O(n^2) if the list is already in ascending order. If we choose the left most element everytime in a sorted array,
     * we will constantly be splitting the array where left has a size of 1 and right has a size of n - 1. This means that for each element in the array,
     * all other elements will be checked leading to O(n^2). This also occurs if all elements in the list have the same value. This problem can be mitigated
     * by always choosing a middle element as the pivot rather than the left/rightmost element.
     * 
     * Average/base case time complexity of O(nlgn). For a list of size n = 2^p where the partitioning is roughly 50/50, the list will need to be partitioned lg(n) times.
     * Each partition reduces the size of the list by a factor of 1/2.
     * Within each partition, the most checks that will be made are Cn, where C is a constant that varies depending on the depth of the partition in the recursion.
     * This leaves us with a base time complexity of O(nlgn).
     * @param pList
     * @param fromIdx
     * @param toIdx
     */
    public static void recursiveQuickSort(ArrayList<Integer> pList, int fromIdx, int toIdx) {
        
        // Calling the partition method to split the given array, order the elements, and return back the index of what will become the next partition.
        int idx = partition(pList, fromIdx, toIdx);

        // Checking to ensure the left side will be greater than size = 1. If so, recursively call quicksort on the left side.
        if ( fromIdx < idx - 1 ) {
            recursiveQuickSort(pList, fromIdx, idx - 1);
        }

        // Checking to ensure the right side will be greater than size = 1. If so, recursively call quicksort on the right side.
        if ( toIdx > idx ) {
            recursiveQuickSort(pList, idx, toIdx);
        }
    }

    /**
     * Method that will sort a given partition of the ArrayList that returns the last left value to identify where the next partition will be split.
     * @param pList
     * @param left
     * @param right
     * @return
     */
    public static int partition(ArrayList<Integer> pList, int left, int right) {
        
        // Determining the index of the middle-most value in the array to be partitioned.
        // We add half the difference between the left and right indexes to the left index to get the middle.
        int mid = left + (right - left) / 2;
        // Getting the value of the middle index to use as the pivot.
        int pivot = pList.get(mid);

        // While loop that will continue running so long as the left cursor and right cursor have not crossed.
        while ( left <= right ) {

            // Operating on the left side first, the left cursor will increment to the right until it reaches a value that is greater than the pivot value.
            while ( pList.get(left) < pivot ) {
                left++;
            }

            // After the left 'high' value has been determined, the right cursor will decrement left until it finds a value that is less than the pivot.
            while ( pList.get(right) > pivot ) {
                right--;
            }

            // The left and right indexes are then compared to make sure they have not crossed. If they had crossed, we would be placing elements out of order.
            // If left is still <= right, then the values are swapped which puts the higher value on the right side and the lower value on the left.
            if ( left <= right ) {
                int temp = pList.get(left);
                pList.set(left, pList.get(right));
                pList.set(right, temp);

                // After making the swap, the left cursor is incremented and the right cursor is decremented because those indexes had already been operated on.
                left++;
                right--;
            }
        }

        // When the main while-loop breaks, we know that the given array is sorted relative to the pivot. 
        // We return the left cursor position as the split point for the next partition.
        // If we wanted to return the right cursor as the new split point, we would need to have a completely different order of operations above.
        return left;
    }

    /**
     * Validation for a sort. Will check to make sure all elements in the ArrayList are in ascending order and prints the result.
     * @param pList
     */
    public static void validate(ArrayList<Integer> pList) {
        for ( int i = 0; i < pList.size() - 1; i++ ) {
            if ( pList.get(i) > pList.get(i + 1) ) {
                System.out.println("FAILED - List not ascending");
                return;
            }
        }
        System.out.println("PASSED - List ascending");
    }

}
