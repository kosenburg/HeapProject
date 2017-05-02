import java.util.Random;

/**
 * Created by Kevin on 5/1/2017.
 */
public class Main {
    //TODO make graph of runs!
    public static void main(String[] args) {
    MinHeap heap = new MinHeap();

    int[] temp =  getRandomList(10);

    System.out.println("Insert Heap Run");
    long runTime = System.nanoTime();
        for (int value: temp) {
        heap.insert(value);
    }
        System.out.println("The run time is: " + (System.nanoTime() - runTime) + " ns");
        System.out.println("Performed " + heap.getNumberOfSwaps() + " swaps");
        heap.printInOrder();
        System.out.println();

        System.out.println("Build Heap Run");
        runTime = System.nanoTime();
        heap = new MinHeap(temp);
        System.out.println("The run time is: " + (System.nanoTime() - runTime) + " ns");
        heap.printInOrder();
}

    private static int[] getRandomList(int size) {
        int[] tempList = new int[size];

        Random random = new Random();

        for(int i = 0; i < size; i++) {
            tempList[i] = random.nextInt(100);
        }

        return tempList;
    }
}
