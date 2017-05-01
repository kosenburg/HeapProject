import java.util.Arrays;

/**
 * Created by Kevin on 5/1/2017.
 */
public class MinHeap {
    private static final int DEFAULT_HEAP_SIZE = 10;
    private int[] heap;
    private long numberOfSwaps = 0;
    private int currentHeapSize;

    public MinHeap() {
        setHeap(DEFAULT_HEAP_SIZE);
        currentHeapSize = 0;
    }

    public MinHeap(int[] array) {
        setHeap(array.length * 2);
        currentHeapSize = array.length;

        for (int i = 1; i <= array.length; i++) {
            heap[i] = array[i - 1];
        }

        buildHeap();
    }

    private void buildHeap() {
        System.out.println("Building heap..");
        for (int i = currentHeapSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    private void percolateDown(int hole) {
        int child;
        int temp = heap[hole];

        while( hole * 2 <= currentHeapSize) {
            child = hole * 2;
            if (child != currentHeapSize && heap[child + 1] < heap[child]) {
                child++;
            }

            if (heap[child] < temp) {
                heap[hole] = heap[child];
            } else {
                break;
            }
            hole = child;
        }
        heap[hole] = temp;
    }

    private void setHeap(int length) {
        heap = new int[length];
    }

    public void insert(int value) {
        checkSize();

        int hole = ++currentHeapSize;

        while (hole > 1 && value < heap[hole / 2]) {
            percolateUp(hole);
            hole = hole / 2;
        }

        heap[hole] = value;
    }


    private void percolateUp(int hole) {
        //System.out.println("Swapping " + heap[hole / 2] + " with " + heap[hole]);
        numberOfSwaps++;
        heap[hole] = heap[hole / 2];
    }

    private void checkSize() {
        if (currentHeapSize == heap.length - 1) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
    }

    public long getNumberOfSwaps() {
        return numberOfSwaps;
    }

    public void printInOrder() {
        for (int i = 1; i < currentHeapSize + 1; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
