//设计实现双端队列。
//实现 MyCircularDeque 类:
//MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
//boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
//boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
//boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
//boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
//int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
//int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
//boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
//boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。

class MyCircularDeque {
    private int capacity ;
    private int front;
    private int rear;
    private int[] arr;

    public MyCircularDeque(int k) {
        capacity=k+1;
        arr=new int[capacity];
        front=0;
        rear=0;
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        else {
            front = ( front - 1  + capacity) % capacity;
            arr[front] = value;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        else {


            return true;
        }
    }

    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        front = ( front + 1 ) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        rear = ( rear - 1 + capacity ) % capacity;
        return true;    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return arr[front];
    }

    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return arr[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return ( rear + 1 ) % capacity == front;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */