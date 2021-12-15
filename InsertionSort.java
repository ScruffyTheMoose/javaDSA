import java.util.*;

public class InsertionSort {
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
     * Insertion Sort.
     * Iterates through an ArrayList<Integer> starting from index 1 using variable i. Variables k is used in place of i in the nested loop 
     * to iterate backwards as needed so as not to break the outer loop.
     * If the preceding value at j > k, then they will be swapped. j <= k, then the loop is broken to save time 
     * since this means that the numbers from i backwards are in order.
     * This continues until the last index i is checked.
     * 
     * Time complexity of O(n^2).
     * Worst case we need to sort a descending list to ascending order. Each element from 1 to n - 1 would need to move all the way to the start.
     * The equation to represent the series is n(n-1) / 2, which when simplified yields a highest degree of n^2.
     * 
     * @param pList
     */
    public static void sort(ArrayList<Integer> pList) {

        // value to be checked against the preceding numbers is index i
        for ( int i = 1; i < pList.size(); i++ ) {

            // j is used to iterated back through the preceding numbers.
            // k takes the place of i. If the value at k needs to be moved, we can iterate index k back as well.
            // If we were to iterate index i backwards, the outer loop would be ruined.
            for ( int j = i - 1, k = i; j >= 0; j-- ) {

                // if the preceding value is greater than the value at k, we call the swap() method.
                // we then iterate index k backwards as well to follow the original value as it moves
                if ( pList.get(j) > pList.get(k) ) {
                    swap(pList, j, k);
                    k--;

                // if j <= k, then the numbers are in order and we break to prevent wasting time checking all remaining values.
                } else {
                    break;
                }
            }
        }
    }

    /**
     * method to swap two elements in an ArrayList<Integer>. Stores both elements are the given indexes in temp variables.
     * Then assigns the stored variables to the opposing indexes.
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