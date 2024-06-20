package data_structure.heap;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

//        System.out.println(heap.peek());

        heap.printHeap();

//        //75
       heap.delete(1);

        //40
//        heap.delete(5);

        // root
//        heap.delete(0);
//        heap.deleteRoot();

//        System.out.println(heap.peek());

//        heap.sort();
       heap.printHeap();


    }
}
