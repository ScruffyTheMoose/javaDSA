public class Stack {

    private DList mList;
    
    // Default Constructor that assigns a new DList to mList using setList()
    public Stack() {
        setList(new DList());
    }

    // Clears all elements from the list using the clear() method from DList
    public void clear() {
        mList.clear();
    }

    // Returns a boolean value (True if empty) using the isEmpty() method from DList
    public boolean isEmpty() {
        return mList.isEmpty();
    }
    
    // Returns the value at the top of the stack using the get() method from DList
    public Integer peek() {
        return mList.get(0);
    }

    // Deletes the element at the top of the stack and returns its value using the remove() method from DList
    public Integer pop() {
        Integer data = mList.remove(0);
        return data;
    }

    // Adds an element to the top of the stack using the prepend() method from DList
    public void push(Integer pData) {
        mList.prepend(pData);
    }

    // Overrides the toString() method inherited from the Object class
    // Returns a string containing all values in the stack using the toString() method from DList
    @Override
    public String toString() {
        return mList.toString();
    }

    // Accessor that returns the DList that the stack is operating on
    protected DList getList() {
        return mList;
    }

    // Mutator that sets the DList that the stack will operate on
    protected void setList(DList pList) {
        mList = pList;
    }

}
