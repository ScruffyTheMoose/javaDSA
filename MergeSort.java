import java.util.*;

public class MergeSort {
    
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
     * Recursive Merge Sort.
     * Will recursively break down a given List into lists of size 1, where they will then be merged back together in ascending order.
     * 
     * Complexity O(nlgn). The array will be split roughly lg(n) times during the recursive calls to the sort method. Then, each element will be checked/compared 
     * Cn times, where C is a constant that varies depending on the recursion level. This leaves us with time complexity of O(nlgn).
     * lg is log base 2.
     * @param pList
     */
    public static void sort(List<Integer> pList) {
       
        // If the input list is at the minimum size, it is trivially sorted and gets passed back to the preceding recursion layer immediately.
        if ( pList.size() < 2 ) {
            return;
        }

        // Choosing a split point for the list.
        // Opted to not use the subList() method since it causes issues with small lists. Probably solvable but iteration is effectively the same.
        int mid = pList.size() / 2;
        List<Integer> listLeft = new ArrayList<>();
        List<Integer> listRight = new ArrayList<>();

        // Iterating through elements on left side of pList to add then to the leftList.
        for ( int i = 0; i < mid; i++ ) {
            listLeft.add(pList.get(i));
        }

        // Iterating through elements on the right side of pList to add them to the rightList.
        for ( int i = mid; i < pList.size(); i++ ) {
            listRight.add(pList.get(i));
        }

        // Calling merge sort on both sides of the input list to further break them down.
        sort(listLeft);
        sort(listRight);

        // The lists will be merged together, layer by layer from the smallest size until the recursion is complete.
        merge(pList, listLeft, listRight);
    }

    /**
     * merge method which combines two Lists in ascending order.
     * @param pList
     * @param pLeft
     * @param pRight
     */
    public static void merge(List<Integer> pList, List<Integer> pLeft, List<Integer> pRight) {
        
        // Three variables to track the position of the current element in all three given lists.
        // l for left list
        // r for right list
        // b for base list
        int l = 0, r = 0, b = 0;

        // Iterates through the elements of the left and right list, compares them, and adds the lowest to the base list.
        // This continues until one list has exhausted all elements.
        // Each time an element is added, the tracking variables for the specific side and the base list are iterated forward.
        while ( l < pLeft.size() && r < pRight.size() ) {

            if ( pLeft.get(l) < pRight.get(r) ) {
                pList.set(b, pLeft.get(l));
                b++;
                l++;
            } else {
                pList.set(b, pRight.get(r));
                b++;
                r++;
            }
            
        }

        // If there are any remaining elements in the left list, they will be added to the base list.
        // Since the elements are already sorted, there is no need to validate the order.
        while ( l < pLeft.size() ) {
            pList.set(b, pLeft.get(l));
            b++;
            l++;
        }

        // If there are any remaining elements in the right list, they will be added to the base list.
        // Since the elements are already sorted, there is no need to validate the order.
        while ( r < pRight.size() ) {
            pList.set(b, pRight.get(r));
            b++;
            r++;
        }
        
    }

}
