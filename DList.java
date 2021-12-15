public class DList {

    // Reference to head Node
    private Node mHead;

    // Variables to track size of list
    private int mSize;

    // Reference to tail Node
    private Node mTail;

    /**
     * Creates an empty DList object
     */
    public DList() {
        setHead(null);
        setTail(null);
        setSize(0);
    }

    /**
     * Creates a new DList object containing an initial Node and value
     * @param pData
     */
    public DList(Integer pData) {
        
        // Creates a new Node using the given data to be stored
        Node newNode = new Node(pData);

        // mHead reference created with the newNode
        setHead(newNode);

        // mTail reference created with the newNode
        setTail(newNode);

        // mSize set to 1 representing the newNode
        setSize(1);

    }

    // Adds a new node to the list at some index
    public void add(int pIndex, Integer pData) throws IndexOutOfBoundsException {

        // If getSize() != 0, then we check to see if the given index is in bounds.
        if ( pIndex < 0 || pIndex > getSize() ) {
            throw new IndexOutOfBoundsException();
        }

        // We are appending
        if ( pIndex == getSize() ) {
            
            Node newNode = new Node(pData, mTail, null);

            if ( isEmpty() ) {
                setHead(newNode);
            } else {
                getTail().setNext(newNode);
            }
            
            setTail(newNode);
        }
        // If the index is anywhere inside the list, we are inserting.
        else {
            Node node = getNodeAt(pIndex);

            Node newNode = new Node(pData, node.getPrev(), node);

            if ( pIndex != 0 ) {
                node.getPrev().setNext(newNode);
            }

            node.setPrev(newNode);

            if ( pIndex == 0 ) {
                setHead(newNode);
            }
        }
        mSize++;

    }

    // Adds a new node to the list at the end
    public void append(Integer pData) {
        add(getSize(), pData);
    }

    // Will delete all elements in a list
    public void clear() {
        while ( getSize() > 0 ) {
            remove(0);
        }
    }

    // Node data accessor using an index as a reference that returns the value of Node at index
    public int get(int pIndex) throws IndexOutOfBoundsException {
        
        // Calls the getNodeAt() method and returns the data stored inside the returned Node
        return getNodeAt(pIndex).getData();

    }

    // mSize accessor
    public int getSize() {
        return mSize;
    }

    // Returns boolean value of whether or not the list contains Nodes
    public boolean isEmpty() {
        return getSize() == 0;
    }

    // Adds a new node as the head of the list
    public void prepend(Integer pData) {
        add(0, pData);
    }

    // Will remove a Node from the list using an index as a reference and returns the previously stored data in that node
    public Integer remove(int pIndex) throws IndexOutOfBoundsException {

        if ( pIndex == 0 && getSize() == 1 ) {
            Integer data = mHead.getData();
            setHead(null);
            setTail(null);
            mSize = 0;
            return data;
        }

        if ( pIndex < 0 || pIndex > getSize() - 1 ) {
            throw new IndexOutOfBoundsException();
        }

        // Removing the Head
        if ( pIndex == 0 ) {
            // Saving data in Head
            Integer data = mHead.getData();

            // Setting head to the immediately succeeding Node
            setHead(mHead.getNext());

            // Nullifying connection between new and old Head
            mHead.getPrev().setNext(null);
            mHead.setPrev(null);

            // Decrement size
            mSize--;

            // Returning data
            return data;

        }
        // Removing the Tail
        else if ( pIndex == getSize() - 1 ) {
            // Saving data in Tail
            Integer data = mTail.getData();

            // Setting the Tail to be the immediately preceeding Node
            setTail(mTail.getPrev());

            // Nullifying connection between new and old Tail
            mTail.getNext().setPrev(null);
            mTail.setNext(null);

            // Decrement size
            mSize--;

            // Returning data
            return data;

        }
        // Removing an element in the middle of the list
        else {
            // Uses getNodeAt() to retrieve the Node being removed
            Node rem = getNodeAt(pIndex);

            // Saving the data stored in rem
            Integer data = rem.getData();

            // Finding and storing references to the previous and next nodes from rem
            Node next = rem.getNext();
            Node prev = rem.getPrev();

            // Removing rem from the linked order by reassigning the next and prev nodes
            prev.setNext(next);
            next.setPrev(prev);

            // Nullifying reference values in rem
            rem.setNext(null);
            rem.setPrev(null);

            // Decrement size
            mSize--;

            // Returning the previously stored data
            return data;
        }

        
    }

    // Will set the data inside an existing node
    // Returns the data that was previously stored inside that Node
    public Integer set(int pIndex, Integer pData) throws IndexOutOfBoundsException {
        
        // Retrieving the Node at the given index to access and modify it
        Node node = getNodeAt(pIndex);

        // Storing the data inside the Node before replacing it
        Integer data = node.getData();

        // Setting the data inside the Node to the new given data
        node.setData(pData);

        // Returning the original data that was stored in the Node
        return data;
        
    }
    
    @Override
    public String toString() {
        String string = "";
        for ( int i = 0; i < mSize; i++ ) {
            string += get(i) + " ";
        }
        return string;
    }

    // mHead accessor
    protected Node getHead() {
        return mHead;
    }

    // Node accessor that returns the Node found at the given index
    protected Node getNodeAt(int pIndex) throws IndexOutOfBoundsException {
        
        // Checks that the given index is within the bounds of the list
        if ( pIndex < 0 || pIndex > getSize() - 1 ) {
            throw new IndexOutOfBoundsException();
        }

        // Checks the common cases of accessing the Head and Tail Nodes
        if ( pIndex == 0 ) {
            return getHead();
        } else if ( pIndex == getSize() - 1 ) {
            return getTail();
        }

        // Creating a Node to store values as we iterate through the list
        // We assign it the Node immediately succeeding the Head
        Node node = getHead().getNext();
        
        // We use .getNext() on each node until we have incremented to the given index
        for ( int i = 1; i < pIndex; i++ ) {
            node = node.getNext();
        }

        // Returning the Node that is found
        return node;

    }

    // mTail accessor
    protected Node getTail() {
        return mTail;
    }

    // mHead mutator
    protected void setHead(Node pHead) {
        mHead = pHead;
    }

    // mSize mutator
    protected void setSize(int pSize) {
        mSize = pSize;
    }

    // mTail mutator
    public void setTail(Node pTail) {
        mTail = pTail;
    }

    protected static class Node {

        // The data being stored in this node instance
        private Integer mData;

        // The reference to the next node in the list
        private Node mNext;

        // The reference to the previous node in the list
        private Node mPrev;

        // Constructor for a node object
        public Node() {

        }

        // Overloaded constructor for node object that assigns the integer value to be stored
        public Node(Integer pData) {
            setData(pData);
            setNext(null);
            setPrev(null);
        }

        // Overloaded constructor for node object that assigns integer data and references to both prev and next elements in list
        public Node(Integer pData, Node pPrev, Node pNext) {
            setData(pData);
            setNext(pNext);
            setPrev(pPrev);
        }

        /**
         * Determines if argument Node is the same as the current Node being checked
         */
        @Override
        public boolean equals(Object pNode) {
            Node node = (Node)pNode;

            if ( node == null ) {
                return false;
            } else if ( getData() == node.getData() && getNext() == node.getNext() && getPrev() == node.getPrev() ) {
                return true;
            } else {
                return false;
            }
        }

        // mData accessor
        public Integer getData() {
            return mData;
        }

        // mNext accessor
        public Node getNext() {
            return mNext;
        }

        // mPrev accessor
        public Node getPrev() {
            return mPrev;
        }

        // mData mutator
        public void setData(Integer pData) {
            mData = pData;
        }

        // mNext mutator
        public void setNext(Node pNext) {
            mNext = pNext;
        }

        // mPrev mutator
        public void setPrev(Node pPrev) {
            mPrev = pPrev;
        }

        /**
         * Returns the data stored in this Node as a string value
         */
        @Override
        public String toString() {
            return "" + getData();
        }

    }

}