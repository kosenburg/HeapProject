import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kevin on 5/1/2017.
 */
public class MinHeapTest {
    @Test
    public void insert() throws Exception {
        MinHeap heap = new MinHeap();
        heap.insert(6);
        heap.insert(7);
        heap.insert(12);
        heap.insert(10);
        heap.insert(15);
        heap.insert(17);
        heap.insert(5);
        heap.printInOrder();
        Assert.assertEquals(2, heap.getNumberOfSwaps());


        heap = new MinHeap(new int[] {6,10,12,7,15,17,5});
        heap.printInOrder();

    }

    @Test
    public void getNumberOfSwaps() throws Exception {
    }

    @Test
    public void printInOrder() throws Exception {
    }

}