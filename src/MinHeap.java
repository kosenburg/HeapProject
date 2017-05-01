import java.util.Arrays;

/**
 * Created by Kevin on 4/30/2017.
 */
public class MinHeap {
    private int[] heap;
    private int currentSize = 0;
    private long numberOfSwaps = 0;

    public MinHeap() {
        heap = new int[10];
    }

    public MinHeap(int[] values) {
        int currentSize = values.length;

        heap = new int[currentSize * 2];

        for (int i = 1; i < values.length; i++) {
            heap[i] = values[i - 1];
        }
        buildHeap();
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    private void percolateDown(int i) {

    }

    public void insert(int value) {
        if (currentSize == heap.length - 1) {
            increaseArray();
        }

        int hole = ++currentSize;
        heap[hole] = value;

        while(heap[currentSize] > heap[getParent(currentSize)]) {
            swap(currentSize, getParent(currentSize));
            currentSize = getParent(currentSize);
        }
    }

    private void swap(int firstPosition, int secondPosition) {
        numberOfSwaps++;
        int temp;
        temp = heap[firstPosition];
        heap[firstPosition] = heap[secondPosition];
        heap[secondPosition] = temp;
    }

    private void increaseArray() {
        heap = Arrays.copyOf(heap, heap.length * 2);
    }

    private int getParent(int position) {
        return position / 2;
    }

    public long getNumberOfSwaps() {
        return numberOfSwaps;
    }
}
