import java.util.*;

public class SelectionSort {
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();

        for ( int i = 0; i < 25; i++ ) {
            list.add(rand.nextInt(100));
        }

        System.out.println(list);
        sort(list);
        System.out.println(list);
    }

    /**
     * Selection Sort.
     * For each element of the list at index i, the method will check i and all following values j to identify the minimum value in the ArrayList.
     * After checking all values in the list, i and the minimum value will be swapped.
     * 
     * The time complexity is O(n^2).
     * For each index i, n - i elements need to be checked. The number of elementary operations is the same as with Insertion Sort which creates a series of integer values from 1 to n - 1.
     * The series is represented by the equation n(n - 1) / 2, which when simplified yields a highest degree of n^2.
     * @param pList
     */
    public static void sort(ArrayList<Integer> pList) {
        
        // The target index to place the identified lowest value in the array.
        for ( int i = 0; i < pList.size(); i++ ) {
            
            // The lowest identified value in the array. By default it will always be set to the last number in the array.
            // This ensures it will never overlap with the current i index.
            // Since all numbers follow i will be checked regardless, setting the minimum value to the last index does not impact performace.
            int minIdx = pList.size() - 1;

            // Iterating through all values from i to n - 1 inclusive and checking the value at j against the minimum value index.
            for ( int j = i; j < pList.size(); j++ ) {
            
                // If the value at index j is lower, it will be assigned as the new minimum index.
                if ( pList.get(j) <= pList.get(minIdx) ) {
                    minIdx = j;
                }
            }

            // Once the j-loop has ended, the minimum value and its index have been identified so we call the swap() method.
            // The swap() method will place the lowest value into position i, setting the original value at an arbitrary position minIdx further down the line.
            swap(pList, i, minIdx);

        }

    }

    /**
     * swap method that will use temporary variables to hold the values at the given indexes.
     * Will then assign the values to the opposing index.
     * @param pList
     * @param idx1
     * @param idx2
     */
    public static void swap(ArrayList<Integer> pList, int idx1, int idx2) {
        int hold1 = pList.get(idx1);
        int hold2 = pList.get(idx2);
        pList.set(idx1, hold2);
        pList.set(idx2, hold1);
    }

}
