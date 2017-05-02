import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Kevin on 5/1/2017.
 */
public class Main {
    //TODO make graph of runs!
    private static BufferedWriter writer;

    public static void main(String[] args) throws IOException {


    }

    private static void executeRunCollections() throws IOException {
        writer = new BufferedWriter(new FileWriter("runTimeResults"));

        for (int i = 5000; i <= 50000; i += 5000 ) {
            int[] tempList = getRandomList(i);
            long insertTime = insertRunTime(tempList);
            long buildTime = buildRunTie(tempList);

            writer.write(i + "," + insertTime + "," + buildTime);
            writer.newLine();
            writer.flush();
        }
        writer.close();
    }

    private static long buildRunTie(int[] array) {
        System.out.println("Build Heap Run");
        long runTime = System.nanoTime();
        MinHeap heap = new MinHeap(array);

        return System.nanoTime() - runTime;
    }

    private static long insertRunTime(int[] array) {
        MinHeap heap = new MinHeap();

        System.out.println("Insert Heap Run");
        long runTime = System.nanoTime();
        for (int value: array) {
            heap.insert(value);
        }
        System.out.println("Number of swaps: " + heap.getNumberOfSwaps());

        return System.nanoTime() - runTime;
    }

    private static int[] getRandomList(int size) {
        int[] tempList = new int[size];

        Random random = new Random();

        for(int i = 0; i < size; i++) {
            tempList[i] = random.nextInt(100000);
        }

        return tempList;
    }
}
