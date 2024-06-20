package data_structure.heap;

/*
Max Heap implementation
 */
public class Heap {
    private int[] heap;
    private int size;

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public int getLeftChildIdx(int index) {
        return 2 * index + 1;
    }

    public int getRightChildIdx(int index) {
        return 2 * index + 2;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // log(n)
    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }
        heap[size] = value;
        fixHeapAbove(size);
        size++;

    }

    // log(n)
    public int delete(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        int parent = getParent(index);
        int deletedValue = heap[index];
        heap[index] = heap[size - 1];

        if ((index == 0) || (heap[index] < heap[parent])) {
            fixHeapBelow(index, size - 1);
        } else {
            fixHeapAbove(index);
        }

        size--;

        return deletedValue;
    }

    // O(log n)
    public int poll() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        int deletedRoot = heap[0];

        heap[0] = heap[size - 1];
        fixHeapBelow(0, size - 1);
        return deletedRoot;
    }

    // Heapify max heap
    private void fixHeapAbove(int index) {
        int newValue = heap[index];
        while ((index > 0) && (newValue > heap[getParent(index)])) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newValue;
    }

    private void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwap;
        while (index <= lastHeapIndex) {
            int leftChild = getLeftChildIdx(index);
            int rightChild = getRightChildIdx(index);
            // Has a left child?
            if (leftChild <= lastHeapIndex) {
                // Has no right child?
                if (rightChild > lastHeapIndex) {
                    // there is only left child and no right child
                    childToSwap = leftChild;
                }
                // has two children so swap with the one which has the greater value
                else {
                    childToSwap = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
                }
                if (heap[index] < heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                } else {
                    break;
                }
                index = childToSwap;
            }
            // no children so we done with heapify
            else {
                break;
            }
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        return heap[0];
    }

    /*
     * 1) swap the root with the last element in the heap
     * 2) heapify the heap except the last element
     */
    // o nlog(n)
    // if used will be no longer a heap
    public void sort() {
        int lastHeapIndex = size - 1;
        for (int i = 0; i < lastHeapIndex; i++) {
            int temp = heap[0];
            heap[0] = heap[lastHeapIndex - i];
            heap[lastHeapIndex - i] = temp;
            fixHeapBelow(0, lastHeapIndex - 1 - i);
        }
    }

    public void printHeap() {
        System.out.println("************");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + ", ");
        }
        System.out.println("\n************");
    }

}
