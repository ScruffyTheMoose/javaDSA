public class Queue {

    private DList mList;

    public Queue() {
        setList(new DList());
    }

    public void clear() {
        mList.clear();
    }

    public Integer dequeue() {
        Integer data = mList.remove(0);
        return data;
    }

    public void enqueue(Integer pData) {
        mList.append(pData);
    }

    public boolean isEmpty() {
        return mList.isEmpty();
    }

    public Integer peek() {
        return mList.get(0);
    }

    public String toString() {
        return mList.toString();
    }

    protected DList getList() {
        return mList;
    }

    protected void setList(DList pList) {
        mList = pList;
    }
    
}
